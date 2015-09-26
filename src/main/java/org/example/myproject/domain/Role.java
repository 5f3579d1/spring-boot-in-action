package org.example.myproject.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by k on 9/16/15.
 */
@Entity
@Table(name = "whw_role")
public class Role extends TransactionalEntity {

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
