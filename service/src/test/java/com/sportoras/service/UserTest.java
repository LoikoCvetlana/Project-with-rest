package com.sportoras.service;

import com.sportoras.database.entity.FullName;
import com.sportoras.database.entity.User;
import com.sportoras.database.entity.UserDetail;
import com.sportoras.database.repository.UserDetailRepository;
import com.sportoras.database.repository.UserRepository;
import com.sportoras.service.configuration.ServiceConfiguration;
import com.sportoras.service.dto.userDto.UserBasicDto;
import com.sportoras.service.dto.userDto.UserCreateDto;
import com.sportoras.service.dto.userDto.UserDetailCreateDto;
import com.sportoras.service.dto.userDto.UserDetailUpdateDto;
import com.sportoras.service.exception.EntityNotFoundException;
import com.sportoras.service.service.UserDetailService;
import com.sportoras.service.service.UserSaveServise;
import com.sportoras.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class UserTest {

    @Autowired
    private UserService userService;
    @Autowired
    private UserSaveServise userSaveServise;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    UserDetailService userDetailService;
    @Autowired
    private UserDetailRepository userDetailRepository;

    @Test
    public void checkSaveUser() {
        userSaveServise.saveNewUser(UserCreateDto.builder()
                .email("111")
                .fullName(FullName.of("Irina", "Valerevna"))
                .password("111")
                .build());
        User user = userService.findUserByEmail("111");
        assertNotNull(user);
    }

    @Test
    public void checkFindById() {
        userSaveServise.saveNewUser(UserCreateDto.builder()
                .email("111")
                .fullName(FullName.of("Irina", "Valerevna"))
                .password("111")
                .build());
        User user = userService.findUserByEmail("111");
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

    @Test
    public void checkUpdateUserDetail() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        UserDetail userDetail = userDetailService.saveUserDetail(UserDetailCreateDto.builder()
                .company("Roga i Kopyta")
                .otherInformation("Vse obo vsem!")
                .phone("555 55 55")
                .user(user)
                .build());
        UserDetail updatedUserDetail = userDetailService.updarteUserDetail(UserDetailUpdateDto.builder()
                .id(userDetail.getId())
                .user(user)
                .company("111")
                .otherInformation("111")
                .phone("111")
                .position("111")
                .build());
        UserDetail checkedUserDetail = userDetailService.findUserDetailByUser(user);
        assertEquals(updatedUserDetail, checkedUserDetail);
    }

    @Test(expected = EntityNotFoundException.class)
    public void checkUpdateUserDetailException() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        UserDetail userDetail = userDetailService.saveUserDetail(UserDetailCreateDto.builder()
                .company("Roga i Kopyta")
                .otherInformation("Vse obo vsem!")
                .phone("555 55 55")
                .user(user)
                .build());
        userDetailService.deleteUserDetail(userDetail.getId());
        UserDetail updatedUserDetail = userDetailService.updarteUserDetail(UserDetailUpdateDto.builder()
                .id(userDetail.getId())
                .user(user)
                .company("111")
                .otherInformation("111")
                .phone("111")
                .position("111")
                .build());
        UserDetail checkedUserDetail = userDetailService.findUserDetailByUser(user);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void checkSaveExceptin() {
        User user = userRepository.save(new User("testmail", "111", FullName.of("Irina", "Nikolaevna")));
        User user2 = userRepository.save(new User("testmail", "111", FullName.of("Irina2", "Nikolaevna2")));
    }

    @Test(expected = EntityNotFoundException.class)
    public void checkFindByIdExceptin() {
        User user = userService.findUserById(100L);
    }

}
