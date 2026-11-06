package com.onaar.room_o_grach;

import androidx.room3.Entity;
import androidx.room3.PrimaryKey;

@Entity (tableName = "gry")
public class Gra {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nazwa;
    public int cena;
    public int iluOsobowa;
    public String platforma;
    public int kategoriaWiekowa;
    public String kategoriaNazwa;

    public Gra(String nazwa, int minLiczbaOsob, int maksLiczbaOsob, String platforma, int kategoriaWiekowa, String kategoriaNazwa) {
        this.nazwa = nazwa;
        this.cena = minLiczbaOsob;
        this.iluOsobowa = maksLiczbaOsob;
        this.platforma = platforma;
        this.kategoriaWiekowa = kategoriaWiekowa;
        this.kategoriaNazwa = kategoriaNazwa;
    }
}