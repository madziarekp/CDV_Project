package pl.gov.nauka.radon.setup;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.WebDriver;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;
import org.testng.annotations.Test;

public class CSVReaderFile {
    WebDriver driver;

    String CSV_PATH="./Mappe1.csv";

    @Test
    public List<String[]> csvReadData() throws IOException, CsvValidationException {

        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String[] line;

        List<String[]> list = new ArrayList<>();

        while((line = reader.readNext()) !=  null) {
            list.add(line);
        }

        reader.close();
        return list;
    }

    @CsvBindByPosition(position = 0)
    private String email;

    @CsvBindByPosition(position = 1)
    private String password;
}