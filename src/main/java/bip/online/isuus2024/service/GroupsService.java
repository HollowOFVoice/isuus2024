package bip.online.isuus2024.service;


import bip.online.isuus2024.entity.GroupsEntity;

import bip.online.isuus2024.repository.GroupsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupsService {

    private final GroupsRepo repo;

    public List<GroupsEntity > findAll() {
        return repo.findAll();
    }

    public Optional<GroupsEntity > findById(Long id) {
        return repo.findById(id);
    }

    public GroupsEntity  save(GroupsEntity  data) {
        return repo.save(data);
    }

    public void update(GroupsEntity  data) {
        repo.save(data);
    }

}
