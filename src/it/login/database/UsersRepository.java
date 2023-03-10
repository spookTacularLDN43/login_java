package it.login.database;
import it.login.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.ArrayList;
import java.util.List;

public class UsersRepository {
    public List<User> userList = new ArrayList<>();
    private static final UsersRepository usersRepository = new UsersRepository();
    private UsersRepository() {
        this.userList.add(new User("admin", DigestUtils.md5Hex("admin")));
    }

    public static UsersRepository getInstance() {
        return usersRepository;
    }
    public boolean authenticate(String login, String password){
        for (User currentUser : userList) {
            if(currentUser.getLogin().equals(login)){
                if(currentUser.getPass().equals(DigestUtils.md5Hex(password))){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }
    public boolean register (String login, String pass){
        for (User currentUser: this.userList) {
            if(currentUser.getLogin().equals(login)){
                return false;
            }
        }
        this.userList.add(new User(login, DigestUtils.md5Hex(pass)));
        return true;
    }
}
