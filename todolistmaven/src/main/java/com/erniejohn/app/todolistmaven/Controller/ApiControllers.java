package com.erniejohn.app.todolistmaven.Controller;

import com.erniejohn.app.todolistmaven.Models.User;
import com.erniejohn.app.todolistmaven.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestController, this portion is to create endpoints to our API
@RestController
public class ApiControllers {

    @Autowired //This is used to inject dependencies
    private UserRepo userRepo;
    //GetMapping is to create the actual endpoints of our REST API
    @GetMapping(value="/")
    public String getPage() {
        return "Welcome";
    }

    @GetMapping(value="/todolist")
    public List<User> getUsers(){
        return userRepo.findAll(); //this function findAll() is used to get the content of the database
    }

    @PostMapping(value="/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User UpdatedUser = userRepo.findById(id).get();
        UpdatedUser.setTododesc(user.getTododesc());
        userRepo.save(UpdatedUser);
        return "Updated.. ";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id, User user){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted todo item with ID " + id;
    }
}
