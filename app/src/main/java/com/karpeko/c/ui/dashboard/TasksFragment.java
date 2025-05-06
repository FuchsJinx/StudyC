package com.karpeko.c.ui.dashboard;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.karpeko.c.DatabaseHelper;
import com.karpeko.c.R;

import java.util.ArrayList;
import java.util.List;

public class TasksFragment extends Fragment {

    private RecyclerView tasksRecyclerView;
    private TasksAdapter tasksAdapter;
    private List<Task> taskList = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    private String currentUserEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        databaseHelper = new DatabaseHelper(getContext());
        SharedPreferences prefs = getContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        currentUserEmail = getUserEmail();

//        // Получаем email текущего пользователя (передается из активности)
//        Bundle args = getArguments();
//        if (args != null) {
//            currentUserEmail = args.getString("user_email");
//        }

        databaseHelper = new DatabaseHelper(getActivity());

        tasksRecyclerView = view.findViewById(R.id.tasks_recycler_view);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        tasksAdapter = new TasksAdapter(taskList);
        tasksRecyclerView.setAdapter(tasksAdapter);

        FloatingActionButton fab = view.findViewById(R.id.fab_add_task);
        fab.setOnClickListener(v -> showAddTaskDialog());

        loadTasks();

        return view;
    }

    @SuppressLint("Range")
    private void loadTasks() {
        taskList.clear();
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM tasks WHERE user_email=?",
                new String[]{currentUserEmail});

        if (cursor.moveToFirst()) {
            do {
                Task task = new Task(
                        cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("title")),
                        cursor.getInt(cursor.getColumnIndex("complete")) == 1
                );
                taskList.add(task);
            } while (cursor.moveToNext());
        }
        cursor.close();
        tasksAdapter.notifyDataSetChanged();
    }

    private void showAddTaskDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_task, null);

        final EditText taskInput = dialogView.findViewById(R.id.task_input);

        builder.setView(dialogView)
                .setTitle("Добавить задачу")
                .setPositiveButton("Добавить", (dialog, which) -> {
                    String taskTitle = taskInput.getText().toString().trim();
                    if (!taskTitle.isEmpty()) {
                        addTaskToDatabase(taskTitle);
                    } else {
                        Toast.makeText(getActivity(), "Введите текст задачи", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Отмена", (dialog, which) -> dialog.cancel());

        builder.create().show();
    }

    private void addTaskToDatabase(String title) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("complete", 0);
        values.put("user_email", currentUserEmail);

        long id = db.insert("tasks", null, values);
        if (id != -1) {
            Task newTask = new Task((int) id, title, false);
            taskList.add(newTask);
            tasksAdapter.notifyItemInserted(taskList.size() - 1);
        }
    }

    private void deleteTaskFromDatabase(int taskId) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        db.delete("tasks", "id = ?", new String[]{String.valueOf(taskId)});
    }

    private class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

        private List<Task> tasks;

        public TasksAdapter(List<Task> tasks) {
            this.tasks = tasks;
        }

        @NonNull
        @Override
        public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_task, parent, false);
            return new TaskViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
            Task task = tasks.get(position);
            holder.taskCheckBox.setText(task.getTitle());
            holder.taskCheckBox.setChecked(task.isComplete());

            holder.taskCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (isChecked) {
                    deleteTaskFromDatabase(task.getId());
                    tasks.remove(position);
                    notifyItemRemoved(position);
                    notifyItemRangeChanged(position, tasks.size());
                }
            });
        }

        @Override
        public int getItemCount() {
            return tasks.size();
        }

        class TaskViewHolder extends RecyclerView.ViewHolder {
            CheckBox taskCheckBox;

            public TaskViewHolder(@NonNull View itemView) {
                super(itemView);
                taskCheckBox = itemView.findViewById(R.id.task_checkbox);
            }
        }
    }
    private String getUserEmail() {
        SharedPreferences prefs = requireActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return prefs.getString("email", null); // возвращает email или null, если не найден
    }
}
