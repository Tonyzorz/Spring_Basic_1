package hello.core_20220927.member;

public interface MemberService {
    
    void join(Member member);
    
    Member findMember(Long memberId);
}
