package com.intellij.terarosa.common;


import lombok.*;

@Data
@NoArgsConstructor
@ToString
public class ResponseEntity<T> {

    private boolean success;
    private String message;
    private T data;

    @Builder
    public ResponseEntity(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

}
