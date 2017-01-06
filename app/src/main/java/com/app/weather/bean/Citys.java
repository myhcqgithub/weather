package com.app.weather.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by wangshuo on 16/12/9.
 */
@Entity
public class Citys {
    @Id(autoincrement = true)
    private Long id;
    private String city;
    private String weather;
    private String duMax;
    private String duMin;
    @Generated(hash = 1618777564)
    public Citys(Long id, String city, String weather, String duMax, String duMin) {
        this.id = id;
        this.city = city;
        this.weather = weather;
        this.duMax = duMax;
        this.duMin = duMin;
    }
    public Citys( String city, String weather, String duMax, String duMin) {
        this.city = city;
        this.weather = weather;
        this.duMax = duMax;
        this.duMin = duMin;
    }
    @Generated(hash = 1693500448)
    public Citys() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getWeather() {
        return this.weather;
    }
    public void setWeather(String weather) {
        this.weather = weather;
    }
    public String getDuMax() {
        return this.duMax;
    }
    public void setDuMax(String duMax) {
        this.duMax = duMax;
    }
    public String getDuMin() {
        return this.duMin;
    }
    public void setDuMin(String duMin) {
        this.duMin = duMin;
    }
}
