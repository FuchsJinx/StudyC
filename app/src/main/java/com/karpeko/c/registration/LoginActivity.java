package com.karpeko.c.registration;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.karpeko.c.DatabaseHelper;
import com.karpeko.c.MainActivity;
import com.karpeko.c.R;
import com.karpeko.c.notification.SoundClick;

public class LoginActivity extends AppCompatActivity {

    TextView toRegistration, notLogin;
    EditText email, password;
    Button login;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        notLogin = findViewById(R.id.notLogin);
        toRegistration = findViewById(R.id.toRegistration);
        email = findViewById(R.id.enterEmail);
        password = findViewById(R.id.enterPassword);
        login = findViewById(R.id.login);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        toRegistration.setOnClickListener(v -> {
            SoundClick.soundClick(this);
            startActivity(new Intent(this, RegistrationActivity.class));
            finish();
        });

        notLogin.setOnClickListener(v -> {
            SoundClick.soundClick(this);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        login.setOnClickListener(v -> {
            SoundClick.soundClick(this);
            String sEmail = email.getText().toString();
            String sPassword = password.getText().toString();

            if (sEmail.isEmpty() || sPassword.isEmpty()) {
                Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
                return;
            }

            if (databaseHelper.checkUser(sEmail, sPassword)) {
                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                prefs.edit().putBoolean("isLoggedIn", true).putString("email", sEmail).apply();

                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            else {
                Toast.makeText(this, "Войти не получилось. Попробуйте зарегистрироваться", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
