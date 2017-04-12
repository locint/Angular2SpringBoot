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
        News news  = newsManager.createNews("Test", "Test", LocalDate.now());
        assertTrue(news.getSubject().equals("Test"));
    }

    @Test
    public void testUpdateNews() {
        News news = newsManager.createNews("Test", "Test", LocalDate.now());
        newsManager.updateNews(news.getId(), "Test2", "Test2", LocalDate.now());
        
        news = newsRepository.findOne(news.getId());
        assertTrue(news.getSubject().equals("Test2"));
    }

    @Test
    public void testFetchNews() {

        newsManager.createNews("Test", "Test", LocalDate.now());
        newsManager.createNews("Test2", "Test2", LocalDate.now());
        
        List<News> news = newsManager.fetchNews(LocalDate.now());
        
        assertTrue(news.size()==2);
    }
}
