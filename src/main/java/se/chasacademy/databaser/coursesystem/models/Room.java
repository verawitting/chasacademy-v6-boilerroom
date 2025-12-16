package se.chasacademy.databaser.coursesystem.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
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
    private List<CourseSession> sessions = new ArrayList<>();

    public Room() {
    }

    public Room(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<CourseSession> getSessions() {
        return sessions;
    }

    public void setSessions(List<CourseSession> sessions) {
        this.sessions = sessions;
    }

    public void addSession(CourseSession session) {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        sessions.add(session);
        session.setRoom(this);
    }

    public void removeSession(CourseSession session) {
        if (sessions != null) {
            sessions.remove(session);
            session.setRoom(null);
        }
    }
}
