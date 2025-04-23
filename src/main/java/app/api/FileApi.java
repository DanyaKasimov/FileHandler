package app.api;

import app.dto.response.ApiErrorResponse;
import app.dto.request.InputDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("api/v1")
@Tag(name = "Обработка файла", description = "Методы для обработки файлов.")
public interface FileApi {

    @Operation(description = "Получение минимального N-го числа.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Число получено.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Integer.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Файл не валидный.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Файл не найден.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)
                    )
            ),
    })
    @PostMapping("/file")
    @ResponseStatus(HttpStatus.OK)
    Integer file(@RequestBody @Valid final InputDto dto);
}
