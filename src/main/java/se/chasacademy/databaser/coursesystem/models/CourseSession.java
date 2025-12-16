package se.chasacademy.databaser.coursesystem.models;

import java.time.LocalDateTime;

import org.jspecify.annotations.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CourseSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private LocalDateTime date;

    public CourseSession() {
        this.date = LocalDateTime.now();
    }

    public CourseSession(@NonNull LocalDateTime date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
