package com.api.page;

import java.io.Serializable;

/**
 * 分页对象
 *
 *
 */
public class Page implements Serializable {

    private static final long serialVersionUID = 3251554346859861728L;

    /**
     * 总记录数
     */
    private Integer totalRecords = -1;

    /**
     * 当前页
     */
    private Integer pageIndex;

    /**
     * 每页条数
     */
    private Integer pageSize;

    /**
     * 总页数
     */
    private Integer totalPages;

    /**
     * 分页时起始记录索引(适用于Oracle分页sql）
     */
    private Integer begin = 0;

    private Integer end;

    /**
     * 页码开始
     */
    private Integer lower;

    private Integer higher;

    public Integer getLower() {

        lower = pageIndex - 2;
        if (lower <= 0) {
            lower = 1;
        }
        return lower;
    }

    public void setLower(Integer lower) {

        this.lower = lower;
    }

    public Integer getHigher() {

        higher = lower + 4;
        if (higher >= totalPages) {
            higher = totalPages > lower ? totalPages : lower;
        }
        return higher;
    }

    public void setHigher(Integer higher) {

        this.higher = higher;
    }

    public Integer getEnd() {

        return end;
    }

    public void setEnd(Integer end) {

        this.end = end;
    }

    public Integer getBegin() {

        return begin;
    }

    public void setBegin(Integer begin) {

        this.begin = begin;
    }

    public Integer getTotalPages() {

        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {

        this.totalPages = totalPages;
    }

    public Page() {

    }

    public Page(Integer pageIndex, Integer pageSize) {

        if (null == pageIndex)
            pageIndex = 1;
        if (null == pageSize)
            pageSize = 10;

        setPageSize(pageSize);
        setPageIndex(pageIndex);

        if (this.getPageIndex() < 1) {
            setPageIndex(1);
        }
        if ((getPageIndex() - 1) <= 0) {
            setBegin(0);
        } else {
            setBegin((getPageIndex() - 1) * getPageSize());
        }

        setEnd(getBegin() + getPageSize() - 1);
    }

    public Integer getTotalRecords() {

        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {

        this.totalRecords = totalRecords;
        Integer totalpages = calculateTotalPages(getTotalRecords(), getPageSize());
        setTotalPages(totalpages);
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

    /**
     * 计算总页数
     *
     * @param totalRecords
     *            总记录数
     * @param pageSize
     *            每页记录数
     * @return
     */
    private Integer calculateTotalPages(Integer totalRecords, Integer pageSize) {

        Integer num = totalRecords / pageSize;
        if ((totalRecords % pageSize) > 0) {
            num++;
        }
        return num;
    }

    /**
     * 该页是否有下一页.
     */
    public boolean isHasNextPage() {

        return this.getPageIndex() < this.getTotalPages();
    }

    /**
     * 该页是否有上一页.
     */
    public boolean isHasPreviousPage() {

        return this.getPageIndex() > 1;
    }
}
