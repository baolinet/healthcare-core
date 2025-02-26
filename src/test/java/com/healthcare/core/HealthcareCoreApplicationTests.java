package com.healthcare.core;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.healthcare.core.service.AppService;
import com.healthcare.core.utils.SignUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@SpringBootTest
@AutoConfigureMockMvc
class HealthcareCoreApplicationTests {

	@Test
	void contextLoads() {
	}

	 @Autowired
    private MockMvc mockMvc;

	@Test
    public void testHello() throws Exception{
		mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
				.andExpect(content().string("hello"));
	}

	    @Autowired
    AppService appService;

    @Test
    void testSign() {
        String appId = "app1";
        long timeMillis = System.currentTimeMillis();
        String appSecret = appService.getAppKey(appId);
        String sign = SignUtils.signWithHmacSha1(appSecret, appId + "-" + appSecret + "-" + timeMillis);
		System.out.println("appId = " + appId);
        System.out.println("timeMillis = " + timeMillis);
        System.out.println("sign = " + sign);
    }
}
