package tech.kddez.forumhub.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.kddez.forumhub.domain.course.Course;
import tech.kddez.forumhub.repository.CourseRepository;
import tech.kddez.forumhub.domain.course.CourseRequestDTO;
import tech.kddez.forumhub.domain.course.CourseResponseDTO;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CourseResponseDTO createCourse(CourseRequestDTO request){
       var entity = new Course(request);
       repository.save(entity);
       return new CourseResponseDTO(entity);
    }

    public Page<CourseResponseDTO> listCourses(Pageable pageable){
        return repository.findAll(pageable).map(CourseResponseDTO::new);
    }

}
