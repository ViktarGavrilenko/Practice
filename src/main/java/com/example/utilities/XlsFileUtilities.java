package com.example.utilities;

import com.example.exception.NotFoundCellDataException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class XlsFileUtilities {

    public static HSSFSheet getSheetFromXlsFile(String fileName, int index) throws IOException {
        InputStream inputStream;
        HSSFWorkbook workBook;

        inputStream = new FileInputStream(fileName);
        workBook = new HSSFWorkbook(inputStream);

        return workBook.getSheetAt(index);
    }

    public static int[] searchIndexCell(Sheet sheet, String valueCell) throws NotFoundCellDataException {
        int[] indexCell = new int[2];
        Iterator<Row> it = sheet.iterator();

        boolean isSearch = false;
        outerLoop:

        while (it.hasNext()) {
            Row rowName = it.next();
            for (Cell cellName : rowName) {
                if (cellName.getStringCellValue().equals(valueCell)) {
                    indexCell[0] = cellName.getRowIndex() + 1;
                    indexCell[1] = cellName.getColumnIndex();
                    isSearch = true;
                    break outerLoop;
                }
            }
        }

        if (!isSearch) {
            throw new NotFoundCellDataException();
        }

        return indexCell;
    }
}
