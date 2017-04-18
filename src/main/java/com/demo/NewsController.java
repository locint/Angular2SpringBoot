package com.demo;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
@RestController
public class NewsController {
      
    private NewsManager newsManager;
    
    @RequestMapping("/fetchNews")
    public @ResponseBody List<News> fetchNews(@RequestParam LocalDate date) {
        return newsManager.fetchNews(date);
    }

    @RequestMapping("/createNews")
    public @ResponseBody void createNews(@RequestBody News news) {
        newsManager.createNews(news);
    }

    @RequestMapping("/updateNews")
    public @ResponseBody void updateNews(@RequestBody News news) {
        newsManager.updateNews(news);
    }
}
