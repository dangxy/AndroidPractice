package com.dangxy.androidpractice.video.entity;

import com.youdu.module.monitor.Monitor;
import com.youdu.module.monitor.emevent.EMEvent;

import java.util.ArrayList;

/**
 * @author dangxueyi
 * @description
 * @date 2018/3/6
 */


public class RecommandBodyValue extends BaseModel {

    public int type;
    public String logo;
    public String title;
    public String info;
    public String price;
    public String text;
    public String site;
    public String from;
    public String zan;
    public ArrayList<String> url;

    //视频专用
    public String thumb;
    public String resource;
    public String resourceID;
    public String adid;
    public ArrayList<Monitor> startMonitor;
    public ArrayList<Monitor> middleMonitor;
    public ArrayList<Monitor> endMonitor;
    public String clickUrl;
    public ArrayList<Monitor> clickMonitor;
    public EMEvent event;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getZan() {
        return zan;
    }

    public void setZan(String zan) {
        this.zan = zan;
    }

    public ArrayList<String> getUrl() {
        return url;
    }

    public void setUrl(ArrayList<String> url) {
        this.url = url;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourceID() {
        return resourceID;
    }

    public void setResourceID(String resourceID) {
        this.resourceID = resourceID;
    }

    public String getAdid() {
        return adid;
    }

    public void setAdid(String adid) {
        this.adid = adid;
    }

    public ArrayList<Monitor> getStartMonitor() {
        return startMonitor;
    }

    public void setStartMonitor(ArrayList<Monitor> startMonitor) {
        this.startMonitor = startMonitor;
    }

    public ArrayList<Monitor> getMiddleMonitor() {
        return middleMonitor;
    }

    public void setMiddleMonitor(ArrayList<Monitor> middleMonitor) {
        this.middleMonitor = middleMonitor;
    }

    public ArrayList<Monitor> getEndMonitor() {
        return endMonitor;
    }

    public void setEndMonitor(ArrayList<Monitor> endMonitor) {
        this.endMonitor = endMonitor;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }

    public ArrayList<Monitor> getClickMonitor() {
        return clickMonitor;
    }

    public void setClickMonitor(ArrayList<Monitor> clickMonitor) {
        this.clickMonitor = clickMonitor;
    }

    public EMEvent getEvent() {
        return event;
    }

    public void setEvent(EMEvent event) {
        this.event = event;
    }
}