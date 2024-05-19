package bip.online.isuus2024.repository;

import bip.online.isuus2024.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<UsersEntity,Long> {
}
