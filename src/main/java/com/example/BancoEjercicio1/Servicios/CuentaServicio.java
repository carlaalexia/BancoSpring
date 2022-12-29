package com.example.BancoEjercicio1.Servicios;


import com.example.BancoEjercicio1.Entidades.Cuenta;
import org.springframework.stereotype.Component;
import java.util.InputMismatchException;

@Component
public class CuentaServicio extends UsuarioServicio {



    public void validar() {

        System.out.println("Ingrese su nombre de usuario");
        String usuario = leer.next();
        System.out.println("Ingrese su contraseña");
        int contra = leer.nextInt();
        leer.nextLine();

        for (Cuenta aux : usuarios) {
            if (aux.getUsuarioNombre().equals(usuario) && aux.getContraseña() == contra) {
                System.out.println("Ha entrado en su cuenta");
                segundoMenu(aux);
            }
        }


    }


    public void segundoMenu(Cuenta c) {

        int op;

        System.out.println("------------------------------------------------");
        System.out.println("Bienvenido " + c.getNombre() + " " + c.getApellido());

        do {
            System.out.println(" ");
            System.out.println("¿Que desea realizar?");
            System.out.println("1. Hacer un deposito");
            System.out.println("2. Extraer plata");
            System.out.println("3. Transferir");
            System.out.println("4. Ver saldo actual");
            System.out.println("5. Volver al menu");

            op = leer.nextInt();

            switch (op) {
                case 1:
                    System.out.println("Usted va a realizar un deposito en su cuenta");
                    realizarDeposito(c);
                    repository.save(c);
                    break;
                case 2:
                    System.out.println("Usted va a extraer plata de su cuenta");
                    extraerPlata(c);
                    repository.save(c);
                    break;
                case 3:
                    System.out.println("Usted va a realizar una transferencia");
                    transferir(c);
                    repository.save(c);
                    break;
                case 4:
                    System.out.println("Consultar saldo actual");
                    saldoActual(c);
                case 5:
                    System.out.println("Usted ha salido de su cuenta");

            }

        } while (op != 5);
    }

    public static void realizarDeposito(Cuenta c) {

        boolean leido;
        System.out.println("¿Cuanto desea ingresar?");

        do {
            try {
                int deposito;
                deposito = leer.nextInt();
                c.setMontoDinero(c.getMontoDinero() + deposito);
                leido = true;
            } catch (InputMismatchException b) {

                System.out.println("Error, solo puede ingresar numeros enteros" + b);
                leido = false;

            }catch (Exception b){
                System.out.println("Error, intente nuevamente" + b);
                leer.nextLine();
                leido = false;
            }

        } while (leido == false);

        System.out.println("El dinero en su cuenta actualmente es de: " + c.getMontoDinero());

    }

    public static void extraerPlata(Cuenta c) {

        boolean leido;
        System.out.println("¿Cuanto desea sacar?");

        do {
            try {
                int extraer;
                extraer = leer.nextInt();

                if (extraer <= c.getMontoDinero()) {
                    c.setMontoDinero(c.getMontoDinero() - extraer);


                } else {
                    System.out.println("No tiene suficiente saldo");
                }
                leido = true;


            } catch (InputMismatchException b) {
                System.out.println("Error, solo puede ingresar numeros enteros " + b);
                leido = false;
            }catch (Exception b){
                System.out.println("Error, intente nuevamente" + b);
                leer.nextLine();
                leido = false;
            }


        } while (leido == false);
        System.out.println("El dinero en su cuenta actualmente es de: " + c.getMontoDinero());


    }

    public static void saldoActual(Cuenta c){

        System.out.println("Su saldo actual es de: " + c.getMontoDinero());

    }

    public void transferir(Cuenta c){

        System.out.println("¿A quien le desea trasnferir?");
        System.out.println("Lista de usuarios de nuestro Banco: ");
        for (Cuenta aux : usuarios) {
            System.out.println(" ");
            System.out.printf(aux.getUsuarioNombre() + "\n");

        }

        boolean leido;
        String usuario = leer.next();


        for (Cuenta aux : usuarios){
            if (aux.getUsuarioNombre().equals(usuario)){
                System.out.println("Usted le esta por enviar dinero a "+ aux.getApellido()+", "+ aux.getNombre() );
                System.out.println(" ");

                do {

                    try {
                        System.out.println("¿Cuanto desea enviar?");

                        int enviar = leer.nextInt();
                        if (enviar <= c.getMontoDinero()) {
                            aux.setMontoDinero(aux.getMontoDinero() + enviar);
                            c.setMontoDinero(c.getMontoDinero() - enviar);
                            System.out.println("Se ha enviado el dinero a " + aux.getApellido() + ", " + aux.getApellido());

                        } else {

                            System.out.println("No tiene suficiente saldo");
                        }
                        leido = true;

                    } catch (InputMismatchException b){

                        System.out.println("Solo puede ingresar numeros enteros " + b);
                        leido = false;
                    } catch (Exception b){
                        System.out.println("Error, intente nuevamente" + b);
                        leer.nextLine();

                    }

                } while (leido = false);


            }

        }

    }


}

