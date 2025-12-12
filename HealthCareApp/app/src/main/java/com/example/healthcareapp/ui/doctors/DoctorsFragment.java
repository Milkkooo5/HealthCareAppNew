package com.example.healthcareapp.ui.doctors;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthcareapp.R;
import com.example.healthcareapp.data.adapters.DoctorAdapter;
import com.example.healthcareapp.data.model.Doctor;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentChange;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class DoctorsFragment extends Fragment {
    private DoctorAdapter adapter;
    private FirebaseFirestore db;
    private ArrayList<Doctor> doctors;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_doctors, container, false);
        recyclerView = v.findViewById(R.id.my_recycler_view);
        db = FirebaseFirestore.getInstance();
        doctors = new ArrayList<>();
        adapter = new DoctorAdapter(this.doctors);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        NavController navController = Navigation.findNavController(view);
        if (user == null){
            navController.navigate(R.id.action_doctors_to_loginFragment);
        }
        else{
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(adapter);
            loadDoctors();
        }

    }

    public void loadDoctors(){
        db.collection("doctor")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if (error!=null){
                            Log.e("Firestore error",error.getMessage());
                        }

                        assert value != null;
                        for (DocumentChange dc: value.getDocumentChanges()){
                            if (dc.getType()== DocumentChange.Type.ADDED){
                                doctors.add(dc.getDocument().toObject(Doctor.class));
                            }

                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }




}