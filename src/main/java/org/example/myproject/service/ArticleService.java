package org.example.myproject.service;

import org.example.myproject.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Created by k on 9/16/15.
 */
public interface ArticleService {

    Page<Article> findAll(Pageable pageable);

    Optional<Article> findOne(long id);

    Optional<Article> create(Article article);

    Optional<Article> update(Article article);

    void delete(long id);

    Optional<Article> findByKeyword(String keyword);

}
