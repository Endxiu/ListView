package com.example.to_dolistapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText taskEditText;
    Button addTaskButton;
    ListView tasksListView;

    ArrayList<String> tasksList;
    ArrayAdapter<String> tasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskEditText = findViewById(R.id.taskEditText);
        addTaskButton = findViewById(R.id.addTaskButton);
        tasksListView = findViewById(R.id.tasksListView);

        tasksList = new ArrayList<>();
        tasksAdapter = new ArrayAdapter<>(
                this,
                R.layout.task_item_layout, // Nasz layout dla elementu
                R.id.taskTextView,         // ID TextView w naszym layoucie
                tasksList
        );
        tasksListView.setAdapter(tasksAdapter);

        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTask = taskEditText.getText().toString().trim();
                if (!newTask.isEmpty()) {
                    tasksList.add(newTask);
                    tasksAdapter.notifyDataSetChanged(); // Ważne! Odświeża listę
                    taskEditText.setText(""); // Czyści pole edycji
                } else {
                    Toast.makeText(MainActivity.this, "Wpisz treść zadania!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tasksListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedTask = tasksList.get(position);
                Toast.makeText(MainActivity.this, "Zadanie: " + clickedTask, Toast.LENGTH_SHORT).show();
                // Tutaj można by dodać logikę usuwania lub oznaczania jako wykonane
            }
        });
    }
}