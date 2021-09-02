package com.example.demo12.service;

import com.example.demo12.model.Users;

public interface IUserService {
    Users findByUsernameAndPassword(String username, String password);
}
