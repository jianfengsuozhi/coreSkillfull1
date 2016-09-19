package com.api.page;

import java.io.Serializable;

/**
 * Created by yuyichuan on 7/11/14.
 */
public class PageInfo implements Serializable {

    private static final long serialVersionUID = 7835707664364769543L;

    private static final int DEFAULT_PAGE_SIZE= 20;
    private static final int MAX_PAGE_SIZE = 1000;

    private final int pageIndex;
    private final int pageSize;
    private final int totalItems;
    private final int totalPages;
    private final int offSet;

    public PageInfo(){
        this.pageIndex = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
        this.totalItems = 0;
        this.totalPages = 0;
        this.offSet = 0;
    }

    public PageInfo(int totalItems, int pageIndex, int pageSize){
        this.totalItems = totalItems>0 ? totalItems : 0;
        this.pageSize = pageSize > 0 && pageSize <= MAX_PAGE_SIZE ? pageSize:DEFAULT_PAGE_SIZE;
        this.totalPages = this.totalItems % this.pageSize > 0 ? this.totalItems / this.pageSize + 1 : this.totalItems / this.pageSize;

        // 如果pageIndex大于总页数，取最大页
        if (totalPages != 0 && pageIndex > totalPages)
            pageIndex = totalPages;
        this.pageIndex = pageIndex > 0 ? pageIndex : 1;

        this.offSet = (this.pageIndex -1) * pageSize;
    }

    public PageInfo(int pageIndex, int pageSize){
        this.totalItems = 0;
        this.totalPages = 0;
        this.pageSize = pageSize > 0 && pageSize <= MAX_PAGE_SIZE ? pageSize:DEFAULT_PAGE_SIZE;
        this.pageIndex = pageIndex > 0 ? pageIndex : 1;
        this.offSet = (this.pageIndex -1) * pageSize;
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getOffSet() {
        return offSet;
    }

}
