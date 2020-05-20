package com.example.demo.search;

import javax.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;

@Slf4j
public class LuceneIndexRefresh {

  public static void index(EntityManager entityManager) {
    log.debug("Start lucene indexing...");
    try {
      FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
      fullTextEntityManager.createIndexer().startAndWait();
    } catch (InterruptedException e) {
      log.warn("Error occurred trying to build Lucene Search indexes " + e.getMessage(), e);
    } finally {
      log.debug("Finished lucene indexing...");
    }
  }
}
