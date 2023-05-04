package com.goit.module13;

import java.io.IOException;

public class HttpDemo {
    public static void main(String[] args) throws IOException {
        TypicodeClient typicodeClient = new TypicodeClient();
        System.out.println("Users:");
       // System.out.println(typicodeClient.findUsers());
        // System.out.println(typicodeClient.findUserById(2));
        //System.out.println(typicodeClient.findUserByUserName("Antonette"));
        HttpDemo httpDemo = new HttpDemo();
        //System.out.println(typicodeClient.createUser(httpDemo.createNewUser()));
        //System.out.println(typicodeClient.updateUser(httpDemo.createUserWithId()));
        //System.out.println(typicodeClient.deleteUser(1L));
        new UserService().printOpenTasks(1L);
    }

    private TypicodeUser createUserWithId() {
        TypicodeUser result = createNewUser();
        result.setId(1L);
        return result;
    }

    private TypicodeUser createNewUser() {
        TypicodeUser newUser = new TypicodeUser();
        newUser.setName("Dmitry");
        newUser.setUsername("Poliashenko");
        newUser.setAddress(createNewUserAddress());
        newUser.setPhone("0964096565");
        newUser.setWebsite("Poliashenko.net");
        newUser.setCompany(createNewUserCompnany());
        return newUser;
    }

    private TypicodeUserAddress createNewUserAddress() {
        TypicodeUserAddress result = new TypicodeUserAddress();
        result.setGeo(createNewUserAddressGeo());
        return result;
    }

    private TypicodeUserAddressGeo createNewUserAddressGeo() {
        TypicodeUserAddressGeo result = new TypicodeUserAddressGeo();
        result.setLat("-43.9509");
        result.setLng("53.9343");

        return result;
    }

    private TypicodeUserCompany createNewUserCompnany() {
        TypicodeUserCompany result = new TypicodeUserCompany();
        return result;
    }

    private TypicodeUserTodo createUserTodos () {
        TypicodeUserTodo result =  new TypicodeUserTodo();
        return result;
    }

}
