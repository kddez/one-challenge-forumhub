package tech.kddez.forumhub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kddez.forumhub.domain.course.CourseRequestDTO;
import tech.kddez.forumhub.domain.course.CourseResponseDTO;
import tech.kddez.forumhub.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    @SecurityRequirement(name = "bearer-key")
    @PostMapping
    public ResponseEntity<CourseResponseDTO> createCourse(@RequestBody @Valid CourseRequestDTO request){
        var response = service.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<CourseResponseDTO>> listCourses(Pageable pageable){
        return ResponseEntity.ok(service.listCourses(pageable));
    }

}
