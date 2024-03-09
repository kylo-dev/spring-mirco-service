package com.micro.school;

import com.micro.school.client.StudentClient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final StudentClient studentClient;

    public void saveSchool(School school) {
        schoolRepository.save(school);
    }

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public FullSchoolResponse findSchoolsWithStudents(Long schoolId) {

        School school = schoolRepository.findById(schoolId).get();

        // find all the students from the student micro-service!!
        List<Student> students = studentClient.findAllStudentsBySchool(schoolId);

        return FullSchoolResponse.builder()
            .name(school.getName())
            .email(school.getEmail())
            .students(students)
            .build();
    }
}
