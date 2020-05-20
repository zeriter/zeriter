package com.zeriter.entity.domin;

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
@ApiModel(value="Privilege对象", description="")
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "权限唯一标识")
    @TableField("PRIV_CODE")
    private String privCode;

    @ApiModelProperty(value = "权限名称")
    @TableField("PRIV_NAME")
    private String privName;

    @ApiModelProperty(value = "权限状态，0正常，1无效，2删除")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREAR_DATE")
    private LocalDateTime crearDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_DATE")
    private LocalDateTime updateDate;


}
