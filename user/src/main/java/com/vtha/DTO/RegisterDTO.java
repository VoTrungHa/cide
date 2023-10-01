package com.vtha.DTO;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    private String loginName;
    private String password;
    private String name;
    private String phoneNumber;
}
