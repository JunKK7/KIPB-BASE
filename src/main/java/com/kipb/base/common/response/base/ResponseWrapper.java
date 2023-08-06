package com.kipb.base.common.response.base;

import org.springframework.http.ResponseEntity;

public interface ResponseWrapper<T>
{
    ResponseEntity wrap(T data);
}
