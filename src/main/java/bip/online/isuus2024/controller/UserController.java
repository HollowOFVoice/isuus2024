package bip.online.isuus2024.controller;


import bip.online.isuus2024.entity.UsersEntity;
import bip.online.isuus2024.responce.DataResponse;

import bip.online.isuus2024.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<DataResponse<UsersEntity>> save(@RequestBody UsersEntity user) {
        return ResponseEntity.ok(
                new DataResponse<UsersEntity>(true, "Пользователь добавлен!", service.save(user)));
    }


}