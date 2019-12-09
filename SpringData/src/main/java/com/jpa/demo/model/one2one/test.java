package com.jpa.demo.model.one2one;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_test")
public class test implements Serializable {
    private static final long serialVersionUID = 5260045025079981216L;

    @Id
    private long teid;

    @Id
    private long stid;
}
