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
@ApiModel(value="PrivMenu对象", description="")
public class PrivMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一主键")
    @TableId("PRIV_MENU_ID")
    private String privMenuId;

    @ApiModelProperty(value = "权限code")
    @TableField("PRIV_CODE")
    private String privCode;

    @ApiModelProperty(value = "菜单code")
    @TableField("MENU_CODE")
    private String menuCode;

    @ApiModelProperty(value = "状态，0正常，1失效，2删除")
    @TableField("STATUS")
    private String status;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATR_DATE")
    private LocalDateTime creatrDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_DATE")
    private LocalDateTime updateDate;

    @ApiModelProperty(value = "生效时间")
    @TableField("EFF_DATE")
    private LocalDateTime effDate;

    @ApiModelProperty(value = "失效时间")
    @TableField("EXP_DATE")
    private LocalDateTime expDate;


}
