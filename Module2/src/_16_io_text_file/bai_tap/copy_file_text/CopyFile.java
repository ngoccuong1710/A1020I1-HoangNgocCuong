package _16_io_text_file.bai_tap.copy_file_text;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src/_16_io_text_file/bai_tap/copy_file_text/file_1.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                FileWriter fileWriter = new FileWriter("src/_16_io_text_file/bai_tap/copy_file_text/file_2.csv");
                fileWriter.write(line);
                fileWriter.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
