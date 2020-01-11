package com.tech;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App3bcryptApplication{

	public static void main(String[] args) {
		SpringApplication.run(App3bcryptApplication.class, args);
	}
	
	/*@Autowired
    private ApplicationContext appContext;   
	@Override
    public void run(String... args) throws Exception {

        String[] beans = appContext.getBeanDefinitionNames();
        Arrays.sort(beans);
        for (String bean : beans) {  
        	System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
        }
 	}*/
}
