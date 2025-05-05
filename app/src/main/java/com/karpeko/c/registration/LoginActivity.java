package com.karpeko.c.registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.karpeko.c.DatabaseHelper;
import com.karpeko.c.MainActivity;
import com.karpeko.c.R;

public class LoginActivity extends AppCompatActivity {

    TextView toRegistration;
    EditText email, password;
    Button login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        toRegistration = findViewById(R.id.toRegistration);

        email = findViewById(R.id.enterEmail);
        password = findViewById(R.id.enterPassword);

        login = findViewById(R.id.login);

        toRegistration.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegistrationActivity.class);
            startActivity(intent);
        });

        login.setOnClickListener(v -> {
            String sEmail = email.getText().toString();
            String sPassword = password.getText().toString();

            if (sEmail.isEmpty() || sPassword.isEmpty()) {
                Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT);
                return;
            }

            if (databaseHelper.checkUser(sEmail, sPassword)) {
                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                prefs.edit().putBoolean("isLoggedIn", true).putString("username", sEmail).apply();

                //для выхода из аккаунта: logoutButton.setOnClickListener(v -> {
                //    SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                //    prefs.edit().clear().apply();
                //    startActivity(new Intent(this, LoginActivity.class));
                //    finish();
                //});

                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            else {
                Toast.makeText(this, "Войти не получилось. Попробуйте зарегистрироваться", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
