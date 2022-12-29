package com.example.BancoEjercicio1.Servicios;

import com.example.BancoEjercicio1.BancoEjercicioApplication1;
import com.example.BancoEjercicio1.Entidades.Cuenta;
import com.example.BancoEjercicio1.Repositorios.UsuarioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BancoServicio {


    static ApplicationContext context1 = SpringApplication.run(BancoEjercicioApplication1.class);
    static UsuarioRepository repository = context1.getBean(UsuarioRepository.class);

    static List<Cuenta> usuarios = new ArrayList<>();
    static Scanner leer = new Scanner(System.in).useDelimiter("\n");
    int opcion;


    public BancoServicio() {


    }


    public void menu() {


        UsuarioServicio us = (UsuarioServicio) context1.getBean("usuarioServicio");
        CuentaServicio cs = (CuentaServicio) context1.getBean("cuentaServicio");
        us.setRepository(repository);
        cs.setRepository(repository);
        us.agregar();

        usuarios = repository.findAll();




        do {

            System.out.println("");
            System.out.println("Bienvenido al menu principal");
            System.out.println("Por favor, elija una opcion");
            System.out.println("---------------------------");
            System.out.println("1. Crear usuario");
            System.out.println("2. Mostrar lista de usuarios");
            System.out.println("3. Ingresar a su cuenta");
            System.out.println("4. Salir");


            try {
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        us.crearUsuario();
                        break;
                    case 2:
                        us.testFindAll();
                        break;
                    case 3:
                        cs.validar();
                        break;
                    case 4:
                        System.out.println("Usted ha salido del banco, que tenga un buen dia");
                        System.out.println("\"Feliz★* 。 • ˚ ˚ ˛ ˚ ˛ •\" +\n" +
                                "         \"•。★Navidad★ 。* 。\" +\n" +
                                "         \"° 。 ° ˛˚˛ * _Π_____*。*˚\" +\n" +
                                "         \"˚ ˛ •˛•˚ */______/~＼。˚ ˚ ˛\" +\n" +
                                "         \"˚ ˛ •˛• ˚ ｜ 田田 ｜門｜ ˚\" +\n" +
                                "         \"Y un feliz año nuevo\"");
                        break;


                }

            } catch (InputMismatchException a) {
                System.out.println("Error: solo se puede seleccionar numeros" + a);
                leer.nextLine();
            } catch (Exception b){
                System.out.println("Error, intente nuevamente" + b);
                leer.nextLine();

            }


        } while (opcion != 4);
    }


}
