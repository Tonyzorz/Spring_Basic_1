package hello.core_20220927.singleton;

public class SingletoneService {

    private static final SingletoneService instance = new SingletoneService();

    public static SingletoneService getInstance() {
        return instance;
    }

    private SingletoneService() {

    }

    public void logic() {
        System.out.println("singleton instance logic called");
    }
}
