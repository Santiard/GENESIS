package com.omar.genesis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class GenesisApplication
fun main(args: Array<String>) {
	runApplication<GenesisApplication>(*args)
}
