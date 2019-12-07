package com.jpa.demo.model.one2mamy;

import javax.persistence.*;

@Entity
@Table(name = "t_detailInfo")
public class detailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long detId;

    @Column(nullable = false, length = 32)
    private String detName;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "empId")
    private employee employee;

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private long detId;
//
//    @Column(nullable = false, length = 32)
//    private String detName;
//
//    @OneToOne(cascade = CascadeType.ALL, optional = false)
//    @JoinColumn(name = "empId")
//    private employee employee;
}
