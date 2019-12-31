package xyz.ipkr.pokercloud.entity;

public class UserInfoEntity {

    private String phone;

    private String email;

    private String nickname;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

}
