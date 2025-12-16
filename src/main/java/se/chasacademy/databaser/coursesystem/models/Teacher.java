package se.chasacademy.databaser.coursesystem.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Check(constraints = "length(first_name) >= 2")
@Check(constraints = "length(last_name) >= 2")


@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;
}
