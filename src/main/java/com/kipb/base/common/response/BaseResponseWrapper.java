package com.kipb.base.common.response;

import com.kipb.base.common.response.base.ResponseWrapper;
import com.kipb.base.common.response.domain.BaseResponse;
import org.springframework.http.ResponseEntity;

public class BaseResponseWrapper implements ResponseWrapper<BaseResponse>
{
    @Override
    public ResponseEntity wrap(BaseResponse data)
    {
        return null;
    }
}
