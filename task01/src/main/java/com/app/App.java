package com.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException {

        List<List<String>> dataSourceArray = new ArrayList<>();
        List<List<String>> templateArray = new ArrayList<>();
        String dataSourcePath = args[0];
        String templatePath = args[1];

        // "//Users//tengchoonhong//Desktop//thankyou.csv"
        // "//Users//tengchoonhong//Desktop//thankyou.txt"

        try (Scanner scanner = new Scanner(new File(dataSourcePath));) {
            while (scanner.hasNextLine()) {
            dataSourceArray.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        try (Scanner scanner = new Scanner(new File(templatePath));) {
            while (scanner.hasNextLine()) {
            templateArray.add(getRecordFromLine(scanner.nextLine()));
            }
        }

        for(int i=1; i<dataSourceArray.size(); i++) {
            List<String> dataList = new ArrayList<>();

            dataList = dataSourceArray.get(i);

            templateArray.get(0).set(0, dataList.get(2));
            templateArray.get(2).set(0, ("Dear " + dataList.get(0)));
            templateArray.get(4).set(0, ("Thank you for staying with us over these " + dataList.get(3) + " years."));
        
            System.out.println(dataList.get(0));

            String writePath = templatePath.replace("thankyou.txt", "//Users//tengchoonhong//Desktop");

            System.out.println(writePath);
            String name = dataList.get(0).toString();
            String fileName = name + ".txt";
            FileWriter file = new FileWriter(new File(writePath, fileName));
            BufferedWriter bf = new BufferedWriter(file);

            for(int j=0; j<templateArray.size(); j++) {
                String placeholder = templateArray.get(j).toString();

                System.out.println(placeholder);
                System.out.println(templateArray.get(j).toString());
                // bf.write(templateArray.get(j).toString());
            }

            // bf.close();
        }
      
    }

    public static List<String> getRecordFromLine(String line) {
        List<String> dataSourceArray = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                dataSourceArray
    .add(rowScanner.next());
            }
        }
        return dataSourceArray;
    }
}
