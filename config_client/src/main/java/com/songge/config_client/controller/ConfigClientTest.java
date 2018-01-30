package com.songge.config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
* @ClassName: ConfigClientTest  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author songge  
* @date 2018年1月30日  
*    
*/
@RestController
@RefreshScope
public class ConfigClientTest {
	@Value("${demo.title}")
	String title_str;
	
	@RequestMapping("/client_test")
	public String clientTest() {
		return title_str;
	}
}
