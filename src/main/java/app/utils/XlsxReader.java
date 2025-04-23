package app.utils;

import app.config.RowConfig;
import app.exceptions.InvalidDataException;
import app.exceptions.NoDataFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class XlsxReader {

    private final RowConfig rowConfig;

    public List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers = new ArrayList<>();

        String fullPath = rowConfig.basePath() + fileName;

        try (FileInputStream fis = new FileInputStream(fullPath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(Integer.parseInt(rowConfig.numColumn()));

            for (Row row : sheet) {
                Cell cell = row.getCell(Integer.parseInt(rowConfig.numRow()));
                if (cell != null && cell.getCellType() == CellType.NUMERIC) {
                    numbers.add((int) cell.getNumericCellValue());
                }
            }

        } catch (FileNotFoundException e) {
            throw new NoDataFoundException("Файл {} не найден.", fileName);
        } catch (EncryptedDocumentException e) {
            throw new InvalidDataException("Файл {} зашифрован и не может быть прочитан", fileName);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при чтении файла: " + fileName, e);
        }

        return numbers;
    }
}