package thread;

class Singleton{
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }
}

public class Demo19 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
    }

}
