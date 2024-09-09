package az.atl.lessonquiz.model.request;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCategoryRequest {
    @Size(min = 3, max = 255, message = "Please enter a name between 3 and 255.")
    private String name;
}
