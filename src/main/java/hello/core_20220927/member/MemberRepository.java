package hello.core_20220927.member;

public interface MemberRepository {
    
    void save(Member member);
    
    Member findById(Long memberId);
}
