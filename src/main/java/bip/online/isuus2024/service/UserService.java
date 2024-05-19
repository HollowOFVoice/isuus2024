package bip.online.isuus2024.service;


import bip.online.isuus2024.entity.UsersEntity;

import bip.online.isuus2024.repository.UsersRepo;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private final UsersRepo repo;

    public UsersEntity  save(UsersEntity  data) {
        return repo.save(data);
    }
}
