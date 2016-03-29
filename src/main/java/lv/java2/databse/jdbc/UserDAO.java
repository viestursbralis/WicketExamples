package lv.java2.databse.jdbc;

import lv.java2.user.User;

/**
 * Created by Viesturs on 27-Mar-16.
 */
public interface UserDAO {

    void createNewUserInDatabase(User user) throws DBException;

    /*User getUserById(Long id) throws DBException;

    void deleteUser(Long id) throws DBException;

    void updateUser(User user) throws DBException;

    List<User> getAllUsers() throws DBException;

    User findUserByCredentials(String username, String password)throws DBException;



    User findUserLike(String s) throws DBException;

    User findUserByPropertyID(Long ID) throws DBException;*/



}
