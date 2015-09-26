package org.example.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by k on 9/28/15.
 */
@Entity
@Table(name = "whw_menu")
public class MyMenu extends TransactionalEntity {

    /**
     * 栏目名称
     */
    private String name;

    /**
     * 是否启用,Y表示启用，N表示不启用
     */
    @Column(nullable = false, columnDefinition = "char(1)")
    private Character yxbz;

    /**
     * 父节点的id，可空，空即代表一级栏目
     */
    private String parentNode;

    /**
     * 创建人的用户名
     */
    private String creator;

    /**
     * 栏目序列，可以对栏目的展示排序进行调整，如为空，则按照id大小排序
     */
    private String position;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getYxbz() {
        return yxbz;
    }

    public void setYxbz(Character yxbz) {
        this.yxbz = yxbz;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

}
