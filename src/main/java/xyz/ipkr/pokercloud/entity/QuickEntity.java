package xyz.ipkr.pokercloud.entity;

public class QuickEntity {

    private Long id;

    private Long device_id;

    private String username;

    public void setId(Long id) {
        this.id = id;
    }

    public void setDevice_id(Long device_id) {
        this.device_id = device_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public Long getDevice_id() {
        return device_id;
    }

    public String getUsername() {
        return username;
    }
}
