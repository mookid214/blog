package com.sparta.blog.controller;

import com.sparta.blog.domain.Blog;
import com.sparta.blog.domain.BlogRepository;
import com.sparta.blog.domain.BlogRequestDto;
import com.sparta.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class BlogController {

    private final BlogRepository blogRepository;
    private final BlogService blogService;

    @GetMapping("/api/blogs")
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @GetMapping("/api/blogs/{id}")
    public Optional<Blog> getBlogsId(@PathVariable Long id) {
        return blogRepository.findById(id);
    }

    @GetMapping("/api/blogs/desc")
    public List<Blog> getBlogsDesc() {
        return blogRepository.findAllByOrderByCreatedAtDesc();
    }





    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/blogs")
    public Blog createBlog(@RequestBody BlogRequestDto requestDto) {
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.
        // 저장하는 것은 Dto가 아니라 blog이니, Dto의 정보를 blog에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Blog blog = new Blog(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return blogRepository.save(blog);
    }

    @PutMapping("/api/blogs/{id}/{password}")
    public Long updateblog(@PathVariable Long id, @PathVariable String password , @RequestBody BlogRequestDto requestDto) {
        return blogService.update(id, password , requestDto);
    }

    @DeleteMapping("/api/blogs/{id}")
    public Long deleteBlog(@PathVariable Long id) {
        blogRepository.deleteById(id);
        return id;
    }

}