package com.api.page;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuyichuan on 7/11/14.
 */
public class PageList<T> implements Serializable {
    
    private final List<T> listData;
    private final PageInfo pageInfo;

    private PageList(List<T> listData, PageInfo pageInfo){
        this.listData = listData!=null?listData:new LinkedList<T>();
        this.pageInfo = pageInfo!=null?pageInfo:new PageInfo();
    }

    public static <T> PageList<T> getPageList(List<T> listData, PageInfo pageInfo){
        return new PageList<T>(listData, pageInfo);
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public List<T> getListData() {
        return listData;
    }
}
