package bg.softuni.musicstore.repository;

import bg.softuni.musicstore.model.entity.RoleEntity;
import bg.softuni.musicstore.model.enums.RoleNameEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

    RoleEntity findByRole(RoleNameEnums role);
}
