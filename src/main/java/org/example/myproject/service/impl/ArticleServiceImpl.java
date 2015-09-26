package org.example.myproject.service.impl;

import org.example.myproject.domain.Article;
import org.example.myproject.repository.ArticleRepository;
import org.example.myproject.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import java.util.Optional;

/**
 * Created by k on 9/16/15.
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ArticleServiceImpl implements ArticleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public ArticleRepository repository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Article> findOne(long id) {
        return Optional.ofNullable(repository.findOne(id));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Optional<Article> create(Article article) {
        logger.info("> create");

        if (article.getId() != null) {
            logger.error("Attempted to create a Article, but id attribute was not null.");
            logger.info("< create");
            throw new EntityExistsException(
                    "Cannot create new Article with supplied id.  The id attribute must be null to create an entity.");
        }

        Article saved = repository.save(article);

        logger.info("< create");
        return Optional.ofNullable(saved);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Optional<Article> update(Article article) {

        logger.info("> update {}", article.getId());

        Article articleToUpdate = repository.findOne(article.getId());
        if (articleToUpdate == null) {
            logger.error(
                    "Attempted to update a Article, but the entity does not exist.");
            logger.info("< update {}", article.getId());
            throw new NoResultException("Requested Article not found.");
        }

        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setContent(article.getContent());

        Article updated = repository.save(articleToUpdate);

        logger.info("< update {}", updated.getId());
        return Optional.ofNullable(updated);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(long id) {
        logger.info("> delete {}", id);

        repository.delete(id);

        logger.info("< delete {}", id);
    }

    @Override
    public Optional<Article> findByKeyword(String keyword) {
        logger.info("> find by keyword: {}", keyword);

        Article article = repository.findByKeyword(keyword);

        logger.info("< find by keyword: {}", keyword);

        return Optional.ofNullable(article);
    }

}
