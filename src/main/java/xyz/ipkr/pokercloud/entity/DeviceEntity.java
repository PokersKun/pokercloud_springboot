package xyz.ipkr.pokercloud.entity;

import java.io.Serializable;

public class DeviceEntity implements Serializable {

    private Long id;

    private Long device_id;

    private String name;

    private String type;

    private String location;

    private String manager;

    private Byte status;

    private Integer action;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public void setAction(Integer action) {
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getManager() {
        return manager;
    }

    public Byte getStatus() {
        return status;
    }

    public Integer getAction() {
        return action;
    }
}
