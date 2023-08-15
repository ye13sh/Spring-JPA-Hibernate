package com.ye13sh.Controller;

import com.ye13sh.Service.UserService;
import com.ye13sh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/save")
    public User save(@RequestBody User user){
      return service.save(user);
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return service.getAll();
    }
    @GetMapping("/user/{id}")
    public User get(@PathVariable int id){
        return service.get(id);
    }
    @PutMapping("/update/{id}")
    public User update(@RequestBody User user,@PathVariable int id){
        return service.update(user,id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id){
         service.delete(id);
         return "Deleted";
    }
}
