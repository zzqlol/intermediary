package com.zlzl.intermediary.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house_photo", schema = "test", catalog = "")
public class HousePhoto {
    private int hpId;
    private Integer hbId;
    private String photoAdd;

    @Id
    @Column(name = "hp_id")
    public int getHpId() {
        return hpId;
    }

    public void setHpId(int hpId) {
        this.hpId = hpId;
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
    @Column(name = "photo_add")
    public String getPhotoAdd() {
        return photoAdd;
    }

    public void setPhotoAdd(String photoAdd) {
        this.photoAdd = photoAdd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HousePhoto that = (HousePhoto) o;
        return hpId == that.hpId &&
                Objects.equals(hbId, that.hbId) &&
                Objects.equals(photoAdd, that.photoAdd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hpId, hbId, photoAdd);
    }
}
