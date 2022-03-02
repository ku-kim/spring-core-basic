package kukim.core.member;

import kukim.core.AppConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    private MemberService memberService;

    @BeforeEach
    void init() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @AfterEach
    void clear() {
    }

    @Test
    void join() {
        Member member = new Member(1L, "kukim", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        assertThat(findMember).isEqualTo(member);

    }
}