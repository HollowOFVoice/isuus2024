package bip.online.isuus2024.repository;


import bip.online.isuus2024.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentsRepo extends JpaRepository<StudentsEntity,Long> {
    List<StudentsEntity> findByRecordBook(int RecordBook);
}


//ПРоблема со студентом, не работает метод с поиском