package ink.verge.lab.controller.viewobject;

import java.util.List;

/**
 * @Author Verge
 * @Date 2020/10/27 19:25
 * @Version 1.0
 */
public class DirectionVO {
    private Integer id;

    private String name;

    private String introduction;

    private String photo;

    private Boolean isShow;

    private List<String> photos;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    @Override
    public String toString() {
        return "DirectionVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", photo='" + photo + '\'' +
                ", isShow=" + isShow +
                ", photos=" + photos +
                '}';
    }
}
