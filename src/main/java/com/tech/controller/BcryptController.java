package com.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tech.model.User;
import com.tech.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class BcryptController {
	
	@Autowired
    UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/intro", method = RequestMethod.GET)
	@ResponseBody
    public String intro() { 
		return "Brypt Password Encoder spring-boot-starter-parent: provides useful Maven defaults. It also provides a dependency-management section so that you can omit version tags for existing dependencies.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"spring-boot-starter-web: includes all the dependencies required to create a web app. This will avoid lining up different spring common project versions.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"spring-boot-starter-tomcat: enable an embedded Apache Tomcat 7 instance, by default. We have overriden this by defining our version. This can be also marked as provided if you wish to deploy the war to any other standalone tomcat.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"tomcat-embed-jasper: provides support for .jsp file rendering.\r\n" + 
				"\r\n" + 
				"\r\n" + 
				" \r\n" + 
				"\r\n" + 
				"spring-boot-starter-security: take care of all the required dependencies related to spring security.\r\n" + 
				"\r\n" + 
				"";
	}
	
	@RequestMapping(value = "/bsignup", method = RequestMethod.GET)
    public String bsignup() {
		return "bsignup.jsp";
	}
	
	@RequestMapping(value = "/badduser", method = RequestMethod.POST)
	@ResponseBody
    public String badduser(User user) {
		
		//user.setPassword();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User user1 = userRepository.save(user);
		System.out.println(user1);
		return "hello";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
    public String login(User user) {
		if (!passwordEncoder.matches(user.getPassword(), encodedPassword)) {
	        throw new BadCredentialsException("Bad password");
	    }
		return "hello";
	}
	
	
	
}
