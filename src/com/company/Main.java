package com.company;

import com.company.table.Column;
import com.company.table.Projector;
import com.company.table.Table;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("""
                #0 exit
                #1 numbers
                #2 products
                #3 devices
                #4 projector
                """);
            var choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    var random = new Random();
                    var arr = random.ints(100, -50, 50).toArray();
                    var positive = Arrays.stream(arr).filter(num -> num >= 0).count();
                    var negative = arr.length - positive;
                    var twoDigits = Arrays.stream(arr).filter(num -> num >= 10 && num <= 99).count();

                    var mirror = Arrays.stream(arr).filter(num -> {
                        var str = String.valueOf(num).toCharArray();
                        for (int i = 0; i < str.length / 2; i++) {
                            if (str[i] != str[str.length - 1 - i]) {
                                return false;
                            }
                        }
                        return true;
                    }).count();

                    System.out.println("array: " + Arrays.toString(arr));
                    System.out.println("positive: " + positive);
                    System.out.println("negative: " + negative);
                    System.out.println("twoDigits: " + twoDigits);
                    System.out.println("mirror: " + mirror);
                    break;
                case "2":
                    var arr2 = new ArrayList<Product>();
                    for (int i = 0; i < 30; i++) {
                        arr2.add(new Product());
                    }
                    System.out.println("array: " + arr2.toString());
                    var lessThanFive = arr2.stream().filter(product -> product.name.length() < 5).toArray();
                    System.out.println("lessThanFive: " + Arrays.toString(lessThanFive));
                    var input = scanner.nextLine();
                    var found = arr2.stream().filter(product -> product.name.contains(input)).count();
                    System.out.println("found: " + found);
                    System.out.println("milk: " + Arrays.toString(
                            arr2.stream().filter(product -> product.category.toLowerCase().contains("milk")).toArray()));
                    break;
                case "3":
                    var arr3 = new ArrayList<Device>();
                    for (int i = 0; i < 30; i++) {
                        arr3.add(new Device());
                    }
                    var columns = new Column[]{
                            new Column<Device>("Name", 15, device -> device.name),
                            new Column<Device>("Color", 10, device -> device.color),
                            new Column<Device>("Type", 15, device -> device.type),
                            new Column<Device>("Cost", 6, device -> String.valueOf(device.cost)),
                            new Column<Device>("Year", 4,
                                    device -> String.valueOf(device.date.get(Calendar.YEAR)))};
                    var table = new Table<Device>(arr3, columns);
                    table.makeSmall();
                    table.print();

                    table.setArr(arr3.stream().filter(device -> device.cost > 800)
                            .collect(Collectors.toList()));
                    table.print();

                    table.setArr(arr3.stream().filter(device -> device.color.equals("green"))
                            .collect(Collectors.toList()));
                    table.print();

                    table.setArr(arr3.stream().filter(device -> device.date.get(Calendar.YEAR) == 2020)
                            .collect(Collectors.toList()));
                    table.print();

                    table.setArr(arr3.stream().filter(device -> Objects.equals(device.type, "et"))
                            .collect(Collectors.toList()));
                    table.print();

                    table.setArr(arr3.stream()
                            .filter(device -> device.date.get(Calendar.YEAR) >= 2019 &&
                                              device.date.get(Calendar.YEAR) <= 2020)
                            .collect(Collectors.toList()));
                    table.print();

                    break;
                case "4":
                    var arr4 = new ArrayList<Projector>();
                    for (int i = 0; i < 30; i++) {
                        arr4.add(new Projector());
                    }
                    var columns2 = new Column[]{
                            new Column<Projector>("Name", 15, projector -> projector.name),
                            new Column<Projector>("Date", 10, projector -> String.valueOf(projector.date.get(Calendar.YEAR))),
                            new Column<Projector>("manufacturer", 35, projector -> projector.manufacturer),
                            new Column<Projector>("Cost", 6, projector -> String.valueOf(projector.cost))};
                    var table2 = new Table<Projector>(arr4, columns2);
                    table2.makeSmall();
                    table2.print();

                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    table2.setArr(arr4.stream()
                            .filter(projector -> projector.date.get(Calendar.YEAR) == year)
                            .collect(Collectors.toList()));
                    table2.print();

                    arr4.sort(Comparator.comparing(Projector::getCost));
                    table2.setArr(arr4);
                    table2.print();

                    arr4.sort(Comparator.comparing(Projector::getCost).reversed());
                    table2.setArr(arr4);
                    table2.print();

                    arr4.sort(Comparator.comparing(Projector::getYear));
                    table2.setArr(arr4);
                    table2.print();

                    arr4.sort(Comparator.comparing(Projector::getYear).reversed());
                    table2.setArr(arr4);
                    table2.print();

                    break;
                default:
                    return;
            }
        }
    }
}
