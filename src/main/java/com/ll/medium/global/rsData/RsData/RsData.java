package com.ll.medium.global.rsData.RsData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = PRIVATE)
public class RsData<T> {
    String resultCode;
    int statusCode;
    String msg;
    T data;

    public static <T> RsData<T> of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }

    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        int statusCode = Integer.parseInt(resultCode.split("-", 2)[0]);

        return new RsData<>(resultCode, statusCode, msg, null);
    }

    public boolean isFail() {
        return !isSuccess();
    }

    private boolean isSuccess() {
        return getStatusCode() >= 200 && getStatusCode() < 400;
    }
}
