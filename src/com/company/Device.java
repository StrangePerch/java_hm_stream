package com.company;

import com.github.javafaker.Faker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Device {
    public String name;
    public Calendar date;
    public String color;
    public double cost;
    public String type;

    public Device() {
        var faker = new Faker();
        this.name = faker.lorem().word();
        this.date = Calendar.getInstance();
        this.date.setTime(faker.date().past(1000, TimeUnit.DAYS));
        this.color = faker.color().name();
        this.cost = faker.number().randomDouble(2, 100, 1000);
        this.type = faker.lorem().word();
    }
}
