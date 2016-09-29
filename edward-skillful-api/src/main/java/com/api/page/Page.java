package com.api.page;

import java.io.Serializable;

/**
 * Created by weideliang on 2016/9/24.
 */
public class Page implements Serializable{
    public static final Integer DefaultPageIndex = 1;
    public static final Integer DefaultPageSize = 2;

    //当前页 和 一页记录数
    private Integer pageIndex;
    private Integer pageSize;

    //数据库分页查询时开始()
    private Integer begin;

    //总记录数和总页数
    private Integer totalRecords;
    private Integer totalPages;

    //页面页码的开始页和结束页 页面调用
    private Integer pageLow;
    private Integer pageHigh;

    public Page() {
        this.pageIndex = DefaultPageIndex;
        this.pageSize = DefaultPageSize;
    }

    public Page(Integer pageIndex, Integer pageSize) {
        //设置当前页和一页记录数
        this.SetPageIndexAndPageSize(pageIndex,pageSize);
        //数据库开始页 从0开始
        this.begin = (this.getPageIndex() - 1) * this.getPageSize();
    }

    private void SetPageIndexAndPageSize(Integer pageIndex, Integer pageSize) {
        //pageIndex
        if(null == pageIndex || null != pageIndex && pageIndex < 1){
            this.pageIndex = 1;
        }else {
            this.pageIndex = pageIndex;
        }
        //pageSize
        this.pageSize = (null == pageSize ? DefaultPageSize : pageSize);
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
        //计算总页数
        this.totalPages = (int)Math.ceil(totalRecords/(this.pageSize * 1.0));
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getPageLow() {
        this.pageLow = this.pageIndex - 2;
        if(this.pageLow < 1){
            this.pageLow = 1;
        }
        return pageLow;
    }

    public void setPageLow(Integer pageLow) {
        this.pageLow = pageLow;
    }

    public Integer getPageHigh() {
        this.pageHigh = this.pageLow + 4;
        if(this.pageHigh > this.totalPages){
            this.pageHigh = this.totalPages;
        }
        return pageHigh;
    }

    public void setPageHigh(Integer pageHigh) {
        this.pageHigh = pageHigh;
    }

    //是否有上一页和是否有下一页 页面调用
    public Boolean getHasPrePage(){
        return this.pageIndex > 1;
    }

    public Boolean getHasNexPage(){
        return this.pageIndex < this.totalPages;
    }


}
