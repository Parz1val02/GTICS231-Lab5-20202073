package com.example.gtics231lab520202073.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class JobHistoryId implements Serializable {
    @Column(name = "job_history_id", nullable = false)
    private Integer jobHistoryId;

    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;

    @Column(name = "start_date", nullable = false)
    private Instant startDate;

}