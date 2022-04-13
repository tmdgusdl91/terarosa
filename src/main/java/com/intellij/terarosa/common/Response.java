package com.intellij.terarosa.common;


import lombok.*;

@Setter
@NoArgsConstructor
@ToString
public class Response<T> {

    private boolean success;
    private String message;
    private T data;

    @Builder
    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

}
