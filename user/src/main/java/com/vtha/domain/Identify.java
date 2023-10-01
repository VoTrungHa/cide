package com.vtha.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "identify" )
public class Identify {

    @Id
    @org.hibernate.annotations.GenericGenerator(
            name = "test-native-strategy",
            strategy = "native")
    @GeneratedValue(generator = "test-native-strategy")
    @Column(name = "pk", nullable = false, updatable = false)
    private Long pk;

    @Column(name = "loginName", nullable = false)
    @NotNull
    private String loginName;

    @Column(name = "password")
    @NotNull
    private String password;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role_fk", referencedColumnName = "pk")
    @NotNull
    private UserRole userRole;


    @Column(name = "create_date")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
