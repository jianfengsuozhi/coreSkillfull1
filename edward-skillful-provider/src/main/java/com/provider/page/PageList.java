package com.provider.page;


import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * 方便画面分页而是用的包装类。
 * 包含数据和分页使用用到的总记录数，每页记录数等相关信息。
 *
 */
public class PageList<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 数据记录 */
    private List<T> data= Collections.emptyList();

    /** 分页对象 */
    private Page page;

    public List<T> getData() {

        return data;
    }

    public void setData(List<T> data) {

        this.data = data;
    }

    public Page getPage() {

        return page;
    }

    public void setPage(Page page) {

        this.page = page;
    }

}
