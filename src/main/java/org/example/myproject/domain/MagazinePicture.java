package org.example.myproject.domain;

import org.example.myproject.domain.base.Account;
import org.example.myproject.domain.base.TransactionalEntity;

import javax.persistence.*;

/**
 * Created by k on 9/15/15.
 */
@Entity
public class MagazinePicture extends TransactionalEntity {

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
     * 图片序列，可以对图片的展示排序进行调整，如为空，则按照id大小排序
     */
    private Integer position;

    /**
     * 创建人的用户名
     */
    private Account creator;

    /**
     * 修改人的用户名
     */
    private Account modifier;

    @ManyToOne
    private Magazine magazine;

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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account getModifier() {
        return modifier;
    }

    public void setModifier(Account modifier) {
        this.modifier = modifier;
    }

    public Magazine getMagazine() {
        return magazine;
    }

    public void setMagazine(Magazine magazine) {
        this.magazine = magazine;
    }

}
