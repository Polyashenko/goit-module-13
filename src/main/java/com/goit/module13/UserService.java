package com.goit.module13;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class UserService {

    private TypicodeClient typicodeClient = new TypicodeClient();

    public void printOpenTasks(Long userId) throws IOException {
        List<TypicodeUserTodo> todos = typicodeClient.findUserTodоsByUserId(userId);
        System.out.println(todos);
    }

    public void writeFileLastComments(Long userId) throws IOException {
        List<TopycodeUserPost> posts = typicodeClient.findUserPostsByUserId(userId);
        System.out.println(posts);
        TopycodeUserPost lastPost = posts.stream()
                .max(Comparator.comparing(TopycodeUserPost::getId))
                .orElseThrow(NoSuchElementException::new);
        System.out.println(lastPost);
        List<TopycodeUserPostComments> comments = typicodeClient.findUserPostsByUserIdComments(lastPost.getId());
        System.out.println(comments);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("user-" + userId + "-post-" + lastPost.getId() + "-comments.json"), comments);
    }
}

