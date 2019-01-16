package com.zlzl.intermediary.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_detailed", schema = "test", catalog = "")
public class HouseDetailed {
    private int hbId;
    private Integer rentalPrice;
    private String rentalExplain;
    private Double sellPrice;
    private String sellExplain;
    private String infrastructure;
    private String facilities;
    private String detailed;
    private String owner;
    private String telephone;
    private String mobilePhone;
    private String specificAddress;

    @Id
    @Column(name = "hb_id")
    public int getHbId() {
        return hbId;
    }

    public void setHbId(int hbId) {
        this.hbId = hbId;
    }

    @Basic
    @Column(name = "rental_price")
    public Integer getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(Integer rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Basic
    @Column(name = "rental_explain")
    public String getRentalExplain() {
        return rentalExplain;
    }

    public void setRentalExplain(String rentalExplain) {
        this.rentalExplain = rentalExplain;
    }

    @Basic
    @Column(name = "sell_price")
    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    @Basic
    @Column(name = "sell_explain")
    public String getSellExplain() {
        return sellExplain;
    }

    public void setSellExplain(String sellExplain) {
        this.sellExplain = sellExplain;
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
    @Column(name = "facilities")
    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @Basic
    @Column(name = "detailed")
    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    @Basic
    @Column(name = "owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
    @Column(name = "specific_address")
    public String getSpecificAddress() {
        return specificAddress;
    }

    public void setSpecificAddress(String specificAddress) {
        this.specificAddress = specificAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseDetailed that = (HouseDetailed) o;
        return hbId == that.hbId &&
                Objects.equals(rentalPrice, that.rentalPrice) &&
                Objects.equals(rentalExplain, that.rentalExplain) &&
                Objects.equals(sellPrice, that.sellPrice) &&
                Objects.equals(sellExplain, that.sellExplain) &&
                Objects.equals(infrastructure, that.infrastructure) &&
                Objects.equals(facilities, that.facilities) &&
                Objects.equals(detailed, that.detailed) &&
                Objects.equals(owner, that.owner) &&
                Objects.equals(telephone, that.telephone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(specificAddress, that.specificAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hbId, rentalPrice, rentalExplain, sellPrice, sellExplain, infrastructure, facilities, detailed, owner, telephone, mobilePhone, specificAddress);
    }
}
