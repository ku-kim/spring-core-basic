package kukim.core.singleton;

import kukim.core.AppConfig;
import kukim.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        assertThat(memberService1).isNotEqualTo(memberService2);
    }

}