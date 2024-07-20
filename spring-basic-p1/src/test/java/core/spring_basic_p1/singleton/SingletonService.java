package core.spring_basic_p1.singleton;

public class SingletonService {
    //내부에 자기 자신을 private로 선언
    //static으로 선언해주어 class 레벨에 올라갔기 떄문에 딱 하나만 존재하게 된다
    private static final SingletonService instance = new SingletonService();

    //조회
    public static SingletonService getInstance() {
        return instance;
    }

    //private로 외부에서 선언하는 것을 막기
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
