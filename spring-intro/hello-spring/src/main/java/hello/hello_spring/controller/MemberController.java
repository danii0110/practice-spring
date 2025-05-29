package hello.hello_spring.controller;

import org.springframework.ui.Model;
import hello.hello_spring.domain.Member;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberSvc;

    @Autowired
    public MemberController(MemberService memberSvc) {
        this.memberSvc = memberSvc;
        System.out.println("memberSvc = " + memberSvc.getClass());
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberSvc.join(member);

        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberSvc.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}