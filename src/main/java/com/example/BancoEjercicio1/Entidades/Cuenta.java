package com.example.BancoEjercicio1.Entidades;

import jakarta.persistence.Entity;

@Entity
public class Cuenta extends Usuario{


    private int numeroDeTarjeta;
    private String usuarioNombre;
    private int contraseña;

    private int montoDinero;

    public Cuenta() {
    }

    public Cuenta(String nombre, String apellido, String email, int edad, int telefono, String direccion,
                  int numeroDeTarjeta, String usuarioNombre, int contraseña, int montoDinero) {
        super(nombre, apellido, email, edad, telefono, direccion);
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.usuarioNombre = usuarioNombre;
        this.contraseña = contraseña;
        this.montoDinero = montoDinero;
    }



    public int getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public void setNumeroDeTarjeta(int numeroDeTarjeta) {
        this.numeroDeTarjeta = numeroDeTarjeta;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public int getContraseña() {
        return contraseña;
    }

    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    public int getMontoDinero() {
        return montoDinero;
    }

    public void setMontoDinero(int montoDinero) {
        this.montoDinero = montoDinero;
    }



}
