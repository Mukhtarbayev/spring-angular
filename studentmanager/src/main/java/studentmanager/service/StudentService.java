package studentmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentmanager.exception.StudentNotFoundException;
import studentmanager.model.Student;
import studentmanager.repo.StudentRepo;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student addStudent(Student student){
        student.setStudentCode(UUID.randomUUID().toString());
        return studentRepo.save(student);
    }

    public List<Student> findAllStudents(){
        return studentRepo.findAll();
    }

    public Student updateStudent(Student student){
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id){
        studentRepo.deleteStudentById(id);
    }

    public Student findStudentById(Long id) throws StudentNotFoundException {
        return studentRepo.findStudentById(id).orElseThrow(()-> new StudentNotFoundException("Student by id " + id + "was not found"));
    }
}
