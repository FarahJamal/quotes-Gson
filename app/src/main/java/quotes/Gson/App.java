/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes.Gson;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        //String apiURL = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        //String apiURL="https://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote";
String apiURL="https://api.chucknorris.io/jokes/rando";
//        ReadAFile read=new ReadAFile();
//        read.readFile("./app/src/main/resources/recentquotes.json");
//
//        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter author name");
//        read.readFile("./app/src/main/resources/recentquotes.json",myObj.nextLine());
//
//        Scanner myObj2 = new Scanner(System.in);  // Create a Scanner object
//        System.out.println("Enter quote or a word from quote");
//        read.findQuote("./app/src/main/resources/recentquotes.json",myObj2.nextLine());

        Scanner in=new Scanner(System.in);
        System.out.println("do you want online or off online quote");
        System.out.println("write (1 or f) for offline / (0 or n) for online ");
        int command=in.nextInt();
        boolean ok=false;
do {

    if (command == 1) {
        ReadAFile read = new ReadAFile();
        read.readFile("./app/src/main/resources/recentquotes.json");
        ok = true;
    } else if (command == 0) {
        ConnectToWeb connectToWeb = new ConnectToWeb();
        connectToWeb.randomQuoteAPI(apiURL);
        ok = true;

    } else {

        System.out.println("would you please enter valid command?");
        System.out.println("do you want online or off online quote");
        System.out.println("write (1 or f) for offline / (0 or n) for online ");
        command = in.nextInt();


    }
}
while (ok==false);


    }

}
