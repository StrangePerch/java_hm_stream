package com.company.table;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Projector {
    public String name;
    public Calendar date;
    public double cost;
    public String manufacturer;

    public Projector() {
        var faker = new Faker();
        this.name = faker.lorem().word();
        this.date = Calendar.getInstance();
        this.date.setTime(faker.date().past(100, TimeUnit.DAYS));
        this.cost = faker.number().randomDouble(2, 100, 1000);
        this.manufacturer = faker.company().name();
    }

    public double getCost() {
        return cost;
    }

    public int getYear() {
        return this.date.get(Calendar.YEAR);
    }
}
