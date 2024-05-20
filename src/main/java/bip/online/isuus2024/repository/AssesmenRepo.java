package bip.online.isuus2024.repository;


import bip.online.isuus2024.entity.AssessmenEntity;
import bip.online.isuus2024.entity.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssesmenRepo extends JpaRepository<AssessmenEntity,Long> {


}
