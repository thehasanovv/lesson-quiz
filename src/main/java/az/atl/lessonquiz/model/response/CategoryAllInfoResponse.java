package az.atl.lessonquiz.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAllInfoResponse {
    private Long id;
    private String name;
    private List<ProductResponse> products;
}
