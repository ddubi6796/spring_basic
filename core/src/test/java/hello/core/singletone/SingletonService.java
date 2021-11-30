package hello.core.singletone;

public class SingletonService {
	private static final SingletonService instance = new SingletonService();
	
	//static ������ ��ü�� �� 1���� ����
	public static SingletonService getInstance() {
		return instance;
	}

	//�����ڸ� private���� �����Ͽ� �ܺο��� new Ű����� ��ü �ν��Ͻ� ���� �Ұ�
	//���� 'getInstance() �޼��带 ���ؼ��� ��ȸ�� �� �ִ�.
	private SingletonService() {

	}
	
	public void login() {
		System.out.println("�̱��� ��ü ���� ȣ��");
	}
}
