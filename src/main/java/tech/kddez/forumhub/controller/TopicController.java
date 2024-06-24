package tech.kddez.forumhub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tech.kddez.forumhub.domain.topic.TopicDetailsResponseDTO;
import tech.kddez.forumhub.domain.topic.TopicRequestDTO;
import tech.kddez.forumhub.domain.topic.TopicResponseDTO;
import tech.kddez.forumhub.domain.topic.TopicUpdateDTO;
import tech.kddez.forumhub.service.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService service;

    public TopicController(TopicService service) {
        this.service = service;
    }

    @SecurityRequirement(name = "bearer-key")
    @PostMapping
    public ResponseEntity<TopicResponseDTO> createTopic(@RequestBody @Valid TopicRequestDTO request, UriComponentsBuilder uriBuilder){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createTopic(request));
    }

    @GetMapping
    public ResponseEntity<Page<TopicResponseDTO>> listTopics(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(service.listTopics(pageable));
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<TopicDetailsResponseDTO> getTopic(@PathVariable("topicId") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.getTopic(id));
    }

    @SecurityRequirement(name = "bearer-key")
    @PutMapping("/{topicId}")
    public ResponseEntity<TopicResponseDTO> updateTopic(@PathVariable("topicId") Long id, @RequestBody TopicUpdateDTO updateDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.updateTopic(id, updateDTO));
    }

    @SecurityRequirement(name = "bearer-key")
    @DeleteMapping("/{topicId}")
    public ResponseEntity<Void> deleteTopic(@PathVariable("topicId") Long id){
        service.deleteTopic(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
