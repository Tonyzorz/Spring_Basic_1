package hello.core_20220927.scope;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

public class SingletonWithPrototypeTest1 {
    
    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        
        prototypeBean1.addCount();
        Assertions.assertThat(prototypeBean1.getCount()).isEqualTo(1);
        
        prototypeBean2.addCount();
        Assertions.assertThat(prototypeBean2.getCount()).isEqualTo(1);
        
        prototypeBean1.destory();
        prototypeBean2.destory();
    }
    
    @Test
    void singletonClientUsePrototype() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        int count1 = clientBean1.logic();
        Assertions.assertThat(count1).isEqualTo(1);

        ClientBean clientBean2 = ac.getBean(ClientBean.class);
        int count2 = clientBean2.logic();
        Assertions.assertThat(count2).isEqualTo(1);
    }
    
    @Scope("singleton")
//    @RequiredArgsConstructor
    static class ClientBean {
//        private final PrototypeBean prototypeBean;

        @Autowired
//        private ObjectProvider<PrototypeBean> prototypeBeanProvider; // 또는 ObjectFactory
        private Provider<PrototypeBean> prototypeBeanProvider; // 또는 ObjectFactory
        
/*        @Autowired
        ApplicationContext applicationContext;*/
        
/*        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }*/
        
        public int logic() {
//            PrototypeBean prototypeBean = applicationContext.getBean(PrototypeBean.class);
//            PrototypeBean prototypeBean = prototypeBeanProvider.getObject();
            PrototypeBean prototypeBean = prototypeBeanProvider.get();
            prototypeBean.addCount();
            return prototypeBean.getCount();
        }
    }
    
    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;
        
        public void addCount() {
            count++;
        }
        
        public int getCount() {
            return count;
        }
        
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init = " + this);
        }
        
        @PreDestroy
        public void destory() {
            System.out.println("PrototypeBean.destory");
        }
    }
}
