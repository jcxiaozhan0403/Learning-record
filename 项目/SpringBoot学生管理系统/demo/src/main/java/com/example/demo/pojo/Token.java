package com.example.demo.pojo;

public class Token {
    String token;

    public Token(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                '}';
    }
}
