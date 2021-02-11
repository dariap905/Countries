package com.example.countries.ui.tools;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CountryDAO {
    @Query("select * from country")
    LiveData<List<Country>> getCountries();

    @Insert
    void addCountry(Country country);

    @Insert
    void addCountries(List<Country> countries);

    @Delete
    void deleteCountry(Country country);

    @Query("DELETE FROM country")
    void deleteCountries();
}