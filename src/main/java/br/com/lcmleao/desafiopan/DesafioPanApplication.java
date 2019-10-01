package br.com.lcmleao.desafiopan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("br.com.lcmleao.desafiopan.repositories")
@EntityScan("br.com.lcmleao.desafiopan.entities")
public class DesafioPanApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPanApplication.class, args);
	}

}
