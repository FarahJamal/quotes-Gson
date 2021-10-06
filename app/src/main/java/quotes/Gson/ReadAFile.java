package quotes.Gson;

import com.google.gson.Gson;


import java.io.*;

public class ReadAFile extends GsonClass {

    public void readFile(String fileName) throws FileNotFoundException {
        int random = (int)(Math.random() * readJson(fileName).length);
        Quotes result=readJson(fileName)[random];
        System.out.println(result);
    }

    public void readFile(String fileName,String author) throws FileNotFoundException {
   ;
        for(Quotes element: readJson(fileName)){
            if(element.author.contains(author)){
                System.out.println(element);
            }
                    }

    }
    public void offlineReadFile(String fileName) throws FileNotFoundException {

        int random = (int)(Math.random() * readJson(fileName).length);
        Jokes result=readJoke(fileName)[random];
        System.out.println(result);




    }    public void findQuote(String fileName,String quote) throws FileNotFoundException {


        for(Quotes element: readJson(fileName)){
            if(element.text.contains(quote)){
                System.out.println(element.text);
            }
        }
    }


}
