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
@ApiModel(value="Menu对象", description="")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId("MENU_ID")
    private String menuId;

    @ApiModelProperty(value = "菜单名称")
    @TableField("MENU_NAME")
    private String menuName;

    @ApiModelProperty(value = "菜单code")
    @TableField("MENU_CODE")
    private String menuCode;

    @ApiModelProperty(value = "菜单url")
    @TableField("MENU_URL")
    private String menuUrl;

    @ApiModelProperty(value = "父菜单id")
    @TableField("PARENT_ID")
    private String parentId;

    @ApiModelProperty(value = "菜单类型，1菜单，2请求")
    @TableField("TYPE")
    private String type;

    @ApiModelProperty(value = "菜单所属系统")
    @TableField("SYSTEM")
    private String system;

    @ApiModelProperty(value = "状态，0有效，1无效，2删除")
    @TableField("STATS")
    private String stats;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREAR_DATE")
    private LocalDateTime crearDate;

    @ApiModelProperty(value = "更新时间")
    @TableField("UPDATE_DATE")
    private LocalDateTime updateDate;


}
