package com.kgs.webapp;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    // Моковые данные пользователей
    private static List<User> users = new ArrayList<>();

    static {
        for (int i = 1; i <= 10; i++) {
            users.add(new User(i, "Юзерович" + i));
        }
    }

    @GetMapping("/users")
    public String users() {
// Endpoint для получения списка пользователей (getListUsers)
// Возвращает JSON со списком пользователей.
// Пример ответа:
// [
//     {"userId":1,"family":"Юзерович1"},
//     {"userId":2,"family":"Юзерович2"},
//     ...
// ]

        return "users";
    }
    @ResponseStatus(HttpStatus.OK)
    public List<User> getListUsers() {
        return users.stream()
        .map(user -> new User(user.getUserId(), user.getFamily()))
        .toList();
    }

    @PostMapping("/users")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Response createUser(@RequestBody User user) {
        // Простая реализация создания пользователя без базы данных.
        // В реальном приложении следует использовать базу данных для хранения данных.
        return new Response(user.getUserId(), user.getFamily(), "Создан");
    }
    
    private static class Response { 
        private int userId; 
        private String family; 
        private String status;
  
        public Response(int userId, String family, String status) { 
            this.userId = userId; 
            this.family = family; 
            this.status = status; 
        } 
  
        @Override
        public String toString() {  
            return "{\"userId\":" +(userId)+",\"family\":\""+(family)+"\",\"status\":\""+(status)+"\"}";
  }
}
}
