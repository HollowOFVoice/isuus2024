package bip.online.isuus2024.repository;


import bip.online.isuus2024.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface StudentsRepo extends JpaRepository<StudentsEntity,Long> {
Optional<StudentsEntity>findByRecordBook(Long recordBook);
   // List<StudentsEntity>findByRecordBook(Long recbook);


//    @Query(value =  "SELECT AVG (assessmen) FROM assessmens",nativeQuery = true)
//    Long getAvg();

//    @Query(value ="SELECT AVG(assessmen) FROM students  "
//            + "JOIN assessmens ON id_assessment = id "
//            + "WHERE id_group = groupId", nativeQuery = true)
//    Double findAverageAssessmentByGroupId(@Param("groupId") Long groupId);


}


//ПРоблема со студентом, не работает метод с поиском