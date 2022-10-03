package com.sparta.blog.service;

import com.sparta.blog.domain.Blog;
import com.sparta.blog.domain.BlogRepository;
import com.sparta.blog.domain.BlogRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    @Transactional
    public Long update(Long id, String password , BlogRequestDto requestDto) {

        Blog blog1 = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (!Objects.equals(blog1.getPassword(), password)) {
            System.out.println("패스워드가 일치하지 않습니다.");
            return null;
        }

        blog1.update(requestDto);
        return blog1.getId();
    }

}