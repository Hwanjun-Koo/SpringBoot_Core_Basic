package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); // 자기 자신을 내부에 private static으로 가지고 있음

    public static SingletonService getInstance() {
        return instance;
    } // 이 메서드를 통해서만 조회할 수 있음

    private SingletonService() {
    } // 외부(클래스)에서 new 키워드를 사용하지 못하도록 private으로 막아둠

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
