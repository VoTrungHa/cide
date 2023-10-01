package com.vtha.Controller;

import com.vtha.DTO.RegisterDTO;
import com.vtha.domain.User;
import com.vtha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Object> RetrieveUserDetail() {
        return ResponseEntity.ok().body(userService.getListUser());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createNewUser(@RequestBody RegisterDTO dto) throws Exception {
        User user = userService.createNewUser(dto);
        return ResponseEntity.ok().body(user);
    }

}
