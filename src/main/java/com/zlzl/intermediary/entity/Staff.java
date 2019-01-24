package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Staff {
    private int uid;
    private String uname;
    private String sex;
    private String telephone;
    private String staffDate;
    private int did;

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
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Basic
    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
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
