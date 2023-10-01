package com.vtha.domain;

import com.vtha.enums.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "user_role" )
public class UserRole {
    @Id
    @org.hibernate.annotations.GenericGenerator(
            name = "test-native-strategy",
            strategy = "native")
    @GeneratedValue(generator = "test-native-strategy")
    @Column(name = "pk", nullable = false, updatable = false)
    private Long pk;

    @Column(name = "label", length = 50, unique = true)
    @NotNull
    private String label;

    @Column(name = "role", length = 50, unique = true)
    @NotNull
    @Enumerated
    private UserRoleEnum role;
}
