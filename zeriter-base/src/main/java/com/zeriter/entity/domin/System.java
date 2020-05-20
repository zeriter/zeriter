package com.zeriter.entity.domin;

import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="System对象", description="")
public class System implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一主见")
    @TableId("STSTEM_ID")
    private String ststemId;

    @ApiModelProperty(value = "系统名称")
    @TableField("SYETEM_NAME")
    private String syetemName;

    @ApiModelProperty(value = "系统前缀")
    @TableField("SYSTEM_PREFIX")
    private String systemPrefix;


}
