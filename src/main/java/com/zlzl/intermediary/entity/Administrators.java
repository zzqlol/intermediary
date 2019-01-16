package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Administrators {
    private int admId;
    private String dmUsername;
    private String admPassword;
    private String admName;

    @Override
    public String toString() {
        return "Administrators{" +
                "admId=" + admId +
                ", dmUsername='" + dmUsername + '\'' +
                ", admPassword='" + admPassword + '\'' +
                ", admName='" + admName + '\'' +
                '}';
    }

    @Id
    @Column(name = "adm_id")
    public int getAdmId() {
        return admId;
    }

    public void setAdmId(int admId) {
        this.admId = admId;
    }

    @Basic
    @Column(name = "dm_username")
    public String getDmUsername() {
        return dmUsername;
    }

    public void setDmUsername(String dmUsername) {
        this.dmUsername = dmUsername;
    }

    @Basic
    @Column(name = "adm_password")
    public String getAdmPassword() {
        return admPassword;
    }

    public void setAdmPassword(String admPassword) {
        this.admPassword = admPassword;
    }

    @Basic
    @Column(name = "adm_name")
    public String getAdmName() {
        return admName;
    }

    public void setAdmName(String admName) {
        this.admName = admName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Administrators that = (Administrators) o;
        return admId == that.admId &&
                Objects.equals(dmUsername, that.dmUsername) &&
                Objects.equals(admPassword, that.admPassword) &&
                Objects.equals(admName, that.admName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(admId, dmUsername, admPassword, admName);
    }
}
