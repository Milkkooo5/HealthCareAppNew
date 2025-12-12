package com.example.healthcareapp.ui.doctors;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.healthcareapp.R;
import com.example.healthcareapp.ViewModels.ProfileViewModel;

public class EditProfileFragment extends Fragment {

    private ImageView strelochka;

    private Button save;
    private ProfileViewModel viewModel;
    private EditText etName, etSurname, etPatronymic, etOms, etBirthDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_edit_profile, container, false);

        strelochka = v.findViewById(R.id.strelochka);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ProfileViewModel.class);

        strelochka = view.findViewById(R.id.strelochka);
        save = view.findViewById(R.id.saveButton);
        etName = view.findViewById(R.id.customEditTextWithMaterial);
        etSurname = view.findViewById(R.id.familia);
        etPatronymic = view.findViewById(R.id.otchestvo);
        etOms = view.findViewById(R.id.oms);
        etBirthDate = view.findViewById(R.id.birth_date);

        if (viewModel.getName() != null) {
            etName.setText(viewModel.getName());
        }
        if (viewModel.getSurname() != null) {
            etSurname.setText(viewModel.getSurname());
        }
        if (viewModel.getPatronymic() != null) {
            etPatronymic.setText(viewModel.getPatronymic());
        }
        if (viewModel.getOmsNumber() != null) {
            etOms.setText(viewModel.getOmsNumber());
        }
        if (viewModel.getBirthDate() != null) {
            etBirthDate.setText(viewModel.getBirthDate());
        }

        NavController navController = Navigation.findNavController(view);

        strelochka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_EditProfileFragment_to_ProfileFragment);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDataToViewModel();
                Toast.makeText(getContext(),"Данные успешно сохранены", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void saveDataToViewModel() {
        viewModel.setName(etName.getText().toString());
        viewModel.setSurname(etSurname.getText().toString());
        viewModel.setPatronymic(etPatronymic.getText().toString());
        viewModel.setOmsNumber(etOms.getText().toString());
        viewModel.setBirthDate(etBirthDate.getText().toString());
    }
}