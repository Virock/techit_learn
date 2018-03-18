package techit.model.dao;

import java.util.List;

import techit.model.User;

public interface UserDao {

    User getUser(Long id);

    User getUser(String username);

    User getUser(String username, String email);

    User saveUser(User user);

    User updateUser(User user);

    List<User> getUsers();

    List<User> getUsers(int position, Long id);

    List<User> getUsers(int position, Long pos, Long unit_id);

}
