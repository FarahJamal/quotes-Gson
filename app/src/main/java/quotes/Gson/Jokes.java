package quotes.Gson;

public class Jokes {
    String content;

    public Jokes(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Jokes{" +
                "content='" + content + '\'' +
                '}';
    }
}
