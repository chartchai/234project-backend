package camt.se234.project.service;

import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTest {
    AuthenticationServiceImpl authenticationService;
    UserDao userDao;

    @Before
    public void setup(){
        userDao = mock(UserDao.class);
        authenticationService = new AuthenticationServiceImpl();
        authenticationService.setUserDao(userDao);
    }

    @Test
    public void testAuthenticate(){
        when(userDao.getUser("Chamnol", "12345")).thenReturn(
                new User("Chamnol", "12345", "Student"));
        when(userDao.getUser("Kitiyanee", "password")).thenReturn(
                new User("Kitiyanee", "password", "Manager"));
        assertThat(authenticationService.authenticate("Chamnol", "12345"),
                is(new User("Chamnol", "12345", "Student")));
        assertThat(authenticationService.authenticate("Kitiyanee", "password"),
                is(new User("Kitiyanee", "password", "Manager")));
    }

    @Test (expected =NullPointerException.class)
    public void testAuthenticateNoDataException(){
        assertThat(authenticationService.authenticate("Dara", "123456"), is(nullValue()));
        assertThat(authenticationService.authenticate("AAAA", "ddafdef"), is(nullValue()));
    }
}
