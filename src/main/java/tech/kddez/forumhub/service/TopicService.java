package tech.kddez.forumhub.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.kddez.forumhub.domain.topic.*;
import tech.kddez.forumhub.repository.CourseRepository;
import tech.kddez.forumhub.repository.TopicRepository;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    private final UserService userService;

    private final CourseRepository courseRepository;

    public TopicService(TopicRepository topicRepository, UserService userService, CourseRepository courseRepository) {
        this.topicRepository = topicRepository;
        this.userService = userService;
        this.courseRepository = courseRepository;
    }


    @Transactional
    public TopicResponseDTO createTopic(TopicRequestDTO request){

        var course = courseRepository.findById(request.courseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + request.courseId()));

        var author = userService.getAuthenticatedUser();
        var topic = new Topic(request.title(), request.message(), request.status(), course, author);
        topicRepository.save(topic);
        return new TopicResponseDTO(topic);
    }

    public Page<TopicResponseDTO> listTopics(Pageable pageable) {
        return topicRepository.findAll(pageable).map(TopicResponseDTO::new);
    }

    public TopicDetailsResponseDTO getTopic(Long id) {
        return topicRepository.findById(id)
                .map(TopicDetailsResponseDTO::new)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id: " + id));
    }

    @Transactional
    public TopicResponseDTO updateTopic(Long id, TopicUpdateDTO updateDTO) {

        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id " + id));

        var author = userService.getAuthenticatedUser();

        if(!topic.getAuthor().equals(author)){
            throw new AccessDeniedException("You do not have permission to update this topic");
        }

        topic.attInfo(updateDTO);
        return new TopicResponseDTO(topic);
    }



    @Transactional
    public void deleteTopic(Long id) {

        var topic = topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id " + id));

        var author = userService.getAuthenticatedUser();

        if(!topic.getAuthor().equals(author)){
            throw new AccessDeniedException("You do not have permission to delete this topic");
        }
        topicRepository.delete(topic);
    }
}
