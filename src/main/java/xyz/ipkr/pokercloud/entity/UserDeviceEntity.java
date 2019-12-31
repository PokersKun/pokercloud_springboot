package xyz.ipkr.pokercloud.entity;

public class UserDeviceEntity {

    private Long id;

    private String username;

    private String device_id;

    private Byte is_quick;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public void setIs_quick(Byte is_quick) {
        this.is_quick = is_quick;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDevice_id() {
        return device_id;
    }

    public Byte getIs_quick() {
        return is_quick;
    }
}
