package com.example.overwatch_def;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Heroe {
    @PrimaryKey(autoGenerate = true)
    int id;
    String imagen;
    String nombre;
    String vida;
    String rol;
    String descripcion;
    String historia;
    String armaPrincipal;
    String habilidad1;
    String habilidad2;
    String ultimate;

    public Heroe(String imagen,String nombre, String vida, String rol,String descripcion,String historia,String armaPrincipal, String habilidad1, String habilidad2,String ultimate){
        this.imagen = imagen;
        this.nombre = nombre;
        this.vida = vida;
        this.rol = rol;
        this.descripcion = descripcion;
        this.historia = historia;
        this.armaPrincipal = armaPrincipal;
        this.habilidad1 = habilidad1;
        this.habilidad2 = habilidad2;
        this.ultimate = ultimate;
    }
}
