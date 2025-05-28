package com.example.simplecookbook;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView myCookbookListView;
    ArrayList<String> mealList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ładujemy layout z ListView

        myCookbookListView = findViewById(R.id.myCookbookListView);

        mealList = new ArrayList<>();
        mealList.add("\uD83C\uDF72Rosół\uD83C\uDF72");
        mealList.add("\uD83C\uDF5DSpaghetti Bolognese\uD83C\uDF5D");
        mealList.add("\uD83E\uDD5FPierogi Ruskie\uD83E\uDD5F");
        mealList.add("\uD83E\uDD57Sałatka Grecka\uD83E\uDD57");
        mealList.add("\uD83E\uDD67Szarlotka\uD83E\uDD67");

        ArrayAdapter<String> planetAdapter = new ArrayAdapter<>(
                this,                           // Kontekst
                R.layout.task_item_layout,   // Nasz własny layout dla elementu
                R.id.customTextView,            // ID TextView wewnątrz naszego layoutu, gdzie ma być wstawiony tekst
                mealList                     // Nasze dane
        );

        myCookbookListView.setAdapter(planetAdapter);

        myCookbookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String clickedMeal = mealList.get(position);

                Toast.makeText(MainActivity.this, "Wybrano: " + clickedMeal + ". Idealny wybór!", Toast.LENGTH_SHORT).show();
            }
        });
    }


}