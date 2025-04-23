package app.services.impl;

import app.dto.request.InputDto;
import app.exceptions.InvalidDataException;
import app.services.FileService;
import app.utils.MaxHeap;
import app.utils.XlsxReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final XlsxReader xlsxReader;

    private final MaxHeap maxHeap;

    @Override
    public int getNumberFromFile(final InputDto dto) {
        if (dto.getNumber() <= 0) {
            throw new InvalidDataException("N должен быть положительным.");
        }

        List<Integer> numbers = xlsxReader.readNumbersFromFile(dto.getFilePath());

        if (numbers.size() < dto.getNumber()) {
            throw new InvalidDataException("Файл содержит меньше чисел, чем N.");
        }

        return maxHeap.getMinNum(numbers, dto.getNumber());
    }
}
