package bip.online.isuus2024.service;


import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.repository.LessonsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class LessonsService {

    private final LessonsRepo repo;

    public List<LessonsEntity> findAll() {
        return repo.findAll();
    }

    public Optional<LessonsEntity> findById(Long id) {
        return repo.findById(id);
    }

    public LessonsEntity  save(LessonsEntity data) {
        return repo.save(data);
    }

    public void update(LessonsEntity data) {
        repo.save(data);
    }
    public void delete (Long id) {
        repo.deleteById(id);
    }
}

