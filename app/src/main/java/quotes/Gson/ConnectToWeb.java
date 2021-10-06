package quotes.Gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ConnectToWeb {
     public void randomQuoteAPI(String apiUrl) throws FileNotFoundException {
         try {
             URL url = new URL(apiUrl);
             System.out.println(getContentFromURL(url));
         } catch (MalformedURLException e) {
             e.printStackTrace();

         }
     }


    public static String getContentFromURL (URL url){
        HttpURLConnection connection = null;
        String content = null;
        String result=null;
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            int status = connection.getResponseCode();
            if(status == 200){
                BufferedReader bufferedReader = getBufferedReader(connection);
                content = getContentFromBufferedReader(bufferedReader);
                JsonObject jobj = new Gson().fromJson(content, JsonObject.class);
                 result ="The joke of the day is :"+ jobj.get("value");
                saveToFile("{\"content\""+':'+jobj.get("value").toString()+"}");
                bufferedReader.close();
            } else{
                System.out.println("An error occurred with status "+status+"generate offline jokes system!");
                ReadAFile read=new ReadAFile();
                read.offlineReadFile("./app/src/main/resources/jokes.json");

                result="";

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }

        return result ;

    }
    private static void saveToFile(String joke) {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        System.out.println(gson.toJson(joke));
        boolean exist=false;
        byte b;
        try {
            File myObj = new File("./app/src/main/resources/jokes.json");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
                exist=true;
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("./app/src/main/resources/jokes.json",true);
            if(exist ==true) {

                myWriter.write(',');

                myWriter.write(joke);

                myWriter.write(System.getProperty("line.separator"));
                RandomAccessFile f = new RandomAccessFile("./app/src/main/resources/jokes.json", "rw");
                long length = f.length() - 1;
                do {
                    length -= 1;
                    f.seek(length);
                     b = f.readByte();
                } while(b != 10);
                f.setLength(length+1);
                f.close();
                myWriter.write(']');
                myWriter.close();
            }
            else{
                myWriter.write('[');
                myWriter.write(joke);
                myWriter.write(System.getProperty("line.separator"));
                myWriter.write(']');
                myWriter.close();
            }
            System.out.println("Successfully create the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    private static BufferedReader getBufferedReader(HttpURLConnection connection) throws IOException {
        InputStream inputStream = connection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader;
    }

    // getContent from BufferedReader
    // return a string
    private static String getContentFromBufferedReader(BufferedReader bufferedReader){
        StringBuilder builder = new StringBuilder();
        String line = null;
        try {
            line = bufferedReader.readLine();
            while(line != null){
                builder.append(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  builder.toString();
    }
}
