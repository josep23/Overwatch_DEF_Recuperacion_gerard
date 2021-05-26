package com.example.overwatch_def;

import android.app.Application;
import android.net.Uri;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HeroeRepositorio {
    Executor executor = Executors.newSingleThreadExecutor();
    private  final BaseDeDatos.Heroedao heroedao;
    public HeroeRepositorio(Application application) {
        heroedao = BaseDeDatos.getInstance(application).obtenerAlbymsDao();
    }

    public void insertar(String nombre, String vida, String rol,String descripcion,String historia,String armaPrincipal, String habilidad1, String habilidad2,String ultimate, Uri imagenSeleccionada) {
        executor.execute(() ->{
            heroedao.insertar(new Heroe(nombre, vida,rol,descripcion,habilidad1,historia,habilidad2,armaPrincipal,ultimate,imagenSeleccionada.toString()));
        });
    }
    public LiveData<List<Heroe>> obtener(){
        return heroedao.obtener();
    }
}
