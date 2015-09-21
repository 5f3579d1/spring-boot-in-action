package org.example.myproject.domain;

import javax.persistence.Entity;

/**
 * Created by k on 9/16/15.
 */
@Entity
public class Role extends BaseModel {

    private String code;

    private String label;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
