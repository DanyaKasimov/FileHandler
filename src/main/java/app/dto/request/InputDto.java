package app.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class InputDto {

    @NotBlank(message = "Обязательное поле: путь к файлу.")
    private String filePath;

    @Min(value = 1, message = "Число должно быть больше 0.")
    private Integer number;
}
