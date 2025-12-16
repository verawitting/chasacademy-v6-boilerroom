package se.chasacademy.databaser.coursesystem.models;

import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CourseSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private LocalDateTime date;
    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    /**
     * Do not call this constructor directly. Use
     * {@link #CourseSession(LocalDateTime, Course)} instead.
     */
    public CourseSession() {
        this.date = LocalDateTime.now();
    }

    public CourseSession(@NonNull LocalDateTime date, @NonNull Course course) {
        this.date = date;
        this.course = course;
        course.getSessions().add(this);
    }

    public long getId() {
        return id;
    }

    public @NonNull LocalDateTime getDate() {
        return date;
    }

    public void setDate(@NonNull LocalDateTime date) {
        this.date = date;
    }

}
