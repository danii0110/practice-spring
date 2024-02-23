package hello.core.scan.filter;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface MyExcludeComponent { //얘가 붙으면 componentscan에서 제외할 예정

}
