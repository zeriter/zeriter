package com.zeriter.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Group对象", description="")
public class Zgroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签唯一主键")
    private String groupId;

    @ApiModelProperty(value = "标签名称")
    private String groupName;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    private Integer count;

}
