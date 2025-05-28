package com.example.listviewapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity; // lub android.app.Activity dla starszych projektów

import java.util.ArrayList;
import java.util.Arrays; // Potrzebne, jeśli inicjujemy ArrayList z tablicy

public class MainActivity extends AppCompatActivity {

    // Deklaracja zmiennych dla ListView i danych
    ListView mySimpleListView;
    ArrayList<String> planetsList; // Nasze źródło danych

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ładujemy layout z ListView

        // Łączymy zmienną z elementem ListView z XML
        mySimpleListView = findViewById(R.id.mySimpleListView);

        // Tworzymy i wypełniamy nasze źródło danych
        planetsList = new ArrayList<>();
        planetsList.add("Merkury");
        planetsList.add("Wenus");
        planetsList.add("Ziemia");
        planetsList.add("Mars");
        planetsList.add("Jowisz");
        planetsList.add("Saturn");
        planetsList.add("Uran");
        planetsList.add("Neptun");

        // Alternatywny sposób inicjalizacji ArrayList z tablicy:
        // String[] planetsArray = {"Merkury", "Wenus", "Ziemia", "Mars", "Jowisz", "Saturn", "Uran", "Neptun"};
        // planetsList = new ArrayList<>(Arrays.asList(planetsArray));

//        ArrayAdapter<String> planetAdapter = new ArrayAdapter<>(
//                this,                                  // Kontekst (bieżąca aktywność)
//                android.R.layout.simple_list_item_1,   // Wbudowany layout dla pojedynczego elementu (TextView)
//                planetsList                            // Nasze dane
//        );

        ArrayAdapter<String> planetAdapter = new ArrayAdapter<>(
                this,                           // Kontekst
                R.layout.my_list_item_layout,   // Nasz własny layout dla elementu
                R.id.customTextView,            // ID TextView wewnątrz naszego layoutu, gdzie ma być wstawiony tekst
                planetsList                     // Nasze dane
        );

        // Ustawiamy adapter dla naszego ListView
        mySimpleListView.setAdapter(planetAdapter);

        mySimpleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Metoda wywoływana po kliknięciu na element listy

                // parent: Referencja do adaptera, który dostarczył widok (tutaj planetAdapter)
                // view: Widok klikniętego elementu (tutaj TextView z simple_list_item_1)
                // position: Pozycja klikniętego elementu w liście (indeks od 0)
                // id: Identyfikator wiersza (dla ArrayAdapter często jest taki sam jak position)

                // Pobieramy kliknięty element z naszej listy danych
                String clickedPlanet = planetsList.get(position);
                // Alternatywnie: String clickedPlanet = (String) parent.getItemAtPosition(position);

                // Wyświetlamy Toast z nazwą klikniętej planety
                Toast.makeText(MainActivity.this, "Kliknięto: " + clickedPlanet, Toast.LENGTH_SHORT).show();

                // Tutaj mogłaby być logika otwierania nowego ekranu, wyświetlania szczegółów itp.
            }
        });
    }
}