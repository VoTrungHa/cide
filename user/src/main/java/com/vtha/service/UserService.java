package com.vtha.service;

import com.vtha.DTO.RegisterDTO;
import com.vtha.Exception.UserException;
import com.vtha.domain.Identify;
import com.vtha.domain.User;
import com.vtha.enums.UserRoleEnum;
import com.vtha.infrastruture.IdentityDao;
import com.vtha.infrastruture.UserDao;
import com.vtha.infrastruture.UserRoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Autowired
    private IdentityDao identityDao;

    @Transactional
    public User createNewUser(RegisterDTO dto) throws Exception {
        if(identityDao.findByLoginName(dto.getLoginName()) != null) {
            throw new UserException(UserException.ErrorCode.USER_EXISTING, "Account already existing");
        }
        try {
            Identify identify  = new Identify();
            identify.setLoginName(dto.getLoginName());
            identify.setPassword(dto.getPassword());
            identify.setCreateDate(new Date());
            identify.setUserRole(userRoleDao.findByRole(UserRoleEnum.USER));
            identityDao.save(identify);

            User user = new User();
            user.setUserName(dto.getName());
            user.setPhoneNumber(dto.getPhoneNumber());
            user.setIdentify(identify);
            user.setCreateDate(new Date());
            userDao.save(user);
            return user;
        } catch (Exception ex) {
            throw new UserException(UserException.ErrorCode.NOT_FOUND_EXCEPTION, "Create not success", ex);
        }
    }

    public List<User> getListUser() {
        return userDao.findAll();
    }
}
