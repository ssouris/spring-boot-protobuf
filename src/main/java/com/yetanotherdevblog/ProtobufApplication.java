package com.yetanotherdevblog;

import com.yetanotherdevblog.models.RecipeOuterClass;
import com.yetanotherdevblog.models.TimingOuterClass;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@RestController
@SpringBootApplication
public class ProtobufApplication extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
				.defaultContentType(MediaType.APPLICATION_JSON)
				.favorPathExtension(true)
				.favorParameter(true)
				.parameterName("format")
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON);
	}

	@Bean
	public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	static final TimingOuterClass.Timing COMMENT =
			TimingOuterClass.Timing.newBuilder()
								   .setBlocked(1)
								   .setComment("comment")
								   .setConnect(12)
								   .build();

	static final RecipeOuterClass.Recipe RECIPE =
			RecipeOuterClass.Recipe.newBuilder()
								   .setPageref("p2")
								   .setTime(12)
								   .setSomeLongValue(123L)
								   .addTimings(COMMENT)
									.build();

	@GetMapping("/api")
	public RecipeOuterClass.Recipe getRecipe() {
		return RECIPE;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProtobufApplication.class, args);
	}

}
