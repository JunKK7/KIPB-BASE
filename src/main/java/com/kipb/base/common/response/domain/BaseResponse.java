package com.kipb.base.common.response.domain;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;

@Data
public class BaseResponse<T>
{
    private final String resultCode = "S";
    private T data;

    /**
     * TODO Pagination 객체도 필요할 것인가?
     * 만약 JPA, Mybatis를 모두 사용한다고 했을 때 공용으로 필요한 Pagination 객체가 필요해 보인다.
     * 일단은 그냥 둔다.
     */

    public BaseResponse(T data)
    {
        if (ObjectUtils.isEmpty(data))
        {
            this.data = null;
        }
        else
        {
            this.data = data;
        }
    }
}
