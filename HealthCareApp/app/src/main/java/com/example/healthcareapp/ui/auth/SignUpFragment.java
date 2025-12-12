package com.example.healthcareapp.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.example.healthcareapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignUpFragment extends Fragment {

    private FirebaseAuth auth;
    private EditText email,password;
    private Button SignInButton;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign, container, false);

        auth = FirebaseAuth.getInstance();
        SignInButton = view.findViewById(R.id.sign);
        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);

        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(
                        requireActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    FirebaseUser user = auth.getCurrentUser();
                                    Log.d("RRR","Sign up success");
                                }else{
                                    Log.d("RRR","Sign up failed");
                                }
                            }
                        }
                );
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_signupFragment_to_loginFragment);

            }
        });

        return view;



    }




}