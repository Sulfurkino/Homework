package config;
//хочу сделать очно, возникли вопросы, это по сути не решение

public class confMain {
    public static void main(String[] args) {
        String file = "file.txt";
        Config config = new Config();

        config.parseConfig(file);
    }
}
