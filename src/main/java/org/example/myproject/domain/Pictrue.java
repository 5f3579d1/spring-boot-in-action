package org.example.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by k on 9/15/15.
 */
@Entity
@Table(name = "whw_pictrue")
public class Pictrue extends TransactionalEntity {

    /**
     * 图片名称
     */
    private String title;

    /**
     * 0代表草稿，1代表发布， -1代表删除
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Integer state;

    /**
     * 图片说明
     */
    private String explain;

    /**
     * 所属栏目ID
     */
    private String parentmenu;

    /**
     * 图片序列，可以对图片的展示排序进行调整，如为空，则按照id大小排序
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

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getParentmenu() {
        return parentmenu;
    }

    public void setParentmenu(String parentmenu) {
        this.parentmenu = parentmenu;
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

}
