package com.example.BancoEjercicio1;


import com.example.BancoEjercicio1.Servicios.BancoServicio;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class BancoEjercicioApplication1 {


	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		BancoServicio service = (BancoServicio) context.getBean("bancoServicio");

		service.menu();






	}

}
