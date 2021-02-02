package com.example.countries;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CountryAPI {

    private final String BASE_URL = "https://restcountries.eu/";
    private final String API_KEY = "<api-key>";

    public ArrayList<Country> getCountries() {
        Uri builtUri = Uri.parse(BASE_URL)
                .buildUpon()
                .appendPath("rest")
                .appendPath("v2")
                .appendPath("all")
                .build();
        String url = builtUri.toString();

        return doCall(url);
    }

    private ArrayList<Country> doCall(String url) {
        try {
            String JsonResponse = HttpUtils.get(url);
            return processJson(JsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Country> processJson(String jsonResponse) {
        ArrayList<Country> countries = new ArrayList<>();
        try {
            JSONArray jsonCountries = new JSONArray(jsonResponse);
            for (int i = 0; i < jsonCountries.length(); i++) {
                JSONObject jsonCountry = jsonCountries.getJSONObject(i);

                Country country = new Country();
                country.setName(jsonCountry.getString("name"));
                country.setCapital(jsonCountry.getString("capital"));
                country.setPopulation(jsonCountry.getString("population"));
                country.setNativeName(jsonCountry.getString("nativeName"));
                country.setNumericCode(jsonCountry.getString("numericCode"));

                 try {
                    country.setFlagUrl(jsonCountry.getString("flag"));
                } catch (Exception e) {
                    System.out.println("Null image");
                }

                countries.add(country);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return countries;
    }
}
