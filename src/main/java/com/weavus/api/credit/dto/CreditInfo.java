package com.weavus.api.credit.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity
@Getter
@Setter
//@Table(name = "creditinfo")
public class CreditInfo {
    @Id
    @Column(length = 19)
    private String creditNo;

    @Column(length = 100)
    private String name;

    @Column(length = 20)
    private long gendoGaku;

    @Column(length = 20)
    private long siyoGaku;
}
