package com.onaar.room_o_grach;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "gry")
public class Gra {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String nazwa;
    public int cena;
    public int minLiczbaOsob;
    public int maxLiczbaOsob;
    public String platforma;
    public int kategoriaWiekowa;
    public String kategoriaNazwa;

    public Gra(String nazwa, int cena, int minLiczbaOsob, int maxLiczbaOsob, String platforma, int kategoriaWiekowa, String kategoriaNazwa) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.minLiczbaOsob = minLiczbaOsob;
        this.maxLiczbaOsob = maxLiczbaOsob;
        this.platforma = platforma;
        this.kategoriaWiekowa = kategoriaWiekowa;
        this.kategoriaNazwa = kategoriaNazwa;
    }

    public Gra() {
    }
}