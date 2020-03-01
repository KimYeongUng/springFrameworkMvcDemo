package org.hero.controller;

import com.google.gson.Gson;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.hero.domain.Ticket;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml",
        "file:src/main/webapp/WEB-INF/spring-config/dispatcher-servlet.xml"})
@Log4j
public class SampleControllerTest {
    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testConvert() throws Exception{
        Ticket ticket = new Ticket();
        ticket.setTno(123);
        ticket.setOwner("Hero");
        ticket.setGrade("AAA");

        String jsonStr = new Gson().toJson(ticket);

        log.info(jsonStr);

        mockMvc.perform(post("/sample/ticket")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr)).andExpect(status().is(200));
    }
}
