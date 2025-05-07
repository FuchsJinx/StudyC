package com.karpeko.c.registration;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.karpeko.c.DatabaseHelper;
import com.karpeko.c.R;

public class EditAccountActivity extends AppCompatActivity {

    EditText name, email, group, password;
    Button edit;

    @SuppressLint({"MissingInflatedId", "Range"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account);

        name = findViewById(R.id.enterFIO);
        email = findViewById(R.id.enterEmail);
        group = findViewById(R.id.enterGroup);
        password = findViewById(R.id.enterPassword);
        edit = findViewById(R.id.edit);

        DatabaseHelper databaseHelper = new DatabaseHelper(this);
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String userEmail = prefs.getString("email", null);

        Cursor cursor = databaseHelper.getUserByEmail(userEmail);

        if (cursor != null && cursor.moveToFirst()) {
            String username = cursor.getString(cursor.getColumnIndex("USERNAME"));
            String Email = cursor.getString(cursor.getColumnIndex("EMAIL"));
            String Group = cursor.getString(cursor.getColumnIndex("GROUPS"));
            String Password = cursor.getString(cursor.getColumnIndex("PASSWORD"));

            name.setText(username);
            email.setText(Email);
            group.setText(Group);
            password.setText(Password);

            cursor.close();
        }

        edit.setOnClickListener(v -> {
            String newUsername = name.getText().toString();
            String newEmail = email.getText().toString();
            String newGroup = group.getText().toString();
            String newPassword = password.getText().toString();

            boolean updated = databaseHelper.updateUser(userEmail, newUsername, newEmail, newGroup, newPassword);
            if (updated) {
                Toast.makeText(this, "Данные изменены", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Не удалось обновить", Toast.LENGTH_SHORT).show();
            }
            finish();
        });
    }
}
