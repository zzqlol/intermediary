package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class History {
    private int hisId;
    private Integer hbId;
    private Double price;
    private String nowDate;
    private String customerName;
    private String customerPhone;
    private Integer uid;
    private String leaseDate;

    @Id
    @Column(name = "his_id")
    public int getHisId() {
        return hisId;
    }

    public void setHisId(int hisId) {
        this.hisId = hisId;
    }

    @Basic
    @Column(name = "hb_id")
    public Integer getHbId() {
        return hbId;
    }

    public void setHbId(Integer hbId) {
        this.hbId = hbId;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "now_date")
    public String getNowDate() {
        return nowDate;
    }

    public void setNowDate(String nowDate) {
        this.nowDate = nowDate;
    }

    @Basic
    @Column(name = "customer_name")
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Basic
    @Column(name = "customer_phone")
    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    @Basic
    @Column(name = "uid")
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "lease_date")
    public String getLeaseDate() {
        return leaseDate;
    }

    public void setLeaseDate(String leaseDate) {
        this.leaseDate = leaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return hisId == history.hisId &&
                Objects.equals(hbId, history.hbId) &&
                Objects.equals(price, history.price) &&
                Objects.equals(nowDate, history.nowDate) &&
                Objects.equals(customerName, history.customerName) &&
                Objects.equals(customerPhone, history.customerPhone) &&
                Objects.equals(uid, history.uid) &&
                Objects.equals(leaseDate, history.leaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hisId, hbId, price, nowDate, customerName, customerPhone, uid, leaseDate);
    }
}
