package xyz.ipkr.pokercloud.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


public class HistoryEntity implements Serializable {

    private Long id;

    private Long device_id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date;

    private String data_type;

    private String username;

    private String data;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public Date getDate() {
        return date;
    }

    public String getData_type() {
        return data_type;
    }

    public String getUsername() {
        return username;
    }

    public String getData() {
        return data;
    }
}
