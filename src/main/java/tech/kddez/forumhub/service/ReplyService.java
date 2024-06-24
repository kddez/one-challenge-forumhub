package tech.kddez.forumhub.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.kddez.forumhub.domain.reply.Reply;
import tech.kddez.forumhub.repository.ReplyRepository;
import tech.kddez.forumhub.domain.reply.ReplyRequestDTO;
import tech.kddez.forumhub.domain.reply.ReplyResponseDTO;
import tech.kddez.forumhub.repository.TopicRepository;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final TopicRepository topicRepository;


    public ReplyService(ReplyRepository replyRepository, TopicRepository topicRepository) {
        this.replyRepository = replyRepository;
        this.topicRepository = topicRepository;
    }

    @Transactional
    public ReplyResponseDTO createReply(ReplyRequestDTO request){

        var topic = topicRepository.findById(request.topicId())
                .orElseThrow(() -> new EntityNotFoundException("Topic not found with id: " + request.topicId()));

        var newReply = new Reply(request.message(), topic);
        replyRepository.save(newReply);
        return new ReplyResponseDTO(newReply);
    }


    public Page<ReplyResponseDTO> listReplies(Pageable pageable) {
        return replyRepository.findAll(pageable).map(ReplyResponseDTO::new);
    }
}
