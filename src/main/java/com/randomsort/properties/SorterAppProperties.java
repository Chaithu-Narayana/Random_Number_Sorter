package com.randomsort.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:sorterApp.properties")
public class SorterAppProperties {
	
	    @Value("${microservice-url}")
	    private String microserviceUrl;

		/**
		 * @return the microserviceUrl
		 */
		public String getMicroserviceUrl() {
			return microserviceUrl;
		}

		/**
		 * @param microserviceUrl the microserviceUrl to set
		 */
		public void setMicroserviceUrl(String microserviceUrl) {
			this.microserviceUrl = microserviceUrl;
		}


}
