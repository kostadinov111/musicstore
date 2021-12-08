package bg.softuni.musicstore.repository;

import bg.softuni.musicstore.model.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {


}
