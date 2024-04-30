package com.easyfind.easyfindserver.shared.utils;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public  class Pagination {
    private @NotNull @Min(0) int page;

    private @NotNull @Min(1) @Max(20) int size;

    public int getPage() {
        return page > 0 ? page - 1 : page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
