package org.example.booksocialnetwork.api.feedback;

import lombok.*;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackResponse {
    private Double note;
    private String comment;
    private boolean ownFeedback;
}
