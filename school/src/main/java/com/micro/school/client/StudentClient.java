package com.micro.school.client;

import com.micro.school.Student;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    /**
     * StudentClient 인터페이스와 아래에 작성되는 메소드는
     * Open Feign에서 제공되는 자동 구현 or
     * Student MicroService와의 통신을 설정해 줍니다.
     */

    @GetMapping("/schools/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable("schoolId")Long schoolId);
}
