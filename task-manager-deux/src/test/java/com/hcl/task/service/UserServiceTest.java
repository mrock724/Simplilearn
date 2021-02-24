package com.hcl.task.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hcl.task.model.User;
import com.hcl.task.repo.RoleRepo;
import com.hcl.task.repo.UserRepo;
import com.hcl.task.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @Mock
    private UserRepo mockUserRepository;
    @Mock
    private RoleRepo mockRoleRepository;
    @Mock
    private BCryptPasswordEncoder mockBCryptPasswordEncoder;

    private UserService userServiceUnderTest;
    private User user;

    @Before
    public void setUp() {
        initMocks(this);
        userServiceUnderTest = new UserService(mockUserRepository,
                                               mockRoleRepository,
                                               mockBCryptPasswordEncoder);
        user = User.builder()
                .id(1)
                .userName("test")
                .build();

        Mockito.when(mockUserRepository.save(any()))
                .thenReturn(user);
        Mockito.when(mockUserRepository.findByUserName(anyString()))
                .thenReturn(user);
    }

    @Test
    public void testFindUserByUserName() {
        // Setup
        final String userName = "test";

        // Run the test
        final User result = userServiceUnderTest.findUserByUserName(userName);

        // Verify the results
        assertEquals(userName, result.getUserName());
    }

    @Test
    public void testSaveUser() {
        // Setup
        final String userName = "test";

        // Run the test
        User result = userServiceUnderTest.saveUser(User.builder().build());

        // Verify the results
        assertEquals(userName, result.getUserName());
    }
}
