package hello.core.singletone;

public class SingletonService {
	private static final SingletonService instance = new SingletonService();
	
	//static 영역에 객체를 딱 1개만 생성
	public static SingletonService getInstance() {
		return instance;
	}

	//생성자를 private으로 선언하여 외부에서 new 키워드로 객체 인스턴스 생성 불가
	//오직 'getInstance() 메서드를 통해서만 조회할 수 있다.
	private SingletonService() {

	}
	
	public void login() {
		System.out.println("싱글톤 객체 로직 호출");
	}
}
