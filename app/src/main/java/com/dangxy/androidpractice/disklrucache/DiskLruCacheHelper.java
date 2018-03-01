package com.dangxy.androidpractice.disklrucache;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.util.Log;

/**********************************************************
 * @文件名称：DiskLruCacheHelper.java
 * @文件作者：renzhiqiang
 * @创建时间：2015年8月26日 下午10:47:01
 * @文件描述：硬盘缓存帮助类
 * @修改历史：2015年8月26日创建初始版本
 **********************************************************/
public class DiskLruCacheHelper
{
	private static final String DIR_NAME = "diskCache";
	private static final int MAX_COUNT = 5 * 1024 * 1024;
	private static final int DEFAULT_APP_VERSION = 1;

	private static final String TAG = "DiskLruCacheHelper";

	private DiskLruCache mDiskLruCache;

	public DiskLruCacheHelper(Context context) throws IOException
	{
		mDiskLruCache = generateCache(context, DIR_NAME, MAX_COUNT);
	}

	public DiskLruCacheHelper(Context context, String dirName) throws IOException
	{
		mDiskLruCache = generateCache(context, dirName, MAX_COUNT);
	}

	public DiskLruCacheHelper(Context context, String dirName, int maxCount) throws IOException
	{
		mDiskLruCache = generateCache(context, dirName, maxCount);
	}

	// custom cache dir
	public DiskLruCacheHelper(File dir) throws IOException
	{
		mDiskLruCache = generateCache(null, dir, MAX_COUNT);
	}

	public DiskLruCacheHelper(Context context, File dir) throws IOException
	{
		mDiskLruCache = generateCache(context, dir, MAX_COUNT);
	}

	public DiskLruCacheHelper(Context context, File dir, int maxCount) throws IOException
	{
		mDiskLruCache = generateCache(context, dir, maxCount);
	}

	private DiskLruCache generateCache(Context context, File dir, int maxCount) throws IOException
	{
		if (!dir.exists() || !dir.isDirectory())
		{
			throw new IllegalArgumentException(dir + " is not a directory or does not exists. ");
		}

		int appVersion = context == null ? DEFAULT_APP_VERSION : Utils.getAppVersion(context);

		DiskLruCache diskLruCache = DiskLruCache.open(dir, appVersion, DEFAULT_APP_VERSION, maxCount);

		return diskLruCache;
	}

	private DiskLruCache generateCache(Context context, String dirName, int maxCount) throws IOException
	{
		DiskLruCache diskLruCache = DiskLruCache.open(getDiskCacheDir(context, dirName), Utils.getAppVersion(context),
				DEFAULT_APP_VERSION, maxCount);
		return diskLruCache;
	}

	// =======================================
	// ============== String 数据 读写 =============
	// =======================================

