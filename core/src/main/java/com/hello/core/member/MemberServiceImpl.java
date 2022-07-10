package com.hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{
    //인터페이스만 있으면 null포인터 익셉션이 발생한다, 그래서 구현객체를 선택을 해줘야한다.

    private final MemberRepository memberRepository;
    //여기서 이제 생성자를 통해서 저 인터페이스에 구현체가 뭐가 들어갈지를 생성자를 통해서 알게된다->생성자 주입
    @Autowired // 의존관계주입을 생성자에 붙혀주면 자동으로 주입해준다 // 타입으로 찾아준다
    //중요! 생성자가 1개있으면 @AutoWired가 안붙여도 자동으로 주입이 된다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //@Autowired 는 타입 매칭을 시도하고, 이때 여러 빈이 있으면 필드 이름, 파라미터 이름으로 빈 이름을 추가
    //매칭한다

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
