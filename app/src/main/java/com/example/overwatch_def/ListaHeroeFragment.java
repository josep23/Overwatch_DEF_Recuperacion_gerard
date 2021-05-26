package com.example.overwatch_def;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.overwatch_def.databinding.ViewholderHeroesBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class ListaHeroeFragment extends Fragment {
    private com.example.overwatch_def.databinding.FragmentListaHeroesBinding binding;
    private NavController navController;
    private HeroesViewModel heroesViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = com.example.overwatch_def.databinding.FragmentListaHeroesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        heroesViewModel = new ViewModelProvider(requireActivity()).get(HeroesViewModel.class);
        binding.irAInsertarHeroes.setOnClickListener(v ->{
            navController.navigate(R.id.action_listaHeroesFragment_to_insertarHeroesFragment);
        } );
        HeroesAdapter heroesAdapter = new HeroesAdapter();
        binding.listaHeroes.setAdapter(heroesAdapter);

        heroesViewModel.obtener().observe(getViewLifecycleOwner(), heroeList -> {
            heroesAdapter.establecerHeroeList(heroeList);
        });

    }

    class HeroesAdapter extends RecyclerView.Adapter<HeroeviewHolder>{

        List<Heroe> heroeList;

        @NonNull
        @Override
        public HeroeviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new HeroeviewHolder(ViewholderHeroesBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull HeroeviewHolder holder, int position) {
            Heroe heroe = heroeList.get(position);
            holder.binding.titulo.setText(heroe.nombre);
            holder.binding.anyo.setText(heroe.vida);
            holder.binding.titulo.setText(heroe.rol);
            holder.binding.anyo.setText(heroe.descripcion);
            holder.binding.titulo.setText(heroe.historia);
            holder.binding.anyo.setText(heroe.armaPrincipal);
            holder.binding.titulo.setText(heroe.habilidad1);
            holder.binding.anyo.setText(heroe.habilidad2);
            holder.binding.titulo.setText(heroe.ultimate);

            Glide.with(holder.itemView).load(heroe.imagen).into(holder.binding.imagen);
        }

        @Override
        public int getItemCount() {
            return heroeList == null ? 0 : heroeList.size();
        }

        void establecerHeroeList(List<Heroe> heroeList){
            this.heroeList = heroeList;
            notifyDataSetChanged();
        }
    }

    class HeroeviewHolder extends RecyclerView.ViewHolder{
        ViewholderHeroesBinding binding;

        public HeroeviewHolder(@NonNull ViewholderHeroesBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}