package kukim.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    void singletonBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletoneBean.class);

        SingletoneBean bean1 = ac.getBean(SingletoneBean.class);
        SingletoneBean bean2 = ac.getBean(SingletoneBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        assertThat(bean1).isEqualTo(bean2);

        ac.close();
    }


    @Scope("singleton")
    static class SingletoneBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletoneBean.init");
        }

        @PreDestroy
        public void destory() {
            System.out.println("SingletoneBean.destory");
        }
    }
}

