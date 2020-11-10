package com.superheroes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
@TestPropertySource("/application.properties")
public class HeroesTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void heroStartTest() throws Exception {
        this.mockMvc.perform(get("/all/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"fullName\":\"Oleg\",\"birthDate\":\"26 febrary\"," +
                        "\"city\":\"Minsk\",\"mainSkill\":\"engineer\",\"gender\":\"men\",\"phone\":6565788}" +
                        ",{\"id\":2,\"fullName\":\"Nata\",\"birthDate\":\"18 July\",\"city\":\"Moscow\"," +
                        "\"mainSkill\":\"Doctor\",\"gender\":\"Woman\",\"phone\":7777777}]")));

    }
    @Test
    public void configtHero() throws Exception {

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/all/")
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();

        System.out.println(mvcResult.getResponse());

    }
}