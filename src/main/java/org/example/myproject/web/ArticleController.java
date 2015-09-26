package org.example.myproject.web;

import org.example.myproject.domain.Article;
import org.example.myproject.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * Created by k on 9/22/15.
 */
@RestController
@RequestMapping("/articles")
public class ArticleController extends BaseController {

    @Autowired
    private ArticleService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity get(Pageable pageable) {
        logger.info("> get articles");

        Page<Article> articles = service.findAll(pageable);

        logger.info("< get articles");
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable Long id) {
        logger.info("> get article");

        Optional<Article> article = service.findOne(id);
        if (article == null) {
            logger.info("< get article");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("< get article");

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity create(Article article) {
        logger.info("> post article");

        Optional<Article> saved = service.create(article);

        logger.info("< post article");
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity update(Article article) {
        logger.info("> put article");

        Optional<Article> updated = service.update(article);

        logger.info("< put article");
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id) {
        logger.info("> delete article");

        service.delete(id);

        logger.info("< delete article");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
