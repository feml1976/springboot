package com.msvc.spring.fml_web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource(value="classpath:parameters.properties", encoding = "UTF-8"),
	@PropertySource(value="classpath:configuration.properties", encoding = "UTF-8"),
	@PropertySource(value="classpath:seed.parameters.properties", encoding = "UTF-8")
})
public class ParametersConfig {


}
