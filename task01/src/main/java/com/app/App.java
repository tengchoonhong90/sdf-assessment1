package com.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException {
        // String csvFile = args[0];
        // String templateFile = args[1];
        List<List<String>> records = new ArrayList<>();
        List<List<String>> records2 = new ArrayList<>();


        try (Scanner scanner = new Scanner(new File("//Users//tengchoonhong//Desktop//thankyou.csv"));) {
            while (scanner.hasNextLine()) {
            records.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        try (Scanner scanner = new Scanner(new File("//Users//tengchoonhong//Desktop//thankyou.txt"));) {
            while (scanner.hasNextLine()) {
            records2.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        System.out.println(records);
        System.out.println(records2);
      
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> dataSource = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                dataSource.add(rowScanner.next());
            }
        }
        return dataSource;
    }
}
