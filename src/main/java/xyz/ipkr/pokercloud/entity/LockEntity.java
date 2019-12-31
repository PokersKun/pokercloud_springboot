package xyz.ipkr.pokercloud.entity;

public class LockEntity {

    private Long id;

    private String name;

    private Byte status;

    private Integer action;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public Byte getStatus() {
        return status;
    }

    public Integer getAction() {
        return action;
    }
}
