package com.stockexchange.stockexchange.service;

import com.stockexchange.stockexchange.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface UserService {


    ResponseEntity<User> updateUser(Long id, User userDetails);

    ResponseEntity<Map<String, Boolean>> deleteUser(Long id);
}
