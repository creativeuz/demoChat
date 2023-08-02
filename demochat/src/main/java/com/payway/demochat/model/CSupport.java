package com.payway.demochat.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CSupport {

    @Id
    private Long csId;
    private String csName;

    public Long getCsId() {
        return csId;
    }

    public void setCsId(Long csId) {
        this.csId = csId;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }
}
