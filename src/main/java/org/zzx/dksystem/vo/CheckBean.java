package org.zzx.dksystem.vo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class CheckBean implements Serializable {
    private static final long serialVersionUID = 48L;

    private int id;
    private String dutyDay;
    private String unType;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;
    private boolean result;

    //无参构造器
    public CheckBean() { }

    public CheckBean(int id, String dutyDay, String unType, Date time, boolean result) {
        this.id = id;
        this.dutyDay = dutyDay;
        this.unType = unType;
        this.time = time;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDutyDay() {
        return dutyDay;
    }

    public void setDutyDay(String dutyDay) {
        this.dutyDay = dutyDay;
    }

    public String getUnType() {
        return unType;
    }

    public void setUnType(String unType) {
        this.unType = unType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
