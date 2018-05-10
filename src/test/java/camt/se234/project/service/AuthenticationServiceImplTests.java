package camt.se234.project.service;


import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.junit.Before;
import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AuthenticationServiceImplTests {
    UserDao userDao;
    AuthenticationServiceImpl authenticationService;

    @Before
    public void setup(){
        userDao = mock(UserDao.class);
        authenticationService = new AuthenticationServiceImpl();
        authenticationService.setUserDao(userDao);
    }
    @Test
    public void testAuthentication(){
        when(userDao.getUser("admin","admin")).thenReturn(new User(null,"admin","admin","admin"));
        when(userDao.getUser("user","user")).thenReturn(new User(null,"user","user","user"));
        when(userDao.getUser("ccc","003")).thenReturn(new User(null,"ccc","003","user"));
        assertThat(userDao.getUser("admin","admin"),is(new User(null,"admin","admin","admin")));
    }

    private void assertThat(User user, PropertyState propertyState) {
    }

}
