package az.atl.lessonquiz.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveProductRequest {

    @Size(min = 3, max = 255, message = "Please enter a name between 3 and 255.")
    private String name;

    @NotNull(message = "Please enter a price")
    private BigDecimal price;

    @NotNull(message = "Please enter a birthplace")
    private LocalDate birthday;

    @NotNull(message = "Please enter a in stock value")
    private BigDecimal inStock;

//    private boolean active;

//    private boolean deleted;

    private Long category;
}
