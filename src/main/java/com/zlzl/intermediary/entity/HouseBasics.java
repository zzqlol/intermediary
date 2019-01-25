package com.zlzl.intermediary.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_basics", schema = "test")
public class HouseBasics {
    private int hbId;
    private String registerDate;
    private String state;
    private String structure;
    private Integer area;
    private Integer floor;
    private Integer floorHeight;
    private int rid;
    private int vid;
    private String decoration;
    private String purpose;
    private Integer uid;
    private String detailedAdd;
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

    @Override
    public String toString() {
        return "HouseBasics{" +
                "hbId=" + hbId +
                ", registerDate='" + registerDate + '\'' +
                ", state='" + state + '\'' +
                ", structure='" + structure + '\'' +
                ", area=" + area +
                ", floor=" + floor +
                ", floorHeight=" + floorHeight +
                ", rid='" + rid + '\'' +
                ", vid='" + vid + '\'' +
                ", decoration='" + decoration + '\'' +
                ", purpose='" + purpose + '\'' +
                ", uid=" + uid +
                ", detailedAdd='" + detailedAdd + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", rentalExplain='" + rentalExplain + '\'' +
                ", sellPrice=" + sellPrice +
                ", sellExplain='" + sellExplain + '\'' +
                ", infrastructure='" + infrastructure + '\'' +
                ", facilities='" + facilities + '\'' +
                ", detailed='" + detailed + '\'' +
                ", owner='" + owner + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", specificAddress='" + specificAddress + '\'' +
                '}';
    }

    @Id
    @Column(name = "hb_id")
    public int getHbId() {
        return hbId;
    }

    public void setHbId(int hbId) {
        this.hbId = hbId;
    }

    @Basic
    @Column(name = "register_date")
    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    @Column(name = "floor")
    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Basic
    @Column(name = "floor_height")
    public Integer getFloorHeight() {
        return floorHeight;
    }

    public void setFloorHeight(Integer floorHeight) {
        this.floorHeight = floorHeight;
    }

    @Basic
    @Column(name = "rid")
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "vid")
    public int getVid() {
        return vid;
    }

    public void setVid(int vid) {
        this.vid = vid;
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
    @Column(name = "purpose")
    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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
    @Column(name = "detailed_add")
    public String getDetailedAdd() {
        return detailedAdd;
    }

    public void setDetailedAdd(String detailedAdd) {
        this.detailedAdd = detailedAdd;
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
        HouseBasics that = (HouseBasics) o;
        return hbId == that.hbId &&
                Objects.equals(registerDate, that.registerDate) &&
                Objects.equals(state, that.state) &&
                Objects.equals(structure, that.structure) &&
                Objects.equals(area, that.area) &&
                Objects.equals(floor, that.floor) &&
                Objects.equals(floorHeight, that.floorHeight) &&
                Objects.equals(rid, that.rid) &&
                Objects.equals(vid, that.vid) &&
                Objects.equals(decoration, that.decoration) &&
                Objects.equals(purpose, that.purpose) &&
                Objects.equals(uid, that.uid) &&
                Objects.equals(detailedAdd, that.detailedAdd) &&
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
        return Objects.hash(hbId, registerDate, state, structure, area, floor, floorHeight, rid, vid, decoration, purpose, uid, detailedAdd, rentalPrice, rentalExplain, sellPrice, sellExplain, infrastructure, facilities, detailed, owner, telephone, mobilePhone, specificAddress);
    }

    @Override
    public String toString() {
        return "HouseBasics{" +
                "hbId=" + hbId +
                ", registerDate='" + registerDate + '\'' +
                ", state='" + state + '\'' +
                ", structure='" + structure + '\'' +
                ", area=" + area +
                ", floor=" + floor +
                ", floorHeight=" + floorHeight +
                ", rid='" + rid + '\'' +
                ", vid='" + vid + '\'' +
                ", decoration='" + decoration + '\'' +
                ", purpose='" + purpose + '\'' +
                ", uid=" + uid +
                ", detailedAdd='" + detailedAdd + '\'' +
                ", rentalPrice=" + rentalPrice +
                ", rentalExplain='" + rentalExplain + '\'' +
                ", sellPrice=" + sellPrice +
                ", sellExplain='" + sellExplain + '\'' +
                ", infrastructure='" + infrastructure + '\'' +
                ", facilities='" + facilities + '\'' +
                ", detailed='" + detailed + '\'' +
                ", owner='" + owner + '\'' +
                ", telephone='" + telephone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", specificAddress='" + specificAddress + '\'' +
                '}';
    }
}
