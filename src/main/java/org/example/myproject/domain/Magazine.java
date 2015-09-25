package org.example.myproject.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by k on 9/15/15.
 */
@Entity
@Table(name = "whw_magazine")
public class Magazine extends BaseModel {

    /**
     * 杂志名称
     */
    private String title;

    /**
     * 1代表发布， -1代表删除，上传即发布
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Integer state;

    /**
     * 所属栏目ID
     */
    private String parentMenu;

    /**
     * 杂志序列，可以对图片的展示排序进行调整，如为空，则按照id大小排序
     */
    private String position;

    /**
     * 创建人的用户名
     */
    @ManyToOne
    private User creator;

    /**
     * 修改人的用户名
     */
    @ManyToOne
    private User modifyor;

    @OneToMany(mappedBy = "magazine")
    private List<MagazinePicture> pictures = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public User getModifyor() {
        return modifyor;
    }

    public void setModifyor(User modifyor) {
        this.modifyor = modifyor;
    }

    public List<MagazinePicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<MagazinePicture> pictures) {
        this.pictures = pictures;
    }

}
