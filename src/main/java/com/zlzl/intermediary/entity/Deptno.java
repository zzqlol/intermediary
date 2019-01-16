package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Deptno {
    private int did;
    private String dname;

    @Id
    @Column(name = "did")
    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    @Basic
    @Column(name = "dname")
    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deptno deptno = (Deptno) o;
        return did == deptno.did &&
                Objects.equals(dname, deptno.dname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(did, dname);
    }
}
