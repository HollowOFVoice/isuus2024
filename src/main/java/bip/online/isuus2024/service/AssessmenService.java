package bip.online.isuus2024.service;

import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.repository.AssesmenRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AssessmenService {
    private final AssesmenRepo repo;

    public List<AssessmenEntity> findAll() {
        return repo.findAll();
    }

    public Optional<AssessmenEntity> findById(Long id) {
        return repo.findById(id);
    }

    public AssessmenEntity save(AssessmenEntity data) {
        return repo.save(data);
    }

    public void update(AssessmenEntity data) {
        repo.save(data);
    }
}
