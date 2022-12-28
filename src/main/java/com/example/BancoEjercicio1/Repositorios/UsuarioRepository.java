package com.example.BancoEjercicio1.Repositorios;

import com.example.BancoEjercicio1.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//esta clase es un bean

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {


}