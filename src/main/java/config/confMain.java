package config;
//хочу сделать очно, возникли вопросы, это по сути не решение

public class confMain {
    public static void main(String[] args) {
        String s = "Hello";
        s.toUpperCase();
        System.out.println(s);
        String file = "file.txt";
        Config config = new Config();

        config.parseConfig(file);
    }

}
