package com.chinaunicom.management.entity.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @Author: WAI CHAN
 * @Date: 19-8-8 上午10:07
 */
public class PageQueryParam {

    @NotNull(message = "{management.entity.dto.PageQueryParam.currentIndex.notnull}")
    @Min(value = 1, message = "{management.entity.dto.PageQueryParam.currentIndex.min}" )
    private Integer currentIndex;

    @NotNull(message = "{management.entity.dto.PageQueryParam.pageSize.notnull}")
    @Min(value = 0, message = "{management.entity.dto.PageQueryParam.pageSize.min}")
    private Integer pageSize;

    public PageQueryParam() {
    }

    public PageQueryParam(Integer currentIndex, Integer pageSize) {
        this.currentIndex = currentIndex;
        this.pageSize = pageSize;
    }

    public Integer getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex) {
        this.currentIndex = currentIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageQueryParam{" +
                "currentIndex=" + currentIndex +
                ", pageSize=" + pageSize +
                '}';
    }
}
