package _16_io_text_file.bai_tap.doc_file;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/_16_io_text_file/bai_tap/doc_file/file.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
