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
    private NewsRepository newsRepository;

    @RequestMapping("/fetchNews")
    public @ResponseBody List<News> fetchNews(@RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
        return newsRepository.findByCreated(date);
    }

    @RequestMapping("/createNews")
    public @ResponseBody void createNews(@RequestBody News news) {
        newsRepository.save(news);
    }

    @RequestMapping("/updateNews")
    public @ResponseBody void updateNews(@RequestBody News news) {
        newsRepository.save(news);
    }

    @RequestMapping("/deleteNews")
    public @ResponseBody void deleteNews(@RequestParam("id") Long id) {
        newsRepository.delete(id);
    }
}
