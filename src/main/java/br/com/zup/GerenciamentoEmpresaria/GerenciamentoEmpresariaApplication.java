package br.com.zup.GerenciamentoEmpresaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GerenciamentoEmpresariaApplication {
	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoEmpresariaApplication.class, args);
	}

}
