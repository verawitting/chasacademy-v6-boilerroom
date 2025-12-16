package se.chasacademy.databaser.coursesystem.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import se.chasacademy.databaser.coursesystem.models.CourseSession;
import se.chasacademy.databaser.coursesystem.models.Room;

@Repository
public interface CourseSessionRepository extends JpaRepository<CourseSession, Long> {
    List<CourseSession> findByCourseId(long courseId);

    List<CourseSession> findByRoomId(long roomId);

    List<CourseSession> findByDateAfter(LocalDateTime dateTime);

    default List<CourseSession> findAllAfterNow() {
        return findByDateAfter(LocalDateTime.now());
    }

    default HashMap<Room, List<CourseSession>> findSessionsGroupedByRoomAfterNow() {
        List<CourseSession> sessions = findAllAfterNow();
        HashMap<Room, List<CourseSession>> sessionsByRoom = new HashMap<>();
        for (CourseSession session : sessions) {
            Room room = session.getRoom();
            sessionsByRoom.putIfAbsent(room, new ArrayList<>());
            sessionsByRoom.get(room).add(session);
        }
        return sessionsByRoom;
    }
}
