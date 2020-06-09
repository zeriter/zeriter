package com.zeriter.reqAndResp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="统一返回对象", description="统一返回对象")
public class Result<T> {
    @ApiModelProperty(value = "返回代码")
    private Integer code;
    @ApiModelProperty(value = "返回信息")
    private String message;
    @ApiModelProperty(value = "返回内容")
    private T data;
    public Result(Integer code,String message){
        this(code,message,null);
    }
}

