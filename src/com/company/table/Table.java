package com.company.table;

import java.util.List;

public class Table <T> {
    private List<T> arr;
    private List<Column<T>> columns;
    private boolean small = false;

    public Table(List<T> arr, Column<T>[] columns) {
        this.arr = arr;
        this.columns = List.of(columns);
    }

    public void makeSmall(){
        small = true;
    }

    public void setArr(List<T> arr) {
        this.arr = arr;
    }

    public void print() {
        StringBuilder line = new StringBuilder();
        for (Column<T> column : columns) {
            line.append("+").append("-".repeat(column.width + 2));
        }
        line.append("+").append("%n");
        System.out.format(line.toString());

        var leftAlignFormat = new StringBuilder();
        for (Column<T> column : columns) {
            leftAlignFormat.append("| %-").append(column.width).append("s ");
        }
        leftAlignFormat.append("|%n");
        System.out.format(leftAlignFormat.toString(), columns.stream().map(Column::getHeader).toArray());
        System.out.format(line.toString());
        for (T item : arr) {
            System.out.format(leftAlignFormat.toString(), columns.stream().map(column -> column.selector.getValue(item)).toArray());
            if(!small) System.out.format(line.toString());
        }
    }
}
