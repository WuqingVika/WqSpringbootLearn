package com.wq.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqingvika on 2018/4/10.
 */
public class Pager<T> implements Serializable {
    private Integer pageSize;//每页显示多少条记录
    private Integer currentPage;//当前页
    private Integer totalRecord;//总共记录条数
    private Integer totalPage;//总共多少页数
    private List<T> dataList;//显示的数据 泛型

    public Pager() {
    }

    public Pager(List<T> sourceList,Integer pageNum, Integer pageSize){
        //pageNum代表前端传来的要求显示哪页的
        if(sourceList==null||sourceList.size() == 0) return;
        //赋值
        //1.总记录条数
        this.totalRecord=sourceList.size();
        //2.当前页
        this.currentPage=pageNum;
        //3.每页显示条数
        this.pageSize=pageSize;
        //4.总共页数
       // this.totalPage=this.totalRecord % this.pageSize==0?this.totalRecord / this.pageSize:this.totalRecord / this.pageSize+1;
       //总页数可以用math.ceil()方法，取大于等于本数的最小整数 如：Math.ceil(25.9); //26
        this.totalPage = (int) Math.ceil(totalRecord / pageSize);
        //5.获取当前第几页
        if(this.totalPage <=pageNum){
            this.currentPage=this.totalPage;
        }else if ( pageNum > 0 && pageNum <this.totalPage) {//正常范围之前
            this.currentPage=pageNum;
        }else {//小于如-1
            this.currentPage=1;
        }
        //5.起始索引
        int fromIndex= (this.currentPage-1)*this.pageSize;
        //6.结束索引
        int toIndex=this.currentPage*this.pageSize>this.totalRecord?
                this.totalRecord:this.currentPage*this.pageSize;//=Long.valueOf()
        this.dataList=sourceList.subList(fromIndex,toIndex);
    }

    public Pager(Integer pageSize, Integer currentPage, Integer totalRecord, Integer totalPage, List<T> dataList) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.dataList = dataList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
