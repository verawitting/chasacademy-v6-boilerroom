package se.chasacademy.databaser.coursesystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.chasacademy.databaser.coursesystem.models.*;
import se.chasacademy.databaser.coursesystem.repositories.*;

import java.time.LocalDateTime;

@SpringBootApplication
public class CourseSystemApplication implements CommandLineRunner {

    private CourseRepository courseRepository;
    private CourseSessionRepository courseSessionRepository;
    private ParticipantRepository participantRepository;
    private RoomRepository roomRepository;
    private TeacherRepository teacherRepository;

    public CourseSystemApplication(CourseRepository courseRepository, CourseSessionRepository courseSessionRepository, ParticipantRepository participantRepository, RoomRepository roomRepository, TeacherRepository teacherRepository) {
        this.courseRepository = courseRepository;
        this.courseSessionRepository = courseSessionRepository;
        this.participantRepository = participantRepository;
        this.roomRepository = roomRepository;
        this.teacherRepository = teacherRepository;
    }

    public static void main(String[] args) {
		SpringApplication.run(CourseSystemApplication.class, args);
	}

	@Override
	public void run(String... args) {
        var teacher1 = new Teacher("Mona" , "Salin", "monas@mail.se");
        var teacher2 = new Teacher("Roger", "Pontare", "rogers@mail.se");

        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);

        var room1 = new Room("Rosenbad", "Rosenbadsvägen 1", 349);
        var room2 = new Room("Globen", "Globenvägen 1", 1000);

        roomRepository.save(room1);
        roomRepository.save(room2);

        var course1 = new Course("samhällskunskap", "En bra kurs.", 25, teacher1 );
        var course2 = new Course("musik", "Värsta schlagern.", 50, teacher2 );
        var course3 = new Course("ekonomi", "Pengar och sånt.", 20, teacher1);
        var course4 = new Course("svenska", "Text och musik", 18, teacher2);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);

        var p1 = new Participant("Darin", "darin@mail.se", course2);
        var p2 = new Participant("Carola", "carola@mail.se", course1);
        var p3 = new Participant("Lena PH", "lenas@mail.se", course4);
        var p4 = new Participant("David Druid", "davids@mail.se", course3);

        participantRepository.save(p1);
        participantRepository.save(p2);
        participantRepository.save(p3);
        participantRepository.save(p4);

        var cs1 = new CourseSession(LocalDateTime.of(2025,12,25,12,30), course4, room2);

        courseSessionRepository.save(cs1);

//       Kurser med lärare
        courseRepository.findAllByTeacherId(1L).forEach((course)-> System.out.println(course.getTitle()));

//        - Kurser med antal deltagare


//        - Kommande kurstillfällen per lokal
        courseSessionRepository.findAllAfterNow().forEach((courseSession) -> System.out.println(courseSession.getCourse().getTitle()));

//        - Lokaler med capacity > X
        roomRepository.findByCapacityGreaterThan(30).forEach((room) -> System.out.println(room.getCapacity()));

	}
}
