package com.api.page;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuyichuan on 7/11/14.
 */
public class PageList<T> implements Serializable {
    
    private final List<T> listData;
    private final Page page;

    private PageList(List<T> listData, Page page){
        this.listData = listData!=null?listData:new LinkedList<T>();
        this.page = page!=null?page:new Page();
    }

    public static <T> PageList<T> getPageList(List<T> listData, Page page){
        return new PageList<T>(listData, page);
    }

    public Page getPage() {
        return page;
    }

    public List<T> getListData() {
        return listData;
    }
}
