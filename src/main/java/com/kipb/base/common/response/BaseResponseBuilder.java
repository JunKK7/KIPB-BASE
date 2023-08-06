package com.kipb.base.common.response;

import com.kipb.base.common.response.base.ResponseBuilder;
import com.kipb.base.common.response.base.ResponseWrapper;
import com.kipb.base.common.response.domain.BaseResponse;
import java.net.http.HttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Slf4j
public class BaseResponseBuilder implements InitializingBean, ResponseBuilder
{
    private static ResponseWrapper wrapper = val -> new ResponseEntity(val, HttpStatus.OK);

    public static <T> ResponseEntity<BaseResponse> build(T data)
    {
        BaseResponse<T> response = new BaseResponse<>(data);
        return wrapper.wrap(response);
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        log.info("BASE RESPONSE BUILDER SET COMPLETE");
    }
}
