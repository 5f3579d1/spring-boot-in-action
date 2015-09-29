package org.example.myproject.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.myproject.util.RequestContext;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * The parent class for all transactional persistent entities.
 *
 * @author Matt Warman
 */
@MappedSuperclass
public class TransactionalEntity implements Serializable {

    @Id
    @GeneratedValue
    protected Long id;

    /**
     * A secondary unique identifier which may be used as a reference to this
     * entity by external systems.
     */
    @JsonIgnore
    @NotNull
    private String referenceId = UUID.randomUUID().toString();

    /**
     * The entity instance version used for optimistic locking.
     */
    @Version
    private Integer version;

    /**
     * A reference to the entity or process which created this entity instance.
     */
    @NotNull
    private String createdBy;

    /**
     * The timestamp when this entity instance was created.
     */
    @NotNull
    private Date createdAt;

    /**
     * A reference to the entity or process which most recently updated this
     * entity instance.
     */
    private String updatedBy;

    /**
     * The timestamp when this entity instance was most recently updated.
     */
    private Date updatedAt;

    @PrePersist
    public void beforePersist() {
        setCreatedBy(RequestContext.getUsername());
        setCreatedAt(new Date());
    }

    @PreUpdate
    public void beforeUpdate() {
        setUpdatedBy(RequestContext.getUsername());
        setUpdatedAt(new Date());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
