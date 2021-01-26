package com.example.countries;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String capital;
    private String population;
    private String nativeName;
    private String numericCode;
    private String flagUrl;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCapital() {

        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public void setFlagUrl(String flagUrl) {
        this.flagUrl = flagUrl;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population='" + population + '\'' +
                ", nativeName='" + nativeName + '\'' +
                ", numericCode='" + numericCode + '\'' +
                ", flagUrl='" + flagUrl + '\'' +
                '}';
    }
}
