package org.example.myproject.repository;

import org.example.myproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by k on 9/15/15.
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByKeyword(String keyword);

}
