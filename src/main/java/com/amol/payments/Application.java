package com.amol.payments;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.amol.payments.rest.service.AccountService;

/**
 * @author Amol Waghmare
 *
 */
@Configuration
@ComponentScan(basePackages="com.amol.payments")
@EnableAutoConfiguration
@EnableEurekaClient
@SpringBootApplication
public class Application {
	
	
	@Autowired
    private Bus bus;
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
  
    @Bean
    public Server rsServer() {
    		System.out.println(" Inside rsServer.");
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        //http://localhost:8080/services/account
        endpoint.setAddress("/");
        endpoint.setProvider(new JacksonJsonProvider());
        endpoint.setServiceBeans(Arrays.<Object>asList(new AccountService()));
        //endpoint.setFeatures(Arrays.asList(new Swagger2Feature()));
        return endpoint.create();
    }

}