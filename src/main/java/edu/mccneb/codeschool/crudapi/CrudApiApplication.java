package edu.mccneb.codeschool.crudapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CrudApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApiApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return new RestTemplateBuilder().interceptors(
				(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) -> {
					request.getHeaders().set("X-RapidAPI-Key", "402a1dacfdfe0fca4d0b9bfe250cae7d");
					request.getHeaders().set("X-RapidAPI-Host", "https://api.themoviedb.org");
					return execution.execute(request, body);
				}
		).build();
	}
}
