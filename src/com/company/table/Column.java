package com.company.table;

public class Column <T> {
    public String header;
    public int width;
    public Selector<T> selector;

    public Column(String header, int width, Selector<T> selector) {
        this.header = header;
        this.width = width;
        this.selector = selector;
    }

    public String getHeader() {
        return header;
    }
}
