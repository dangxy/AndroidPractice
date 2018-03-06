package com.dangxy.androidpractice.video;

import android.content.Intent;
import android.widget.RelativeLayout;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.base.BaseActivity;
import com.dangxy.androidpractice.video.entity.RecommandBodyValue;
import com.google.gson.Gson;
import com.youdu.activity.AdBrowserActivity;
import com.youdu.core.AdContextInterface;
import com.youdu.core.video.VideoAdContext;

import butterknife.BindView;

public class VideoActivity extends BaseActivity {


    @BindView(R.id.rl)
    RelativeLayout rl;
    private VideoAdContext mAdsdkContext;
    private VideoActivity mContext;

    @Override
    protected void initView() {
        RecommandBodyValue value = new RecommandBodyValue();

        value.setResource("http://vodkgeyttp8.vod.126.net/vodkgeyttp8/7vgvwxw3_48671910_shd.mp4?wsSecret=64e93bb08c74afd7f0ab023ee3c0049a&wsTime=1520307521");
        mContext = this;

        mAdsdkContext = new VideoAdContext(rl,
                new Gson().toJson(value), null);
        mAdsdkContext.setAdResultListener(new AdContextInterface() {
            @Override
            public void onAdSuccess() {
            }

            @Override
            public void onAdFailed() {
            }

            @Override
            public void onClickVideo(String url) {
                Intent intent = new Intent(mContext, AdBrowserActivity.class);
                intent.putExtra(AdBrowserActivity.KEY_URL, url);
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_video;
    }

}
