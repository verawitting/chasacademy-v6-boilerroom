package se.chasacademy.databaser.coursesystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column
@NotNull
private String name;

@Column
@NotNull
private String address;

@Column
@Min(1)
private int capacity;

@OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
private List<CourseSession> sessions;


}
