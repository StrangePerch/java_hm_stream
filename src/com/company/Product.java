package com.company;

import com.github.javafaker.Faker;

import java.util.Random;

public class Product {
    public String name;
    public String category;

    public Product()
    {
        var rand = new Random();
        var faker = new Faker();
        name = faker.lorem().word();
        switch (rand.nextInt(3)){
            case 0: category = "Milk"; break;
            case 1: category = "Chocolate"; break;
            case 2: category = "Coffee"; break;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                "}\n";
    }
}
