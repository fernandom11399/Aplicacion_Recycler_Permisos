package com.example.aplicacion_recycler_permisos.adapter;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Context;
import android.app.Activity;


import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacion_recycler_permisos.R;
import com.example.aplicacion_recycler_permisos.models.Permiso;

import java.util.List;

public class PermisosAdapter extends RecyclerView.Adapter<PermisosAdapter.ViewHolder> {

    private List<Permiso> LP;

    public PermisosAdapter(List<Permiso> LP) {
        this.LP = LP;
    }

    @NonNull
    @Override
    public PermisosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.permisositem, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PermisosAdapter.ViewHolder holder, int position) {
        Permiso p = LP.get(position);
        holder.setData(p);
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txPermiso;
        Switch swPermiso;
        Permiso PermisoH;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txPermiso = itemView.findViewById(R.id.tvPermiso);
            swPermiso = itemView.findViewById(R.id.swPermiso);
        }
        public void setData(Permiso permiso){
            this.PermisoH = permiso;
            txPermiso.setText(permiso.getDescripcion());
            swPermiso.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            No se subeeeeeeeeeeeeeeee
            Context context = view.getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (swPermiso.isChecked()) {
                    if (ContextCompat.checkSelfPermission(context, PermisoH.getNombre()) == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions(activity, new String[]{PermisoH.getNombre()}, PermisoH.getId());
                    }
                }
            }
        }
    }
}
