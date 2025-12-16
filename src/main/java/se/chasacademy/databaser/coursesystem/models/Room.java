package se.chasacademy.databaser.coursesystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "rooms")
public class Room {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotNull
private String name;

@NotNull
private String address;

@Min(1)
private int capacity;

@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
private List<CourseSession> sessions;


}
