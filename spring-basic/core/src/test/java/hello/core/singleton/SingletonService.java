package hello.core.singleton;

public class SingletonService {
    //자기 자신을 내부의 private으로 하나 가지고 있음.(static으로 가지고 있음)
    //이렇게 하면 클래스 레벨에 올라가기 때문에 딱 하나만 존재하게 됨

    private static final SingletonService instance = new SingletonService();

    //조회
    public static SingletonService getInstance() {
        return instance;
    }

    //다른 곳에서 객체 생성하는 것을 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 탈출");
    }
}
