package com.zlzl.intermediary.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_basics", schema = "test", catalog = "")
public class HouseBasics {
    private int hbId;
    private String registerDate;
    private String state;
    private String structure;
    private Integer area;
    private Integer floor;
    private Integer floorHeight;
    private String rid;
    private String vid;
    private String decoration;
    private String purpose;
    private Integer uid;
    private String detailedAdd;

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
    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    @Basic
    @Column(name = "vid")
    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
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
                Objects.equals(detailedAdd, that.detailedAdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hbId, registerDate, state, structure, area, floor, floorHeight, rid, vid, decoration, purpose, uid, detailedAdd);
    }
}
