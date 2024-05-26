package bip.online.isuus2024.repository;


import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface AssesmenRepo extends JpaRepository<AssessmenEntity,Long> {
//    @Query(value =  "SELECT AVG (assessmen) FROM assessmens",nativeQuery = true)
//            Long getAvg();

    @Query(value = "SELECT AVG(assessmen) FROM assessmens INNER JOIN students  ON id_assessmen = id_assessmen WHERE id_group = id",nativeQuery = true)
    Double findAverageAssessmenByGroupId(@Param("id") Long groupId);
//https://www.cyberforum.ru/sql-server/thread448977.html
}
