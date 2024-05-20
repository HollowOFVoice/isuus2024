package bip.online.isuus2024.repository;


import bip.online.isuus2024.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentsRepo extends JpaRepository<StudentsEntity,Long> {
Optional<StudentsEntity>findByRecordBook(Long recordBook);
}


//ПРоблема со студентом, не работает метод с поиском