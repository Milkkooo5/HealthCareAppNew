package com.example.healthcareapp.ui.auth;

import static androidx.navigation.Navigation.findNavController;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthcareapp.R;
import com.example.healthcareapp.databinding.FragmentLoginBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginFragment extends Fragment {

    Button login;
    TextView new_acc;
    FirebaseAuth auth;

    EditText emailEditText, passwordEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        emailEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        login = view.findViewById(R.id.login);
        new_acc=view.findViewById(R.id.register_text);
        auth = FirebaseAuth.getInstance();

        NavController navController = Navigation.findNavController(view);

        login.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if (email.isEmpty() || password.isEmpty() ){
                Toast.makeText(getContext(),"Поля не могут быть пустыми",Toast.LENGTH_SHORT).show();
                return;
            }

            assert getActivity() != null;
            auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(getActivity(), task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Вы успешно авторизованы", Toast.LENGTH_SHORT).show();
                            navController.navigate(R.id.action_login_to_doctors);
                        }
                    });
        });

        new_acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_loginFragment_to_signupFragment);
            }
        });



    }
}

