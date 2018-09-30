package com.daicy.mockito.user;

import com.daicy.mockito.user.User;
import com.daicy.mockito.user.UserDao;
import com.daicy.mockito.user.UserService;
import com.daicy.mockito.user.UserServiceImpl;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.sql.SQLException;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullUser() throws Exception {
        UserService userService = new UserServiceImpl();

        // 创建mock
        UserDao userDao = mock(UserDao.class);
        ((UserServiceImpl) userService).setUserDao(userDao);

        userService.createNewUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUserId() throws Exception {
        UserService userService = new UserServiceImpl();

        // 创建mock
        UserDao userDao = mock(UserDao.class);
        ((UserServiceImpl) userService).setUserDao(userDao);

        User user = new User();
        user.setId(null);
        userService.createNewUser(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullUserName() throws Exception {
        UserService userService = new UserServiceImpl();

        // 创建mock
        UserDao userDao = mock(UserDao.class);
        ((UserServiceImpl) userService).setUserDao(userDao);

        User user = new User();
        user.setId(1L);
        user.setName("");
        userService.createNewUser(user);
    }

    @Test(expected = Exception.class)
    public void testCreateExistUser() throws Exception {
        UserService userService = new UserServiceImpl();

        // 创建mock
        UserDao userDao = mock(UserDao.class);
        User returnUser = new User();
        returnUser.setId(1L);
        returnUser.setName("Vikey");
        when(userDao.queryUser(1L)).thenReturn(returnUser);
        ((UserServiceImpl) userService).setUserDao(userDao);

        User user = new User();
        user.setId(1L);
        user.setName("Vikey");
        userService.createNewUser(user);
    }

    @Test(expected = Exception.class)
    public void testCreateUserOnDatabaseException() throws Exception {
        UserService userService = new UserServiceImpl();

        // 创建mock
        UserDao userDao = mock(UserDao.class);
        doThrow(new SQLException("SQL is not valid")).when(userDao).insertUser(any(User.class));
        ((UserServiceImpl) userService).setUserDao(userDao);

        User user = new User();
        user.setId(1L);
        user.setName("Vikey");
        userService.createNewUser(user);
    }

    @Test
    public void testCreateUser() throws Exception {
        UserService userService = new UserServiceImpl();

        // 创建mock
        UserDao userDao = mock(UserDao.class);
        doAnswer(new Answer<Void>() {
            public Void answer(InvocationOnMock invocation) throws Throwable {
                System.out.println("Insert data into user table");
                return null;
            }
        }).when(userDao).insertUser(any(User.class));
        ((UserServiceImpl) userService).setUserDao(userDao);

        User user = new User();
        user.setId(1L);
        user.setName("Vikey");
        userService.createNewUser(user);
    }
}
