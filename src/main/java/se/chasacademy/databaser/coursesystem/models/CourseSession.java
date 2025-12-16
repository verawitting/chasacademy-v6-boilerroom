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

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    /**
     * Do not call this constructor directly. Use
     * {@link #CourseSession(LocalDateTime, Course)} instead.
     */
    public CourseSession() {
        this.date = LocalDateTime.now();
    }

    public CourseSession(@NonNull LocalDateTime date, @NonNull Course course, @NonNull Room room) {
        this.date = date;
        this.course = course;
        this.room = room;
        course.getSessions().add(this);
        room.addSession(this);
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

    public @NonNull Room getRoom() {
        return room;
    }

    public void setRoom(@NonNull Room room) {
        // Early out for stupid room assignments
        if (this.room == room) {
            return;
        }
        this.room.removeSession(this);
        this.room = room;
        room.addSession(this);
    }

    public @NonNull Course getCourse() {
        return course;
    }
}
