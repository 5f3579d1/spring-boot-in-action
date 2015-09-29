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
public class Article extends TransactionalEntity {

    /**
     * 文章名称
     */
    private String title;

    /**
     * 文章内容
     */
    @Column(columnDefinition = "text")
    private String content;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 所属栏目ID
     */
    private Integer parentMenu;

    /**
     * 是否推荐, Y表示推荐, N反之
     */
    @Column(nullable = false, columnDefinition = "char(1)")
    private Character recommend = 'Y';

    /**
     * 0代表草稿，1代表发布，2代表顶置，-1代表删除
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private Integer state;

    /**
     * 文章序列，可以对文章的展示排序进行调整，如为空，则按照id大小排序
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
    private Account Modifier;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(int parentMenu) {
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account getModifier() {
        return Modifier;
    }

    public void setModifier(Account modifier) {
        this.Modifier = modifier;
    }

}
