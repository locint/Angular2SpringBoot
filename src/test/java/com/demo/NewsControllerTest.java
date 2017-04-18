package com.demo;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @author LocInt
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NewsControllerTest {

    @Mock
    private NewsManager newsManager;

    private MockMvc mockMvc;
    
    @InjectMocks
    private NewsController newsController;

    @Before
    public void setUp() {
        this.mockMvc = standaloneSetup(newsController).build();
    }

    @Ignore
    @Test
    public void testFetchNews() throws Exception {
        
        List<News> mockList = Lists.newArrayList();

        mockList.add(new News("Test", "Test2", LocalDate.now()));

        when(newsManager.fetchNews(LocalDate.now())).thenReturn(mockList);

        mockMvc.perform(get("/fetchNews")
                .header("Access-Control-Request-Method", "POST")
                .header("Origin", "http://localhost:4200"))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/test")
                .header("Access-Control-Request-Method", "POST")
                .header("Origin", "http://localhost:4200"))
                .andExpect(status().isNotFound());

    }
}
