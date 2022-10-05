package com.sparta.blog;

import com.sparta.blog.domain.Blog;
import com.sparta.blog.domain.BlogRepository;
import com.sparta.blog.domain.BlogRequestDto;
import com.sparta.blog.service.BlogService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing

public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(BlogRepository blogRepository, BlogService blogService) {
        return (args) -> {
            blogRepository.save(new Blog("테스트 게시글", "작성자", "내용 테스트입니다.", "1234"));

            System.out.println("데이터 인쇄");
            List<Blog> blogList = blogRepository.findAll();
            for (int i = 0; i < blogList.size(); i++) {
                Blog blog = blogList.get(i);
                System.out.println(blog.getId());
                System.out.println(blog.getTitle());
                System.out.println(blog.getWriter());
                System.out.println(blog.getContent());
                System.out.println(blog.getPassword());

            }



        };

    }
}
