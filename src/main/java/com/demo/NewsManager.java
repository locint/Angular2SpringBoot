package com.demo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
public interface NewsManager {
    
    public News createNews(News newsDto);

    public void updateNews(News newsDto);

    public List<News> fetchNews(LocalDate date);

}
