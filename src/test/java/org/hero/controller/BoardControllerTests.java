package org.hero.controller;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml",
"file:src/main/webapp/WEB-INF/spring-config/dispatcher-servlet.xml"})
@Log4j
public class BoardControllerTests {
    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView()
        .getModelMap());
    }

    @Test
    public void testRegister() throws Exception{
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
        .param("title","Test New Title")
        .param("content","Test New Content")
        .param("writer","Test New Writer")).andReturn().getModelAndView().getViewName();

        log.info(resultPage);
    }

    @Test
    public void testGet() throws Exception{
        log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno","4")
        ).andReturn().getModelAndView().getModelMap());
    }

    @Test
    public void testModify() throws Exception{
        String resultpage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
        .param("bno","1")
        .param("title","changed Title")
        .param("content","aaa")
        .param("writer","user0")).andReturn().getModelAndView().getViewName();

        log.info(resultpage);
    }

    @Test
    public void testRemove()throws Exception{
        // Check before method execute if DB bno exists..
        String resultpage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
        .param("bno","8")).andReturn().getModelAndView().getViewName();
        log.info(resultpage);
    }

    @Test
    public void testListPaging() throws Exception{
        log.info(mockMvc.perform(
                MockMvcRequestBuilders.get("/board/list")
                .param("pageNum","2")
                .param("amount","10"))
                .andReturn().getModelAndView().getModelMap());
    }
}
