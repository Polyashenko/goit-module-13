package com.goit.module13;

import java.io.IOException;
import java.util.List;

public class UserService {

    private TypicodeClient typicodeClient = new TypicodeClient();

    public void printOpenTasks(Long userId) throws IOException {
        List<TypicodeUserTodo> todos = typicodeClient.findUserTodоsByUserId(userId);
        System.out.println(todos);
    }

}

