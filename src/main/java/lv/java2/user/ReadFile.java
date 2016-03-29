package lv.java2.user;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Viesturs on 28-Mar-16.
 */
public class ReadFile {

    public String readFile(String fileName) throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                output.append(line);

            }
        }
        return output.toString();
    }
}
