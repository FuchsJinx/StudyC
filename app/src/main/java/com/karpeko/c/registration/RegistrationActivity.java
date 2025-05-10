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

public class RegistrationActivity extends AppCompatActivity {
    TextView toLogin, notLogin;
    EditText name, email, group, password, confirmPassword;
    Button registration;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        toLogin = findViewById(R.id.toLogin);
        notLogin = findViewById(R.id.notLogin);

        name = findViewById(R.id.enterFIO);
        email = findViewById(R.id.enterEmail);
        group = findViewById(R.id.enterGroup);
        password = findViewById(R.id.enterPassword);
        confirmPassword = findViewById(R.id.enterConfirmPassword);

        registration = findViewById(R.id.registration);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);

        toLogin.setOnClickListener(v -> {
            SoundClick.soundClick(this);
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        });

        notLogin.setOnClickListener(v -> {
            SoundClick.soundClick(this);
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        registration.setOnClickListener(v -> {
            SoundClick.soundClick(this);
            String sName = name.getText().toString();
            String sEmail = email.getText().toString();
            String sGroup = group.getText().toString();
            String sPassword = password.getText().toString();
            String sConfirmPassword = confirmPassword.getText().toString();

            if (sName.isEmpty() || sEmail.isEmpty() || sGroup.isEmpty() || sPassword.isEmpty() || sConfirmPassword.isEmpty()) {
                Toast.makeText(this, "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!sPassword.equals(sConfirmPassword)) {
                Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean inserted = databaseHelper.insertUser(sName, sEmail, sGroup, sPassword);
            if (inserted) {
                Toast.makeText(this, "Рад знакомству, " + sName, Toast.LENGTH_SHORT).show();

                SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                prefs.edit().putBoolean("isLoggedIn", true).putString("email", sEmail).apply();

                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
            else {
                Toast.makeText(this, "Попытка регистрации не удалась. Попробуйте снова", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
