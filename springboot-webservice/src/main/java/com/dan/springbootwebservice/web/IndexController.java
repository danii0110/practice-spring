package com.dan.springbootwebservice.web;

import com.dan.springbootwebservice.service.posts.PostsService;
import com.dan.springbootwebservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/") //앞의 경로 src/main/resources/templates로 설정(mustache 자동)
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }

    //"/posts/save"를 호출하면 posts-save.mustache를 호출하는 메서드
    //컨트롤러가 생성 되었다면 posts-save.mustache 파일을 생성
    //파일의 위치는 index.mustache와 같음
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
