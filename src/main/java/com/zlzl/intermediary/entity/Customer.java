package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Customer {
    private int cid;
    private String cname;
    private String cusState;
    private String mobilePhone;
    private Integer uid;
    private String inputDate;
    private String purpose;
    private Integer rid;
    private String decoration;
    private String structure;
    private Integer area;
    private String facilities;
    private String infrastructure;
    private String seekPrice;
    private String seekExplain;
    private String buyPrice;
    private String buyExplain;

    @Id
    @Column(name = "cid")
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "cus_state")
    public String getCusState() {
        return cusState;
    }

    public void setCusState(String cusState) {
        this.cusState = cusState;
    }

    @Basic
    @Column(name = "mobile_phone")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
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
    @Column(name = "input_date")
    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    @Basic
    @Column(name = "purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Basic
    @Column(name = "rid")
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "decoration")
    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    @Basic
    @Column(name = "structure")
    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Basic
    @Column(name = "area")
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Basic
    @Column(name = "facilities")
    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @Basic
    @Column(name = "infrastructure")
    public String getInfrastructure() {
        return infrastructure;
    }

    public void setInfrastructure(String infrastructure) {
        this.infrastructure = infrastructure;
    }

    @Basic
    @Column(name = "seek_price")
    public String getSeekPrice() {
        return seekPrice;
    }

    public void setSeekPrice(String seekPrice) {
        this.seekPrice = seekPrice;
    }

    @Basic
    @Column(name = "seek_explain")
    public String getSeekExplain() {
        return seekExplain;
    }

    public void setSeekExplain(String seekExplain) {
        this.seekExplain = seekExplain;
    }

    @Basic
    @Column(name = "buy_price")
    public String getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(String buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Basic
    @Column(name = "buy_explain")
    public String getBuyExplain() {
        return buyExplain;
    }

    public void setBuyExplain(String buyExplain) {
        this.buyExplain = buyExplain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return cid == customer.cid &&
                Objects.equals(cname, customer.cname) &&
                Objects.equals(cusState, customer.cusState) &&
                Objects.equals(mobilePhone, customer.mobilePhone) &&
                Objects.equals(uid, customer.uid) &&
                Objects.equals(inputDate, customer.inputDate) &&
                Objects.equals(purpose, customer.purpose) &&
                Objects.equals(rid, customer.rid) &&
                Objects.equals(decoration, customer.decoration) &&
                Objects.equals(structure, customer.structure) &&
                Objects.equals(area, customer.area) &&
                Objects.equals(facilities, customer.facilities) &&
                Objects.equals(infrastructure, customer.infrastructure) &&
                Objects.equals(seekPrice, customer.seekPrice) &&
                Objects.equals(seekExplain, customer.seekExplain) &&
                Objects.equals(buyPrice, customer.buyPrice) &&
                Objects.equals(buyExplain, customer.buyExplain);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname, cusState, mobilePhone, uid, inputDate, purpose, rid, decoration, structure, area, facilities, infrastructure, seekPrice, seekExplain, buyPrice, buyExplain);
    }
}
