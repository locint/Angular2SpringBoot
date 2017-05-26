package com.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private NewsRepository newsRepository;

    @Before
    public void setUp() {
        newsRepository.deleteAll();
    }
    
    @Test
    public void testCreateNews() {
        News news = new News("Test", "Test", LocalDate.now());
        news  = newsRepository.save(news);
        assertTrue(news.getSubject().equals("Test"));
    }

    @Test
    public void testUpdateNews() {
        News news = new News("Test", "Test", LocalDate.now());
        news = newsRepository.save(news);

        news.setSubject("Test2");
        news.setContent("Test2");
        newsRepository.save(news);
        
        news = newsRepository.findOne(news.getId());
        assertTrue(news.getSubject().equals("Test2"));
    }

    @Test
    public void testFetchNews() {
        newsRepository.save(new News("Test", "Test", LocalDate.now()));
        newsRepository.save(new News("Test2", "Test2", LocalDate.now()));
        Pageable pageable = new PageRequest(0, 3);

        Page<List<News>> news = newsRepository.findByCreated(pageable, LocalDate.now());
        
        assertTrue(news.getContent().size()==2);
    }
}
