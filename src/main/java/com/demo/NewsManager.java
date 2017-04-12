package com.demo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
public interface NewsManager {
    
    public News createNews(String subject, String content, LocalDate created);

    public void updateNews(Long id, String subject, String content, LocalDate created);

    public List<News> fetchNews(LocalDate date);

}
