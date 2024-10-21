package com.omar.genesis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
@EnableJpaRepositories
class GenesisApplication
fun main(args: Array<String>) {
	runApplication<GenesisApplication>(*args)
}


@Configuration
class WebMvcConfigurer: WebMvcConfigurer {
	override fun addCorsMappings(registry: CorsRegistry) {
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:4200")
			.allowedMethods("*")
			.allowedHeaders("*")
			.allowCredentials(true)
	}
}