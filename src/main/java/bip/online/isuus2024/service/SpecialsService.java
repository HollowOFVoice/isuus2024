package bip.online.isuus2024.service;

import bip.online.isuus2024.entity.LessonsEntity;
import bip.online.isuus2024.entity.SpecialsEntity;
import bip.online.isuus2024.repository.LessonsRepo;
import bip.online.isuus2024.repository.SpecialsRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SpecialsService {
    private final SpecialsRepo repo;

    public List<SpecialsEntity> findAll() {
        return repo.findAll();
    }

    public Optional<SpecialsEntity> findById(Long id) {
        return repo.findById(id);
    }

    public SpecialsEntity  save(SpecialsEntity data) {
        return repo.save(data);
    }

    public void update(SpecialsEntity data) {
        repo.save(data);
    }
    public void delete (Long id) {
        repo.deleteById(id);
    }
}
