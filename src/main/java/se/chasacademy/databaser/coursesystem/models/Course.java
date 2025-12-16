package se.chasacademy.databaser.coursesystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Min(1)
    @Max(5)
    @Column(name = "max_participants", nullable = false)
    private int maxParticipants;

    //----- Relations

    @ManyToOne(optional = false)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<CourseSession> sessions = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "course_participant",
            joinColumns = @JoinColumn("name = course_id"),
            inverseJoinColumns = @JoinColumn(name = "participant_id")
    )

    private List<Participant> participants = new ArrayList<>();

    public Course() {}

    public Course(String title, String description, int maxParticipants, Teacher teacher) {
        this.title = title;
        this.description = description;
        this.maxParticipants = maxParticipants;
        this.teacher = teacher;
    }

    public Long getId() { return id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<CourseSession> getSessions() {
        return sessions;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
