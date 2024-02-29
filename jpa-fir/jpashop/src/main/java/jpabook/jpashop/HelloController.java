package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    //hello라는 url로 오면 이 컨트롤러가 호출됨
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //키, 값
        return "hello"; //화면 이름(hello 뒤에 .html이 자동으로 붙음)
    }
}
