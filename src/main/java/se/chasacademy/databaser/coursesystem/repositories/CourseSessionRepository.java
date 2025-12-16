package se.chasacademy.databaser.coursesystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se.chasacademy.databaser.coursesystem.models.CourseSession;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {
    List<CourseSession> findByCourseId(long courseId);

    List<CourseSession> findByRoomId(long roomId);
}
