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

public class RegistrationActivity extends AppCompatActivity {
    TextView toLogin;
    EditText name, email, group, password, confirmPassword;
    Button registration;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        toLogin = findViewById(R.id.toLogin);

        name = findViewById(R.id.enterFIO);
        email = findViewById(R.id.enterEmail);
        group = findViewById(R.id.enterGroup);
        password = findViewById(R.id.enterPassword);
        confirmPassword = findViewById(R.id.enterConfirmPassword);

        registration = findViewById(R.id.registration);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        toLogin.setOnClickListener(v -> {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        registration.setOnClickListener(v -> {
            String sName = name.getText().toString();
            String sEmail = email.getText().toString();
            String sGroup = group.getText().toString();
            String sPassword = password.getText().toString();
            String sConfirmPassword = confirmPassword.getText().toString();

            if (sName.isEmpty() || sEmail.isEmpty() || sGroup.isEmpty() || sPassword.isEmpty() || sConfirmPassword.isEmpty()) {
                Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            }

            boolean inserted = databaseHelper.insertUser(sName, sEmail, sGroup, sPassword);
            if (inserted) {
                Toast.makeText(this, "Рад знакомству, " + sName, Toast.LENGTH_SHORT).show();

                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                prefs.edit().putBoolean("isLoggedIn", true).putString("username", sEmail).apply();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            else {
                Toast.makeText(this, "Попытка регистрации не удалась. Попробуйте снова", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
