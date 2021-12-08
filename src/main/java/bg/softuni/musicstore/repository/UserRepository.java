package bg.softuni.musicstore.repository;

import bg.softuni.musicstore.model.entity.RoleEntity;
import bg.softuni.musicstore.model.entity.UserEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

    @EntityGraph(value = "user-roles")
    @Query("SELECT u FROM UserEntity u WHERE u.id=:id")
    UserEntity getUserEntity(@Param("id") Long Id);

    @EntityGraph(value = "user-roles")
    @Query("SELECT u FROM UserEntity u")
    List<UserEntity> findAll();


}