package com.amol.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

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
	
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
  
/*   NOTE:
 *  The configuration provided by below method can be avoided by adding below lines in application.yml file
 *  cxf:
      jaxrs:
    			component-scan: true
    			classes-scan-packages: com.amol.payments
 *  BESIDES:  below method could not help with autowiring of ServiceHelper classes. Looks like an issue with 2 different application contexts.   
 * @Bean
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
*/
   
}