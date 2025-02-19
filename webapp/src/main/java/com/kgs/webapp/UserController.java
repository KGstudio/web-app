package com.kgs.webapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users") // Указываем базовый путь для всех методов этого контроллера
public class UserController {

    // Список пользователей
    private static List<User> users = new ArrayList<>();

    // Блок для моковых данных
    static {
        for (int i = 1; i <= 10; i++) {
            users.add(new User(i, "Юзерович" + i));
        }
    }

    // Обработка GET-запроса для получения списка пользователей
    @GetMapping(produces = "application/json") // Указываем, что метод возвращает JSON
    public List<User> getListUsers() {
        return users; // Возвращаем список пользователей
    }

    // Обработка POST-запроса для создания нового пользователя
    @PostMapping(consumes = "application/json", produces = "application/json") // Указываем, что метод принимает JSON и возвращает JSON
    public Response createUser(@RequestBody User user) {
        // Создание пользователя
        users.add(user); // Добавляем нового пользователя в список
        return new Response(user.getUserId(), user.getFamily(), "Создан"); // Возвращаем ответ с информацией о создании
    }

    // Внутренний класс для представления ответа на создание пользователя
    private static class Response {
        private int userId;
        private String family;
        private String status;

        public Response(int userId, String family, String status) {
            this.userId = userId;
            this.family = family;
            this.status = status;
        }

        @SuppressWarnings("unused")
        public int getUserId() {
            return userId;
        }
        @SuppressWarnings("unused")
        public String getFamily() {
            return family;
        }
        @SuppressWarnings("unused")
        public String getStatus() {
            return status;
        }
    }
}
