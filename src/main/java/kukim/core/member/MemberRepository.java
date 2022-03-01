package kukim.core.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

    void clear();
}
