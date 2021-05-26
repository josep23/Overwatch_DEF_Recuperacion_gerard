package com.example.overwatch_def;

import android.app.Application;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;


public class HeroesViewModel extends AndroidViewModel {
    private final HeroeRepositorio heroeRepositorio;
    MutableLiveData<Uri> imagenSeleccionada = new MutableLiveData<>();

    public HeroesViewModel(@NonNull Application application){
        super(application);

        heroeRepositorio = new HeroeRepositorio(application);
    }

    public void insertar(String nombre, String vida, String rol,String descripcion,String historia,String armaPrincipal, String habilidad1, String habilidad2,String ultimate, Uri imagenSeleccionada) {
        heroeRepositorio.insertar(nombre,vida,rol,descripcion,historia,armaPrincipal,habilidad1,habilidad2,ultimate,imagenSeleccionada);
    }
    public LiveData<List<Heroe>> obtener(){
        return heroeRepositorio.obtener();
    }

    public void establecerImagenSeleccionada(Uri uri) {
        imagenSeleccionada.setValue(uri);
    }
}