package tech.kddez.forumhub.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kddez.forumhub.domain.reply.ReplyRequestDTO;
import tech.kddez.forumhub.domain.reply.ReplyResponseDTO;
import tech.kddez.forumhub.service.ReplyService;

@RestController
@RequestMapping("/replies")
@SecurityRequirement(name = "bearer-key")
public class ReplyController {


    private final ReplyService service;


    public ReplyController(ReplyService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ReplyResponseDTO> createReply(@RequestBody @Valid ReplyRequestDTO request){
        var response = service.createReply(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<ReplyResponseDTO>> listReplies(Pageable pageable){
        return ResponseEntity.ok(service.listReplies(pageable));
    }
}
