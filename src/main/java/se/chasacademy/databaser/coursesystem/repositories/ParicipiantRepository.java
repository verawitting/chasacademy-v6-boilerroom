package se.chasacademy.databaser.coursesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.chasacademy.databaser.coursesystem.models.Participant;

public interface ParicipiantRepository extends JpaRepository<Participant, Long> {
}
