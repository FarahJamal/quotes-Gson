/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes.Gson;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test public void quotesTest() throws FileNotFoundException {
        ReadAFile read=new ReadAFile();

        String testAuthor = "Marilyn Monroe";
        String testQuote = "I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.";
        String expected = String.format("Author: %s, Quote: %s", testAuthor, testQuote);
        assertEquals(expected,read.readJson("../app/src/test/resources/recentquotes.json"));

    }
}
