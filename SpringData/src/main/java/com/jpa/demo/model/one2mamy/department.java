package com.jpa.demo.model.one2mamy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_department")
public class department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long depId;

    @Column(nullable = false, length = 32)
    private String depName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "comId")
    private company company;

    @OneToMany(mappedBy = "department")
    private List<employee> employee;
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private long depId;
//
//    @Column(nullable = false, length = 32)
//    private String depName;
//
//    //许多部门对应一个公司
//    @ManyToOne(cascade=CascadeType.ALL)
//    @JoinColumn(name = "comId")
//    private company company;
//
//    //一个部门对应多个员工
//    @OneToMany(mappedBy="department")
//    private List<employee> employee;
}
