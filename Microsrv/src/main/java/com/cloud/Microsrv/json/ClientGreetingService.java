package com.cloud.Microsrv.json;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientGreetingService {

	@Autowired
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(ClientGreetingService.class
			.getName());

	public ClientGreetingService(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl: "http://" + serviceUrl;
	}

	/**
	 * The RestTemplate works because it uses a custom request-factory that uses
	 * Ribbon to look-up the service to use. This method simply exists to show
	 * this.
	 */
	@PostConstruct
	public void demoOnly() {
		// Can't do this in the constructor because the RestTemplate injection
		// happens afterwards.
		logger.warning("The RestTemplate request factory is "
				+ restTemplate.getRequestFactory());
	}

	public Greeting greeting (String name) {
	

		logger.info("greeting() invoked: for " + name);
		
		Greeting greeting =  restTemplate.getForObject(serviceUrl + "/greeting/{name}",Greeting.class, name);
	
		return greeting;
		
	}

	
}
