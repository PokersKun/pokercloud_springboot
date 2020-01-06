package xyz.ipkr.pokercloud.entity;

import java.io.Serializable;

public class ControlEntity implements Serializable {

    private Long id;

    private Integer code;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public Integer getCode() {
        return code;
    }
}
