package bg.softuni.musicstore.repository;

import bg.softuni.musicstore.model.entity.MusicianEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicianRepository extends JpaRepository<MusicianEntity, Long> {

    @EntityGraph(value = "musician-albums")
    @Query("SELECT m FROM MusicianEntity m")
    List<MusicianEntity> findAllByMusicianEntity();

    @EntityGraph(value = "musician-albums")
    @Query("SELECT m FROM MusicianEntity m WHERE m.id=:id")
    MusicianEntity findEntityById(@Param("id") Long id);

    Optional<MusicianEntity> findMusicianEntityByName(String name);
}
