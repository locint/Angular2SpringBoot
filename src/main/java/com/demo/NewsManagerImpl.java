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
    protected EntityManager em;
    
    @Autowired
    private NewsRepository newsRepository;
    
    @Override
    public News createNews(String subject, String content, LocalDate created) {
        return newsRepository.save(new News(subject, content, created));
    }

    @Override
    public void updateNews(Long id, String subject, String content, LocalDate created) {
        em.merge(new News(id, subject, content, created));
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
