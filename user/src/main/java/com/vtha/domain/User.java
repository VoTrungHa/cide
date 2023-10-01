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
@Table(name = "user" )
public class User {
    @Id
    @org.hibernate.annotations.GenericGenerator(
            name = "test-native-strategy",
            strategy = "native")
    @GeneratedValue(generator = "test-native-strategy")
    @Column(name = "pk", nullable = false, updatable = false)
    private Long pk;

    @Column(name = "name", nullable = false)
    @NotNull
    private String userName;

    @Column(name = "phone")
    private String phoneNumber;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "identity_fk", referencedColumnName = "pk")
    @NotNull
    private Identify identify;


    @Column(name = "create_date")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "update_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;
}
