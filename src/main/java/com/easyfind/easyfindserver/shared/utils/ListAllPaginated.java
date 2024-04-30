package com.easyfind.easyfindserver.shared.utils;

import java.util.ArrayList;

public class ListAllPaginated<T> {
    public ArrayList<T> result;
    public int page;
    public int size;

    public ArrayList<T> getResult() {
        return result;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
