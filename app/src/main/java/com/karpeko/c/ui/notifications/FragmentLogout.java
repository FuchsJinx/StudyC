package com.karpeko.c.ui.notifications;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.karpeko.c.DatabaseHelper;
import android.widget.Toast;

import com.karpeko.c.R;
import com.karpeko.c.registration.EditAccountActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FragmentLogout extends Fragment {

    TextView name, group;
    Button logout;
    ImageButton edit;
    private static final int PICK_IMAGE_REQUEST = 1;
    ImageView icon;
    SharedPreferences prefs, sharedPreferences;

    private static final String PREFS_NAME = "ThemePrefs";
    private static final String KEY_THEME = "isDarkTheme";

    @SuppressLint({"MissingInflatedId", "Range"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logout, container, false);

        // Загружаем сохраненную тему перед setContentView
        sharedPreferences = requireActivity().getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean(KEY_THEME, false);

        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            requireActivity().setTheme(R.style.AppTheme_Dark);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            requireActivity().setTheme(R.style.AppTheme_Light);
        }

        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch themeSwitch = view.findViewById(R.id.themeSwitch);
        themeSwitch.setChecked(isDarkTheme);

        themeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Сохраняем выбор темы
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(KEY_THEME, isChecked);
                editor.apply();

                // Применяем тему
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }

                // Пересоздаем активность для применения темы
                requireActivity().recreate();
            }
        });

        name = view.findViewById(R.id.username);
        group = view.findViewById(R.id.group);
        logout = view.findViewById(R.id.logout);
        icon = view.findViewById(R.id.icon);

        icon.setOnClickListener(v -> {
            openImageChooser();
        });

        loadAvatarForUser();

        loadData();

        logout.setOnClickListener(v -> {
            prefs.edit().clear().apply();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, new FragmentLogin());
            ft.commit();
        });

        edit = view.findViewById(R.id.edit);
        edit.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), EditAccountActivity.class);
            startActivity(intent);
        });

        return view;
    }

    private void openImageChooser() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
    private void saveAvatarPathForUser(String path) {
        SharedPreferences prefs = requireActivity().getSharedPreferences("UserAvatars", Context.MODE_PRIVATE);
        String userEmail = getUserEmail();
        if (userEmail == null) return;

        prefs.edit().putString(userEmail + "_avatar_path", path).apply();
    }

    private void loadAvatarForUser() {
        String userEmail = getUserEmail();
        if (userEmail == null) {
            icon.setImageResource(R.drawable.ic_launcher_foreground);
            return;
        }

        SharedPreferences prefs = requireActivity().getSharedPreferences("UserAvatars", Context.MODE_PRIVATE);
        String path = prefs.getString(userEmail + "_avatar_path", null);

        if (path != null) {
            File file = new File(path);
            if (file.exists()) {
                icon.setImageURI(Uri.fromFile(file));
                return;
            } else {
                // Файл не найден, удаляем устаревший путь
                prefs.edit().remove(userEmail + "_avatar_path").apply();
            }
        }
        icon.setImageResource(R.drawable.ic_launcher_foreground);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();

            try {
                String userEmail = getUserEmail();
                if (userEmail != null) {
                    String savedPath = copyImageToInternalStorage(requireContext(), imageUri, userEmail + "_avatar.jpg");
                    icon.setImageURI(Uri.fromFile(new File(savedPath)));
                    saveAvatarPathForUser(savedPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getContext(), "Ошибка при сохранении изображения", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String getUserEmail() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return prefs.getString("email", null); // возвращает email или null, если не найден
    }

    private String copyImageToInternalStorage(Context context, Uri uri, String fileName) throws IOException {
        InputStream inputStream = context.getContentResolver().openInputStream(uri);
        if (inputStream == null) throw new IOException("Невозможно открыть InputStream");

        File file = new File(context.getFilesDir(), fileName);
        OutputStream outputStream = new FileOutputStream(file);

        byte[] buffer = new byte[4096];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }

        outputStream.close();
        inputStream.close();

        return file.getAbsolutePath();
    }

    @SuppressLint("Range")
    private void loadData() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getContext());
        prefs = getContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        String userEmail = getUserEmail();

        Cursor cursor = databaseHelper.getUserByEmail(userEmail);

        if (cursor != null && cursor.moveToFirst()) {
            String username = cursor.getString(cursor.getColumnIndex("USERNAME"));
            String Group = cursor.getString(cursor.getColumnIndex("GROUPS"));

            name.setText(username);
            group.setText(Group);

            cursor.close();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }
}
