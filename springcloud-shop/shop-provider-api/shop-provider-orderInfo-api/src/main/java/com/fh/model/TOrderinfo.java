package com.fh.model;

public class TOrderinfo {
    private Long toiId;

    private Long orderId;

    private Long proId;

    private Long counts;

    public Long getCounts() {
        return counts;
    }

    public void setCounts(Long counts) {
        this.counts = counts;
    }

    public Long getToiId() {
        return toiId;
    }

    public void setToiId(Long toiId) {
        this.toiId = toiId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }
}