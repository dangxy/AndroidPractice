package com.dangxy.androidpractice.readhub;

import android.support.v4.widget.SwipeRefreshLayout;
import android.widget.TextView;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.base.BaseActivity;
import com.dangxy.androidpractice.base.IBaseNewPresenter;
import com.dangxy.androidpractice.entity.Topic;

import java.util.List;

import butterknife.BindView;

/**
 * @author dangxy99
 * @description 描述
 * @date 2017/12/24
 */
public class ReadHubActivity extends BaseActivity implements ReadHubView {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.sw_refresh_readhub)
    SwipeRefreshLayout swRefreshReadhub;
    private ReadHubPresenter readHubPresenter;
    private int i = 1;


    @Override
    protected void initView() {

    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_read_hub;
    }

    @Override
    public void getData(List<Topic> data) {

        tv.setText(data.get(1).getTitle());

    }

    @Override
    public void setRefresh(List<Topic> data) {
        i++;
        tv.setText(data.get(i).getTitle());
    }

    @Override
    protected IBaseNewPresenter initPresenter() {
        readHubPresenter = new ReadHubPresenter(this);
        readHubPresenter.getData();
        readHubPresenter.setRefresh(swRefreshReadhub);
        return readHubPresenter;
    }
}
