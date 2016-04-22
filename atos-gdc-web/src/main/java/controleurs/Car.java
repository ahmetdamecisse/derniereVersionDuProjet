/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleurs;
/**
 *
 * @author a618081
 */
public class Car {
    private String model;
    private int year;
    private String manufacturer;
    private String color;
    private String specialite;

    public Car(String model, int year, String manufacturer, String color, String specialite) {
        this.model = model;
        this.year = year;
        this.manufacturer = manufacturer;
        this.color = color;
        this.specialite = specialite;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public String getSpecialite() {
        return specialite;
    }
    

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
    
    
}

