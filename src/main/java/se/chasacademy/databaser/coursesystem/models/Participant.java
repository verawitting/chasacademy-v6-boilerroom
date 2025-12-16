package se.chasacademy.databaser.coursesystem.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToMany(mappedBy = "participants")
    private Set<Course> courses;

    //constructors
    public Participant() {
    }

    public Participant(String fullName, String email, Course courses) {
        this.fullName = fullName;
        this.email = email;
        this.courses = new HashSet<>();
    }

    public Participant(long id, String fullName, String email, Course courses) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.courses = new HashSet<>();
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
