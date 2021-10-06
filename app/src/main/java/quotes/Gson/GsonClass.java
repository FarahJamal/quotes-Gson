package quotes.Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public abstract class GsonClass {
     Quotes[] readJson(String fileName) throws FileNotFoundException {
          Gson gson=new Gson();
          File file =new File(fileName);
          FileReader fileReader=new FileReader(file);
          Quotes[] fileString=gson.fromJson(fileReader,Quotes[].class);
          return fileString;
     }
     Jokes[] readJoke(String fileName) throws FileNotFoundException {
          Gson gson=new Gson();
          File file =new File(fileName);
          FileReader fileReader=new FileReader(file);
          Jokes[] fileString=gson.fromJson(fileReader,Jokes[].class);
          return fileString;
     }
}



