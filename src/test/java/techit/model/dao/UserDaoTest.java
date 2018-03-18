package techit.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import techit.model.User;
import techit.model.User.Position;

;

@Test(groups = "UserDaoTest")
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserDaoTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    UserDao userDao;

    @Test
    public void getUser() {
        assert userDao.getUser(1L).getUsername().equalsIgnoreCase("admin");
    }

    @Test
    public void getUsers() {
        assert userDao.getUsers().size() >= 2;
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setFirstName("Rohan");
        user.setLastName("Goel");
        user.setDepartment(null);
        user.setEmail("rohangoel31@gmail.com");
        user.setPhoneNumber("323 723-6890");
        user.setPosition(Position.USER);
        user.setUsername("Tom");
        user.setPassword("abcd");
        user = userDao.saveUser(user);
        assert user.getId() != null;
    }

    @Test
    public void getUserByUsername() {
        assert userDao.getUser("cysun").getUsername() != null;
    }

    @Test
    public void getUserByPositonId() {
        assert userDao.getUsers(2, 2L).size() >= 1;
    }

    @Test
    public void updateEmail() {
        User user = userDao.getUser(1L);
        user.setEmail("abc@xyz.com");
        user = userDao.updateUser(user);
        assert user.getId() != null;
    }
}
