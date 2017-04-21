package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author LocInt
 */
@RestController
public class NewsController {

    @Autowired
    private NewsManager newsManager;

    @RequestMapping("/fetchNews")
    public @ResponseBody List<News> fetchNews(@RequestParam("date") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
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
