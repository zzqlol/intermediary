package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Staff {
    private int uid;
    private Integer uname;
    private Integer sex;
    private String telephone;
    private String staffDate;
    private String did;

    @Id
    @Column(name = "uid")
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uname")
    public Integer getUname() {
        return uname;
    }

    public void setUname(Integer uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
    @Column(name = "staff_date")
    public String getStaffDate() {
        return staffDate;
    }

    public void setStaffDate(String staffDate) {
        this.staffDate = staffDate;
    }

    @Basic
    @Column(name = "did")
    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return uid == staff.uid &&
                Objects.equals(uname, staff.uname) &&
                Objects.equals(sex, staff.sex) &&
                Objects.equals(telephone, staff.telephone) &&
                Objects.equals(staffDate, staff.staffDate) &&
                Objects.equals(did, staff.did);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, sex, telephone, staffDate, did);
    }
}
