package com.spring.controller;

import com.spring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

	private Logger logger = LoggerFactory.getLogger(MovieController.class);

	@Autowired
	private RestTemplate restTemplate ;

	@GetMapping("/findUser/{userId}")
	public User findUserById(@PathVariable Long userId){
		String url = "http://cz.cyou-inc.com:9092/" + userId + "/showUser";
		User user = this.restTemplate.getForObject(url, User.class);
		logger.info("  result = {} ", user);
		return user ;
	}

}
