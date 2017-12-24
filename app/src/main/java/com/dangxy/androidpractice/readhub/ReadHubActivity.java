package com.dangxy.androidpractice.readhub;

import android.widget.TextView;

import com.dangxy.androidpractice.R;
import com.dangxy.androidpractice.base.BaseActivity;
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
    private ReadHubPresenter readHubPresenter;


    @Override
    protected void initView() {
        readHubPresenter = new ReadHubPresenter(this);
        readHubPresenter.getData();
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_read_hub;
    }

    @Override
    public void getData(List<Topic> data) {

        tv.setText(data.get(1).getTitle());

    }
}
