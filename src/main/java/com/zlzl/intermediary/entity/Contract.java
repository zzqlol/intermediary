package com.zlzl.intermediary.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contract {
    private int hisId;
    private String inputDate;
    private String contractFile;

    @Id
    @Column(name = "his_id")
    public int getHisId() {
        return hisId;
    }

    public void setHisId(int hisId) {
        this.hisId = hisId;
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
    @Column(name = "contract_file")
    public String getContractFile() {
        return contractFile;
    }

    public void setContractFile(String contractFile) {
        this.contractFile = contractFile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return hisId == contract.hisId &&
                Objects.equals(inputDate, contract.inputDate) &&
                Objects.equals(contractFile, contract.contractFile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hisId, inputDate, contractFile);
    }
}
