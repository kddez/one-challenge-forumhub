package tech.kddez.forumhub.domain.reply;

import java.time.LocalDateTime;
import java.util.List;

public record ReplyResponseDTO(Long replyId, String message, LocalDateTime createdAt) {

    public ReplyResponseDTO(Reply reply){
        this(reply.getReplyId(), reply.getMessage(), reply.getCreatedAt());
    }

    public static List<ReplyResponseDTO> toResponseList(List<Reply> replies){

        return replies.stream().map(ReplyResponseDTO::new).toList();
    }

}
