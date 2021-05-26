package com.example.overwatch_def;

import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.overwatch_def.databinding.FragmentInsertarHeroeBinding;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static androidx.core.content.ContextCompat.checkSelfPermission;


public class InsertarheroesFragment extends Fragment {

    private FragmentInsertarHeroeBinding binding;

    Uri imagenSeleccionada;
    private HeroesViewModel heroesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentInsertarHeroeBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        heroesViewModel = new ViewModelProvider(requireActivity()).get(HeroesViewModel.class);

        binding.imagen.setOnClickListener(v ->{
            abrirGaleria();
        });

        binding.insertar.setOnClickListener(v ->{
            String nombre = binding.titulo.getText().toString();
            String vida = binding.anyo.getText().toString();
            String rol = binding.anyo.getText().toString();
            String descripcion = binding.anyo.getText().toString();
            String historia = binding.anyo.getText().toString();
            String armaPrincipal = binding.anyo.getText().toString();
            String habilidad1 = binding.anyo.getText().toString();
            String habilidad2 = binding.anyo.getText().toString();
            String ultimate = binding.anyo.getText().toString();

            heroesViewModel.insertar(nombre,vida,rol,descripcion,historia,armaPrincipal,habilidad1,habilidad2,ultimate,imagenSeleccionada);
            navController.popBackStack();
        });
    }
    private void abrirGaleria(){
        if(checkSelfPermission(requireContext(),READ_EXTERNAL_STORAGE)== PERMISSION_GRANTED){
            lanzadorGaleria.launch("image/*");
            }else{
             lanzadorPermisos.launch(READ_EXTERNAL_STORAGE);
        }
    }

    private final ActivityResultLauncher<String>lanzadorGaleria =
            registerForActivityResult(new ActivityResultContracts.GetContent(), uri ->{
               heroesViewModel.establecerImagenSeleccionada(uri);
                imagenSeleccionada = uri;
               Glide.with(requireView()).load(uri).into(binding.imagen);
            });
    private final ActivityResultLauncher<String> lanzadorPermisos =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted ->{
                if (isGranted){
                    lanzadorGaleria.launch("image/*");
                }
            });
}