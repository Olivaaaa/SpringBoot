package com.jpa.demo.model.one2one;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 905654767215634L;

    public User(String userName) {
        super();
        this.userName = userName;
    }

    /**
     * @Id:指定表的主键
     * @GeneratedValue:定义了标识字段生成方式
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "USER_NAME", length = 100)
    private String userName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn
    private Address address;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
