package com.mm.bbs.vo;
import java.util.ArrayList;
import java.util.List; 
 
public class Pagination<T> {
    private int total;
    private List<T> rows;
    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }
    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    /**
     * @return the list
     */
    public List<T> getRows() {
        return rows;
    }
    /**
     * @param list the list to set
     */
    public void setRows(List<T> list) {
        if(list==null){
            this.rows = new ArrayList<T>();
        }else {
            this.rows = list;          
        }
    }
     
}