package model.service;

import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile{

    public static boolean save(String name) {
        String filePath = "src/model/in_out_files/prizesList.txt";
        try(FileWriter writer = new FileWriter(filePath, true))
        {
            writer.write(name);
            writer.flush();
        } catch(IOException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

}
