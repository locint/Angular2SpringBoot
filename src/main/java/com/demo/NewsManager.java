package com.demo;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
public interface NewsManager {
    
    News createNews(News newsDto);

    void updateNews(News newsDto);

    List<News> fetchNews(LocalDate date);

}
