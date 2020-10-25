package ink.verge.lab.mbg.model;

import java.io.Serializable;

public class Introduction implements Serializable {
    private Integer id;

    private String content;

    private String photo;

    private Boolean isShow;

    private Boolean isShowOnHome;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        sb.append(", content=").append(content);
        sb.append(", photo=").append(photo);
        sb.append(", isShow=").append(isShow);
        sb.append(", isShowOnHome=").append(isShowOnHome);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}