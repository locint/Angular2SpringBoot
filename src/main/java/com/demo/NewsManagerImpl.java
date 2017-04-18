package com.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author LocInt
 */
@Service
@Transactional
public class NewsManagerImpl implements NewsManager {
    
    private Logger log = Logger.getLogger(NewsManagerImpl.class);
            
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    private NewsRepository newsRepository;
    
    @Override
    public News createNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public void updateNews(News news) {
        em.merge(news);
    }

    @Override
    public List<News> fetchNews(LocalDate date) {

        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        Integer week = date.get(weekFields.weekOfWeekBasedYear());
        List<News> resultList = em.createQuery("FROM news t WHERE WEEK(t.created) = :week", News.class).
                setParameter("week", week).getResultList();
    
        return resultList;
    }

}
