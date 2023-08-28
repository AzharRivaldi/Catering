package com.azhar.catering.register;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.azhar.catering.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    TextInputEditText inputEmail, inputUser, inputPassword;
    MaterialButton btnRegister;
    String strEmail, strUser, strPassword;
    RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setInitLayout();
        setInputData();
    }

    private void setInitLayout() {
        inputEmail = findViewById(R.id.inputEmail);
        inputUser = findViewById(R.id.inputUser);
        inputPassword = findViewById(R.id.inputPassword);
        btnRegister = findViewById(R.id.btnRegister);

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
    }

    private void setInputData() {
        btnRegister.setOnClickListener(v -> {
            strEmail = inputEmail.getText().toString();
            strUser = inputUser.getText().toString();
            strPassword = inputPassword.getText().toString();

            if (strEmail.isEmpty() || strUser.isEmpty() || strPassword.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Ups, Form harus diisi semua!",
                        Toast.LENGTH_SHORT).show();
            } else {
                registerViewModel.addDataRegister(strEmail, strUser, strPassword);
                Toast.makeText(RegisterActivity.this, "Berhasil Register! Silahkan Login.",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}