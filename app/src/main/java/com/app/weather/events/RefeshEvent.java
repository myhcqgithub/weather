package com.app.weather.events;

/**
 * Created by wangshuo on 16/12/12.
 */

public class RefeshEvent {
    private int postion;
    private String city;

    public RefeshEvent(int postion, String city) {
        this.postion = postion;
        this.city = city;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "RefeshEvent{" +
                "postion=" + postion +
                ", city='" + city + '\'' +
                '}';
    }
}
