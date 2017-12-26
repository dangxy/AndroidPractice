package com.dangxy.androidpractice.readhub;

import com.dangxy.androidpractice.base.IBaseView;
import com.dangxy.androidpractice.entity.Topic;

import java.util.List;

/**
 * @author dangxueyi
 * @description
 * @date 2017/12/24
 */

public interface ReadHubView extends IBaseView {

    void getData(List<Topic> data);

    void setRefresh(List<Topic> data);

    void getFirstData(String s);
}
