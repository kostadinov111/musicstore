package bg.softuni.musicstore.repository;

import bg.softuni.musicstore.model.entity.EventEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Long> {

    @EntityGraph(value = "event-musicians")
    @Query("SELECT e FROM EventEntity e")
    List<EventEntity> findAllByEventEntity();
}
