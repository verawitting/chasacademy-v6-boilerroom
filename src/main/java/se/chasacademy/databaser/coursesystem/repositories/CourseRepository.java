package se.chasacademy.databaser.coursesystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.chasacademy.databaser.coursesystem.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findByTitle(String title);

    @Query("""
        select c
        from Course c
        join fetch c.teacher t
        where t.id = :teacherId
    """)
    List<Course> findAllByTeacherId(@Param("teacherId") Long teacherId);

    @Query("""
        select case
                when size(c.participants) >= c.maxParticipants
                then true else false
        end
        from Course c
        where c.id = :courseId
    """)
    boolean isCourseFull(Long courseId);
}
