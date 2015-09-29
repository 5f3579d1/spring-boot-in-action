package org.example.myproject.domain;

import org.example.myproject.domain.base.Account;
import org.example.myproject.domain.base.TransactionalEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Created by k on 9/15/15.
 */
@Entity
public class Pictrue extends TransactionalEntity {

    /**
     * 图片名称
     */
    private String title;

    /**
     * 0代表草稿，1代表发布， -1代表删除
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private int state;

    /**
     * 图片说明
     */
    private String explain;

    /**
     * 所属栏目ID
     */
    private String parentMenu;

    /**
     * 图片序列，可以对图片的展示排序进行调整，如为空，则按照id大小排序
     */
    private Integer position;

    /**
     * 创建人的用户名
     */
    @ManyToOne
    private Account creator;

    /**
     * 修改人的用户名
     */
    @ManyToOne
    private Account modifier;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(String parentMenu) {
        this.parentMenu = parentMenu;
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

}
