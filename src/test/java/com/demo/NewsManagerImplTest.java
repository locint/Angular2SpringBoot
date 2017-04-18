package com.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author LocInt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsManagerImplTest {
    
    @Autowired
    private NewsManager newsManager;
    
    @Autowired
    private NewsRepository newsRepository;

    @Before
    public void setUp() {
        newsRepository.deleteAll();
    }
    
    @Test
    public void testCreateNews() {
        News news = new News("Test", "Test", LocalDate.now());
        news  = newsManager.createNews(news);
        assertTrue(news.getSubject().equals("Test"));
    }

    @Test
    public void testUpdateNews() {
        News news = new News("Test", "Test", LocalDate.now());
        news = newsManager.createNews(news);

        news.setSubject("Test2");
        news.setContent("Test2");
        newsManager.updateNews(news);
        
        news = newsRepository.findOne(news.getId());
        assertTrue(news.getSubject().equals("Test2"));
    }

    @Test
    public void testFetchNews() {
        newsManager.createNews(new News("Test", "Test", LocalDate.now()));
        newsManager.createNews(new News("Test2", "Test2", LocalDate.now()));
        
        List<News> news = newsManager.fetchNews(LocalDate.now());
        
        assertTrue(news.size()==2);
    }
}
