package com.sachin.rest.webservices.restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();
    private static int userCount = 4;

    // == create static users

    static {
        users.add(new User(1, "Sachin", new Date()));
        users.add(new User(2, "Arjun", new Date()));
        users.add(new User(3, "Jhon", new Date()));
        users.add(new User(4, "Bob", new Date()));
    }

    // == Find All users
    public List<User> findAll(){
        return users;
    }

    // == save Users
    public User saveUser(User user){
        if(user.getId()==null){
            user.setId(++userCount);
            System.out.println("Find Null");
        }
        users.add(user);
        return user;
    }

    // == find user
    public User findUser(int id){
        for(User user:users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;

    }

    // == delete user
    public User deleteUser(int id){
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;

    }
}
