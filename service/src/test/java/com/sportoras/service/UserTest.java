package com.sportoras.service;

import com.sportoras.database.entity.FullName;
import com.sportoras.database.entity.Material;
import com.sportoras.database.entity.User;
import com.sportoras.database.entity.UserDetail;
import com.sportoras.database.repository.UserDetailRepository;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.configuration.ServiceConfiguration;
import com.sportoras.service.dto.Material.MaterialDto;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.dto.userDto.UserDetailCreateDto;
import com.sportoras.service.exception.EntityAlreadyExistException;
import com.sportoras.service.exception.EntityNotFoundException;
import com.sportoras.service.service.UserDetailService;
import com.sportoras.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class UserTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    private UserDetailRepository userDetailRepository;


    @Test
    public void checkSaveUser() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        assertNotNull(user);
    }

    @Test
    public void checkFindById() {
        User user = userRepository.save(new User("mail", "111", FullName.of("Irina", "Nikolaevna")));
        User testUser = userService.findUserById(user.getId());
        assertNotNull(testUser);
    }

    @Test
    public void checkAllUsers() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaeva")));
        User user1 = userRepository.save(new User("testmail1", "222", FullName.of("Svetlana", "Ivanova")));
        User user2 = userRepository.save(new User("testmail2", "333", FullName.of("Vladimir", "Ignatenko")));
        List<UserBasicDto> users = userService.findAllUsers();
        assertThat(users, hasSize(3));
    }

    @Test
    public void checkSaveUserDetail() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        UserDetail userDetail = userDetailService.saveUserDetail(UserDetailCreateDto.builder()
                .company("Roga i Kopyta")
                .otherInformation("Vse obo vsem!")
                .phone("555 55 55")
                .user(user)
                .build());
        assertNotNull(userDetail);
    }

    @Test(expected = EntityAlreadyExistException.class)
    public void checkSaveExceptin() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        User user2 = userRepository.save(new User("testmail", "111", FullName.of("Irina2", "Nikolaevna2")));
    }

    @Test(expected = EntityNotFoundException.class)
    public void checkFindByIdExceptin() {
        User user = userService.findUserById(100L);
    }
}
