package com.onaar.room_o_grach;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    Button buttonDodaj;
    EditText editTextNazwa, editTextCena,  editTextMin, editTextMax, editTextPlatform,   editTextWiek;
    Spinner spinnerKategoria;
    ListView lista;
    List<Gra> listaGier;
    ArrayAdapter<Gra> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GryDataBase gryDataBase = Room.databaseBuilder(
                        getApplicationContext(),GryDataBase.class, "gry")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
        gryDataBase.zwrocGryDao().wstawGreDoBazy(
                new Gra("Piłka vs Piłka", 200, 1,3,  "every", 3, "Rozrywka")
        );
        buttonDodaj = findViewById(R.id.buttonDodaj);
        editTextNazwa = findViewById(R.id.editTextNazwa);
        editTextCena = findViewById(R.id.editTextCena);
        editTextMin = findViewById(R.id.editTextMin);
        editTextMax = findViewById(R.id.editTextMax);
        editTextPlatform = findViewById(R.id.editTextPlatform);
        editTextWiek = findViewById(R.id.editTextWiek);
        spinnerKategoria = findViewById(R.id.spinnerKategoria);
        buttonDodaj.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Gra gra = new Gra(
                                editTextNazwa.getText().toString(),
                                Integer.parseInt(editTextCena.getText().toString()),
                                Integer.parseInt(editTextMin.getText().toString()),
                                Integer.parseInt(editTextMax.getText().toString()),
                                editTextPlatform.getText().toString(),
                                Integer.parseInt(editTextWiek.getText().toString()),
                                spinnerKategoria.getSelectedItem().toString()

                        );
                        gryDataBase.zwrocGryDao().wstawGryDoBazy(gra);

                    }
                }
        );
        lista = findViewById(R.id.lista);
        listaGier = gryDataBase.zwrocGryDao().zwrocWszystkieGry();
        adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                listaGier
        );
        lista.setAdapter(adapter);
    }
}