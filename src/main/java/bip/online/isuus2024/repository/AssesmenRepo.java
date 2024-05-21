package bip.online.isuus2024.repository;


import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface AssesmenRepo extends JpaRepository<AssessmenEntity,Long> {
//    @Query(value =  "SELECT AVG (assessmen) FROM assessmens",nativeQuery = true)
//            Long getAvg();
    @Query(value =  "SELECT AVG(assessmen)  FROM assessmens AS avg_assesmen JOIN groupss AS avg_asses ON  ='СС2'",nativeQuery = true)
    Long getAvg();

}


//https://www.cyberforum.ru/sql-server/thread448977.html

