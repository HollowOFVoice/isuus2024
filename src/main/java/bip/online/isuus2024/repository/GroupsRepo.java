package bip.online.isuus2024.repository;



import bip.online.isuus2024.entity.GroupsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupsRepo extends JpaRepository<GroupsEntity,Long> {
//  List<BookEntity>findByBookName(String bookName);
}
