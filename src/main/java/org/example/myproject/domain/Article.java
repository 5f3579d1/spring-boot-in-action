package org.example.myproject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by k on 9/15/15.
 */
@Entity
@Table(name = "whw_article")
public class Article extends TransactionalEntity {

    /**
     * 文章名称
     */
    private String title;

    /**
     * 0代表草稿，1代表发布，2代表顶置，-1代表删除
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Integer state;

    /**
     * 文章内容
     */
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 所属栏目ID
     */
    private Integer parentMenu;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 是否推荐, Y表示推荐, N反之
     */
    @Column(nullable = false, columnDefinition = "char(1)")
    private Character recommend = 'Y';

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

    /**
     * 文章序列，可以对文章的展示排序进行调整，如为空，则按照id大小排序
     */
    private Integer position;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(Integer parentMenu) {
        this.parentMenu = parentMenu;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Character getRecommend() {
        return recommend;
    }

    public void setRecommend(Character recommend) {
        this.recommend = recommend;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

}
