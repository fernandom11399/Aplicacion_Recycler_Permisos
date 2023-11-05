package com.example.aplicacion_recycler_permisos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.aplicacion_recycler_permisos.adapter.PermisosAdapter;
import com.example.aplicacion_recycler_permisos.models.Permiso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView rvPermisos;

        List<Permiso> ListaPermisos = new ArrayList<>();
        ListaPermisos.add(new Permiso(1139, Manifest.permission.CALL_PHONE, "Llamar"));
        ListaPermisos.add(new Permiso(1140, Manifest.permission.CAMERA, "Camara"));
        ListaPermisos.add(new Permiso(1141, Manifest.permission.ACCESS_FINE_LOCATION, "Ubicación precisa"));
        ListaPermisos.add(new Permiso(1142, Manifest.permission.ACCESS_COARSE_LOCATION, "Ubicación aproximada"));

        rvPermisos = findViewById(R.id.Permisorv);
        rvPermisos.setAdapter(new PermisosAdapter(ListaPermisos));
        rvPermisos.setLayoutManager(new LinearLayoutManager((this)));
        rvPermisos.setHasFixedSize(true);



    }
}