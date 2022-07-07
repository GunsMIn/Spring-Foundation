package com.hello.core.member;

public class MemberServiceImpl implements MemberService{
    //인터페이스만 있으면 null포인터 익셉션이 발생한다, 그래서 구현객체를 선택을 해줘야한다.

    private final MemberRepository memberRepository;
    //여기서 이제 생성자를 통해서 저 인터페이스에 구현체가 뭐가 들어갈지를 생성자를 통해서 알게된다->생성자 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
