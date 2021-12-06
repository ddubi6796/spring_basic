package hello.core.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository{

	//실무에서는 concurrentHashMap 사용 필수: Multi-Thread 환경에서 사용(특정 세그먼트/버킷에 대한 Lock을 사용; 동시성제어)
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
