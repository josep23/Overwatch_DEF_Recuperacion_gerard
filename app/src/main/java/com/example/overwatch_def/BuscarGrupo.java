package com.example.overwatch_def;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.overwatch_def.databinding.FragmentBuscarGrupoBinding;
import com.example.overwatch_def.databinding.FragmentLoginBinding;
import com.thekhaeng.pushdownanim.PushDownAnim;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class BuscarGrupo extends Fragment {
    NavController navController;
    private FragmentBuscarGrupoBinding binding;
    private Dialog dialog;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return (binding = FragmentBuscarGrupoBinding.inflate(inflater,container,false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        dialog = new Dialog(getActivity());
        binding.floatingActionButton.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.floatingActionButton2.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.floatingActionButton3.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.floatingActionButton4.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.floatingActionButton5.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.floatingActionButton6.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        binding.floatingActionButton7.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });binding.floatingActionButton8.setOnClickListener(v -> {
            dialog.setContentView(R.layout.popupaddgrupo);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
        });
        PushDownAnim.setPushDownAnimTo(binding.buttonBack3).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_buscarGrupo_to_login2);
                    }
                });
        PushDownAnim.setPushDownAnimTo(binding.buttonGrupos).setScale(PushDownAnim.MODE_SCALE,0.89f)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_buscarGrupo_to_teamFragment2);
                    }
                });
    }
}