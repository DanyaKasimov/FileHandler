package app.controllers;

import app.api.FileApi;
import app.dto.request.InputDto;
import app.services.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RequiredArgsConstructor
@RestController
public class FileController implements FileApi {

    private final FileService fileService;

    @Override
    public Integer file(final InputDto dto) {
        log.info("Поступил запрос на получение {}-го числа из файла: {}", dto.getNumber(), dto.getFilePath());

        return fileService.getNumberFromFile(dto);
    }
}
