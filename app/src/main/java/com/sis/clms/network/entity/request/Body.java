package com.sis.clms.network.entity.request;

import com.sis.clms.entity.Bean;

/**
 * Created by DELL on 2017/6/5.
 */

public class Body implements Bean {
    private int pageNo;//加载页数
    private int pageSize;//加载数据条数

    public Body(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
