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
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "唯一主键")
    private String blogId;

    @ApiModelProperty(value = "博客标题")
    private String blogTitle;

    @ApiModelProperty(value = "博客正文")
    private String blogContent;

    @ApiModelProperty(value = "创建时间")
    private Date createDate;

    @ApiModelProperty(value = "更新时间")
    private Date updateDate;

    @ApiModelProperty(value = "1隐藏，0显示")
    private String showSts;

    @ApiModelProperty(value = "0正常，1删除")
    private String deleteSts;

    @ApiModelProperty(value = "标签id，多个标签则用；号隔开")
    private String tagId;

    @ApiModelProperty(value = "删除时间")
    private Date deleteDate;

    @ApiModelProperty(value = "点击量")
    private Integer click;

    @ApiModelProperty(value = "1原创，2转载，3翻译")
    private String blogType;

    @ApiModelProperty(value = "标签id，多个标签则用；号隔开")
    private String groupId;


}
