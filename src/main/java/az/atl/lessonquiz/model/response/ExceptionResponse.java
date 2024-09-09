package az.atl.lessonquiz.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {
    private String message;
    private Integer statusCode;
    private String error;
    private Map<String, String> errors;
    private LocalDateTime timestamp;
}
