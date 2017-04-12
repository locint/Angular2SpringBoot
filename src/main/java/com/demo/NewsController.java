package com.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
@RestController
public class NewsController {
      
    private NewsManager newsManager;
    
    @RequestMapping("/")
    public List<News> fetchNews() {
        LocalDate date = LocalDate.now();
        return newsManager.fetchNews(date);
    }
    
}
