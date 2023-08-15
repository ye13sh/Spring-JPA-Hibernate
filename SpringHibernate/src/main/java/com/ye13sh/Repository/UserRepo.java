package com.ye13sh.Repository;

import com.ye13sh.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    private EntityManager entityManager;
    public void save(User user){
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    public List<User> getAll(){
        Session session=entityManager.unwrap(Session.class);
        Query<User> query=session.createQuery("from User",User.class);
        List<User> users=query.getResultList();
        return users;
    }

    public User get(int id){
       Session session= entityManager.unwrap(Session.class);
       User user= session.get(User.class,id);
       return user;
    }

    public void delete(int id){
        Session session = entityManager.unwrap(Session.class);
        User user=session.get(User.class,id);
        session.delete(user);
    }

    public User update(User user,int id){
        Session session=entityManager.unwrap(Session.class);
        User u=session.get(User.class,id);
        u.setName(user.getName());
        u.setAddress(user.getAddress());
        session.save(u);
        return u;
    }
}
