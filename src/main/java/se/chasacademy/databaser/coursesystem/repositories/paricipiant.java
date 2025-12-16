package se.chasacademy.databaser.coursesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import se.chasacademy.databaser.coursesystem.models.participant;

public interface paricipiant extends JpaRepository<participant, Long> {
}
