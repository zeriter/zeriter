package com.zeriter.entity.domin;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
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
 * @since 2020-05-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "user主键")
    @TableId("USER_ID")
    private String userId;

    @ApiModelProperty(value = "user姓名")
    @TableField("USER_NAME")
    private String userName;

    @ApiModelProperty(value = "user编号")
    @TableField("USER_CODE")
    private String userCode;

    @ApiModelProperty(value = "user密码")
    @TableField("PASSWORD")
    private String password;

    @ApiModelProperty(value = "user状态，0正常，1失效，2删除")
    @TableField("STATE")
    private String state;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATE_DATE")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_DATE")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "user电话")
    @TableField("USER_TEL")
    private String userTel;

    @ApiModelProperty(value = "user Email")
    @TableField("USER_MAIL")
    private String userMail;


}
