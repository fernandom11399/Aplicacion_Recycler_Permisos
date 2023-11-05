package com.example.aplicacion_recycler_permisos.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
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

    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
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
            swPermiso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (swPermiso.isChecked()) {
                        // El Switch está en la posición OFF
                    } else {
                        // El Switch está en la posición OFF
                    }
                }
            });

        }


    }
}
