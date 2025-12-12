package com.example.healthcareapp.data.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcareapp.R;
import com.example.healthcareapp.data.model.Doctor;
import com.example.healthcareapp.databinding.ItemDoctorBinding;

import java.util.ArrayList;
import java.util.List;

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.DoctorViewHolder> {

    ArrayList<Doctor> doctors;

    public DoctorAdapter ( ArrayList<Doctor> doctors){
        this.doctors = doctors;
    }


    @NonNull
    @Override
    public DoctorAdapter.DoctorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_doctor,parent,false);

        return new DoctorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.DoctorViewHolder holder, int position) {
        Doctor doctor = doctors.get(position);

        holder.DoctorName.setText(doctor.getName());
        holder.DoctorSpecialty.setText(doctor.getSpecialty());
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    public static class DoctorViewHolder extends RecyclerView.ViewHolder{
        TextView DoctorName, DoctorSpecialty;


        public DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            DoctorName = itemView.findViewById(R.id.doctor_name);
            DoctorSpecialty = itemView.findViewById(R.id.doctor_specialty);

        }
    }
}