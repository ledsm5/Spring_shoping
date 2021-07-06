package service.member;

import org.springframework.beans.factory.annotation.Autowired;

import repository.MemberRepository;

public class MemberDeleteService {
	@Autowired
	MemberRepository memberRepository;
	public void memDelete(String memId) {
		memberRepository.memDelete(memId);
	}
}
