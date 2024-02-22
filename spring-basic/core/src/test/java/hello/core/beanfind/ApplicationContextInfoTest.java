package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//public 지워주기
class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //bean 정리된 이름을 등록
        for (String beanDefinitionName : beanDefinitionNames) { //for문 만드는 단축어 : iter
            Object bean = ac.getBean(beanDefinitionName); //Object인 이유 : type을 모르기 때문에
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }
    }


    //우리가 등록한 것들만 보기 위해서 추가해줌(이거 추가 안하면 기본적으로 있는 것들도 같이 출력됨)
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); //bean 정리된 이름을 등록
        for (String beanDefinitionName : beanDefinitionNames) { //for문 만드는 단축어 : iter
            //빈에 대한 정보들
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //application은 내가 뭔가 스프링의 내부에서 무엇인가를 하기 위해서 등록한 빈들이 아니라 내가 애플리케이션을 주로 개발하기 위해서 등록한 빈들
            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName); //Object인 이유 : type을 모르기 때문에
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
