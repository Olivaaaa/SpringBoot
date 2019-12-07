package com.jpa.demo.model.one2mamy;

import javax.persistence.*;
import java.util.List;

/**
 * 职级表（一个员工可对应着多个职级）
 *
 * @author Administrator
 */
@Entity
@Table(name = "t_position")
public class position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long posId;

    @Column(nullable = false, length = 32)
    private String posName;

    @ManyToMany(cascade=CascadeType.ALL,mappedBy="position")
    private List<employee> employee;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long posId;
//
//    @Column(nullable = false, length = 32)
//    private String posName;
//
//    @ManyToMany(cascade=CascadeType.ALL,mappedBy="position")
//    private List<employee> employee;
}
