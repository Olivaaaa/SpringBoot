package com.jpa.demo.model.one2mamy;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_company")
public class company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long comId;

    @Column(nullable = false, length = 32)
    private String comName;

    @OneToMany(mappedBy = "company")
    private List<department> department;
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private long comId;
//
//    @Column(nullable = false, length = 32)
//    private String comName;
//
//    @OneToMany(mappedBy="company")
//    private List<department> department;
}
