package ink.verge.lab.mbg.model;

import java.io.Serializable;

public class Contact implements Serializable {
    private Integer id;

    private String email;

    private String address;

    private Boolean isShow;

    private Boolean isShowOnHome;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsShowOnHome() {
        return isShowOnHome;
    }

    public void setIsShowOnHome(Boolean isShowOnHome) {
        this.isShowOnHome = isShowOnHome;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", email=").append(email);
        sb.append(", address=").append(address);
        sb.append(", isShow=").append(isShow);
        sb.append(", isShowOnHome=").append(isShowOnHome);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}