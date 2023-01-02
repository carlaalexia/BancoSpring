package com.example.BancoEjercicio1;


import com.example.BancoEjercicio1.Servicios.BancoServicio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BancoEjercicioApplication1 {


	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BancoEjercicioApplication1.class);
		BancoServicio service = (BancoServicio) context.getBean("bancoServicio");

		service.menu();






	}

}
