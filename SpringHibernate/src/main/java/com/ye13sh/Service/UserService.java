package com.ye13sh.Service;

import com.ye13sh.Repository.UserRepo;
import com.ye13sh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo repo;
    @Transactional
    public User save(User user){
        repo.save(user);
        return user;
    }
    @Transactional
    public List<User> getAll(){
        return repo.getAll();
    }
    @Transactional
    public User get(int id){
        return repo.get(id);
    }
    @Transactional
    public void delete(int id){
        repo.delete(id);
    }
    @Transactional
    public User update(User user,int id){
       return repo.update(user,id);
    }
}
