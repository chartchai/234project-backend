package camt.se234.project;

import camt.se234.project.dao.UserDao;
import camt.se234.project.entity.User;
import camt.se234.project.service.AuthenticationServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
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
        when(userDao.getUser("admin","admin")).thenReturn( new User(000001L,"admin","admin","admin"));
        assertThat(authenticationService.authenticate("admin","admin"),is( new User(000001L,"admin","admin","admin")));

        when(userDao.getUser("123","456")).thenReturn( new User(000002L,"123","456","user"));
        assertThat(authenticationService.authenticate("123","456"),is( new User(000002L,"123","456","user")));

    }
}
