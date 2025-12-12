package com.example.healthcareapp.ui.doctors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.healthcareapp.R;
import com.example.healthcareapp.ViewModels.ProfileViewModel;

public class ProfileFragment extends Fragment {

    private ImageView iconn;

    TextView name,last_name,otchestvo,oms,date;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        iconn = v.findViewById(R.id.icon12);
        name = v.findViewById(R.id.nameValue);
        last_name = v.findViewById(R.id.surnameValue);
        otchestvo = v.findViewById(R.id.middleNameValue);
        oms = v.findViewById(R.id.omsValue);
        date = v.findViewById(R.id.birthDateValue);


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ProfileViewModel viewModel = new ViewModelProvider(requireActivity()).get(ProfileViewModel.class);
        if(viewModel.getName() != null) {
            name.setText(viewModel.getName());
        }

        if(viewModel.getSurname() != null) {
            last_name.setText(viewModel.getSurname());
        }

        if(viewModel.getPatronymic() != null) {
            otchestvo.setText(viewModel.getPatronymic());
        }

        if(viewModel.getOmsNumber() != null) {
            oms.setText(viewModel.getOmsNumber());
        }

        if(viewModel.getBirthDate() != null) {
            date.setText(viewModel.getBirthDate());
        }
        NavHostFragment navHostFragment = (NavHostFragment) getActivity().getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);
        if (navHostFragment != null) {
            NavController navController = navHostFragment.getNavController();

            iconn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (navController != null) {
                        navController.navigate(R.id.action_profilefragment_to_profile_edit_fragment);
                    }

                }
            });
        }

    }
}
