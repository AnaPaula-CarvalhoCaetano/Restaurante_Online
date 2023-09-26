package com.api.OnlineRestaurantBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({
    "classpath:application.properties", 
    "classpath:gateway.properties",     
    "classpath:custom-filter.properties" 
})
public class OnlineRestaurantBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineRestaurantBackendApplication.class, args);
	}

}
