package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository{

	//�ǹ������� concurrentHashMap ��� �ʼ�: Multi-Thread ȯ�濡�� ���(Ư�� ���׸�Ʈ/��Ŷ�� ���� Lock�� ���; ���ü�����)
	private static Map<Long, Member> store = new HashMap<>();
	
	@Override
	public void save(Member member) {
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		return store.get(memberId);
	}

}
