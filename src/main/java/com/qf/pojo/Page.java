package com.qf.pojo;

import java.util.List;

public class Page<T>{
    private Integer currentPage;//当前页码
    private Integer pageSize;//每页的数量
    private Integer totalCounts;//内容总条数
    private Integer totalPages;//内容总页数
    private Integer startRows;//开始的条目
    private List<T> list;


    public Page() {
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Page(Integer currentPage) {
       this(currentPage,9);

    }

    public Page(Integer currentPage, Integer pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.setStartRows((currentPage-1)*pageSize);
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(Integer totalCounts) {
        this.totalCounts = totalCounts;
        this.setTotalPages(totalCounts%pageSize==0 ? totalCounts/pageSize : (totalCounts/pageSize)+1);
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;

    }

    public Integer getStartRows() {
        return startRows;
    }

    public void setStartRows(Integer startROws) {
        this.startRows = startROws;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCounts=" + totalCounts +
                ", totalPages=" + totalPages +
                ", startRows=" + startRows +
                ", list=" + list +
                '}';
    }
}
