package m2_demo.company.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFileCOM {
    public static void writeListStringToCSV(String filePath, List<String> list, boolean append) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(file,append);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (String line : list){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        fileWriter.close();
    }

    public static List<String> readFileCSV(String filePath) throws IOException {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line= bufferedReader.readLine())!=null){
            stringList.add(line);
        }
        bufferedReader.close();
        fileReader.close();
        return stringList;
    }
}
