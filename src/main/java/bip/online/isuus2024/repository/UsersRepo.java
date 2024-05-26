package bip.online.isuus2024.repository;

import bip.online.isuus2024.entity.StudentsEntity;
import bip.online.isuus2024.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<UsersEntity,Long> {
    Optional<UsersEntity> findByUsernameAndPassword(String username,String password);
}
