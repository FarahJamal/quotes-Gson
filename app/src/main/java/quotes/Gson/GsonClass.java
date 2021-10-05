package quotes.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class GsonClass {
     Quotes[] readJson(String fileName) throws FileNotFoundException {
          com.google.gson.Gson gson=new com.google.gson.Gson();
          File file =new File(fileName);
          FileReader fileReader=new FileReader(file);
          Quotes[] fileString=gson.fromJson(fileReader,Quotes[].class);
          return fileString;
     }

}
