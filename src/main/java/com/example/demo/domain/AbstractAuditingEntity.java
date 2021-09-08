package com.example.demo.domain;

import com.example.demo.service.AuditLogHandler;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@MappedSuperclass
@EntityListeners({ AuditingEntityListener.class, AuditLogHandler.class })
public abstract class AbstractAuditingEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_time",  updatable = false)
    @CreatedDate
    private Date createdTime;

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "creator_id", nullable = true, updatable = false)
    @CreatedBy
    private ApplicationUser createdBy;
    public ApplicationUser getCreator() {
        return createdBy;
    }
    public void setCreator(ApplicationUser createdBy) {
        this.createdBy = createdBy;
    }
}
