package com.goit.module13;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public class TypicodeClient {
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";

    public List<TypicodeUser> findUsers() throws IOException {
        return performGet(USERS_URL, new TypeReference<>() {
        });
    }

    public TypicodeUser findUserById(Long id) throws IOException {
        return performGet(USERS_URL + "/" + id, new TypeReference<>() {
        });
    }

    public TypicodeUser findByComplited(Long id) throws IOException {
        return performGet(USERS_URL + "/" + id, new TypeReference<>() {
        });
    }

    public List<TypicodeUser> findUserByUserName(String userName) throws IOException {
        return performGet(USERS_URL + "?username=" + userName, new TypeReference<>() {
        });
    }


    public List<TypicodeUserTodo> findUserTodоsByUserId(Long userId) throws IOException {
        return performGet(USERS_URL + "/" + userId + "/todos?completed=false", new TypeReference<>() {
        });
    }



    public TypicodeUser createUser(TypicodeUser user) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ObjectMapper objectMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
            HttpPost request = new HttpPost(USERS_URL);
            String json = objectMapper.writeValueAsString(user);
            StringEntity requestEntity = new StringEntity(json);
            request.setEntity(requestEntity);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity);
                return objectMapper.readValue(body, new TypeReference<>() {
                });
            }
        }
    }

    public TypicodeUser updateUser(TypicodeUser user) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            ObjectMapper objectMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
            HttpPut request = new HttpPut(USERS_URL + "/" + user.getId());
            String json = objectMapper.writeValueAsString(user);
            StringEntity requestEntity = new StringEntity(json);
            request.setEntity(requestEntity);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity);
                return objectMapper.readValue(body, new TypeReference<>() {
                });
            }
        }
    }

    public TypicodeUser deleteUser(Long userId) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpDelete request = new HttpDelete(USERS_URL + "/" + userId);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println(response.getStatusLine());
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity);
                ObjectMapper objectMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
                return objectMapper.readValue(body, new TypeReference<>() {
                });
            }
        }
    }

    private <T> T performGet(String url, TypeReference<T> type) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                HttpEntity entity = response.getEntity();
                String body = EntityUtils.toString(entity);
                ObjectMapper objectMapper = new ObjectMapper().configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
                return objectMapper.readValue(body, type);
            }
        }
    }


}