	public void put(String key, String value)
	{
		DiskLruCache.Editor edit = null;
		BufferedWriter bw = null;
		try
		{
			edit = editor(key);
			if (edit == null)
				return;
			OutputStream os = edit.newOutputStream(0);
			bw = new BufferedWriter(new OutputStreamWriter(os));
			bw.write(value);
			edit.commit();// write CLEAN
		}
		catch (IOException e)
		{
			e.printStackTrace();
			try
			{
				edit.abort();// write REMOVE
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try
			{
				if (bw != null)
					bw.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public String getAsString(String key)
	{
		InputStream inputStream = null;
		try
		{
			// write READ
			inputStream = get(key);
			if (inputStream == null)
				return null;
			StringBuilder sb = new StringBuilder();
			int len = 0;
			byte[] buf = new byte[128];
			while ((len = inputStream.read(buf)) != -1)
			{
				sb.append(new String(buf, 0, len));
			}
			return sb.toString();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			if (inputStream != null)
				try
				{
					inputStream.close();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
		}
		return null;
	}

	public void put(String key, JSONObject jsonObject)
	{
		put(key, jsonObject.toString());
	}

	public JSONObject getAsJson(String key)
	{
		String val = getAsString(key);
		try
		{
			if (val != null)
				return new JSONObject(val);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	// =======================================
	// ============ JSONArray 数据 读写 =============
	// =======================================

	public void put(String key, JSONArray jsonArray)
	{
		put(key, jsonArray.toString());
	}

	public JSONArray getAsJSONArray(String key)
	{
		String JSONString = getAsString(key);
		try
		{
			JSONArray obj = new JSONArray(JSONString);
			return obj;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	// =======================================
	// ============== byte 数据 读写 =============
	// =======================================

	/**
	 * 保存 byte数据 到 缓存中
	 *
	 * @param key   保存的key
	 * @param value 保存的数据
	 */
	public void put(String key, byte[] value)
	{
		OutputStream out = null;
		DiskLruCache.Editor editor = null;
		try
		{
			editor = editor(key);
			if (editor == null)
			{
				return;
			}
			out = editor.newOutputStream(0);
			out.write(value);
			out.flush();
			editor.commit();// write CLEAN
		}
		catch (Exception e)
		{
			e.printStackTrace();
			try
			{
				editor.abort();// write REMOVE
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}

		}
		finally
		{
			if (out != null)
			{
				try
				{
					out.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public byte[] getAsBytes(String key)
	{
		byte[] res = null;
		InputStream is = get(key);
		if (is == null)
			return null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try
		{
			byte[] buf = new byte[256];
			int len = 0;
			while ((len = is.read(buf)) != -1)
			{
				baos.write(buf, 0, len);
			}
			res = baos.toByteArray();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return res;
	}

	// =======================================
	// ============== 序列化 数据 读写 =============
	// =======================================
	public void put(String key, Serializable value)
	{
		DiskLruCache.Editor editor = editor(key);
		ObjectOutputStream oos = null;
		if (editor == null)
			return;
		try
		{
			OutputStream os = editor.newOutputStream(0);
			oos = new ObjectOutputStream(os);
			oos.writeObject(value);
			oos.flush();
			editor.commit();
		}
		catch (IOException e)
		{
			e.printStackTrace();
			try
			{
				editor.abort();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		finally
		{
			try
			{
				if (oos != null)
					oos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T getAsSerializable(String key)
	{
		T t = null;
		InputStream is = get(key);
		ObjectInputStream ois = null;
		if (is == null)
			return null;
		try
		{
			ois = new ObjectInputStream(is);
			t = (T) ois.readObject();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (ois != null)
					ois.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return t;
	}

	// =======================================
	// ============== bitmap 数据 读写 =============
	// =======================================
	public void put(String key, Bitmap bitmap)
	{
		put(key, Utils.bitmap2Bytes(bitmap));
	}

	public Bitmap getAsBitmap(String key)
	{
		byte[] bytes = getAsBytes(key);
		if (bytes == null)
			return null;
		return Utils.bytes2Bitmap(bytes);
	}

	// =======================================
	// ============= drawable 数据 读写 =============
	// =======================================
	public void put(String key, Drawable value)
	{
		put(key, Utils.drawable2Bitmap(value));
	}

	public Drawable getAsDrawable(String key)
	{
		byte[] bytes = getAsBytes(key);
		if (bytes == null)
		{
			return null;
		}
		return Utils.bitmap2Drawable(Utils.bytes2Bitmap(bytes));
	}

	// =======================================
	// ============= other methods =============
	// =======================================
	public boolean remove(String key)
	{
		try
		{
			key = Utils.hashKeyForDisk(key);
			return mDiskLruCache.remove(key);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return false;
	}

	public void close() throws IOException
	{
		mDiskLruCache.close();
	}

	public void delete() throws IOException
	{
		mDiskLruCache.delete();
	}

	public void flush() throws IOException
	{
		mDiskLruCache.flush();
	}

	public boolean isClosed()
	{
		return mDiskLruCache.isClosed();
	}

	public long size()
	{
		return mDiskLruCache.size();
	}

	public void setMaxSize(long maxSize)
	{
		mDiskLruCache.setMaxSize(maxSize);
	}

	public File getDirectory()
	{
		return mDiskLruCache.getDirectory();
	}

	public long getMaxSize()
	{
		return mDiskLruCache.getMaxSize();
	}

	// =======================================
	// ===遇到文件比较大的，可以直接通过流读写 =====
	// =======================================
	// Basic editor
	public DiskLruCache.Editor editor(String key)
	{
		try
		{
			// wirte DIRTY
			DiskLruCache.Editor edit = mDiskLruCache.edit(key);
			// edit maybe null :the entry is editing
			if (edit == null)
			{
				Log.w(TAG, "the entry spcified key:" + key + " is editing by other . ");
			}
			return edit;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Basic get
	 */
	public InputStream get(String key)
	{
		DiskLruCache.Snapshot snapShot;
		try
		{
			snapShot = mDiskLruCache.get(Utils.hashKeyForDisk(key));
			if (snapShot != null)
			{
				return snapShot.getInputStream(0);
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return null;
	}

	public boolean put(String key, InputStream inputStream)
	{
		OutputStream os = null;
		DiskLruCache.Editor editor = editor(Utils.hashKeyForDisk(key));
		if (editor != null)
		{
			try
			{
				os = editor.newOutputStream(0);
				int length;
				byte[] buffer = new byte[1024];
				while ((length = inputStream.read(buffer)) != -1)
				{
					os.write(buffer, 0, length);
				}
				editor.commit();
				return true;
			}
			catch (Exception e)
			{
				try
				{
					editor.abort();
				}
				catch (IOException e1)
				{
					e1.printStackTrace();
				}
			}
			finally
			{
				if (os != null)
				{
					try
					{
						inputStream.close();
						os.close();
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
				}
			}

		}
		return false;
	}

	// =======================================
	// ============== 序列化 数据 读写 =============
	// =======================================

	private File getDiskCacheDir(Context context, String uniqueName)
	{
		String cachePath;
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable())
		{
			cachePath = context.getExternalCacheDir().getPath();
		}
		else
		{
			cachePath = context.getCacheDir().getPath();
		}
		return new File(cachePath + File.separator + uniqueName);
	}
}