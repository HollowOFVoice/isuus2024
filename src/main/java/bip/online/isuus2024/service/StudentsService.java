package bip.online.isuus2024.service;

import bip.online.isuus2024.entity.SpecialsEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import bip.online.isuus2024.repository.SpecialsRepo;
import bip.online.isuus2024.repository.StudentsRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentsService {
    private final StudentsRepo repo;

    public List<StudentsEntity> findAll() {
        return repo.findAll();
    }

//    public Optional<StudentsEntity> findByRecordBook(int RecordBook) {
//        return repo.findBy();
//    }

//    public List<StudentsEntity>getStudByRecordBook(int recordBook){
//        return repo.findByRecordBook(recordBook);
//    }

    public Optional<StudentsEntity> findRecBook(Long recordBook) {
        return repo.findByRecordBook(recordBook);
    }
//    public List<StudentsEntity>getRecor(Long recBook){
//        return repo.findByRecordBook(recBook);
//    }

//    public Double findAverageAss(@Param("groupId") Long groupId) {
//        return repo.findAverageAssessmentByGroupId(groupId);
//    }

    public StudentsEntity  save(StudentsEntity data) {
        return repo.save(data);
    }

    public void update(StudentsEntity data) {
        repo.save(data);
    }
    public void delete (Long id) {
        repo.deleteById(id);
    }
}
