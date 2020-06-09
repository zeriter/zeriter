package com.zeriter.entity;

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
 * @since 2020-06-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论唯一主见")
    private String commentId;

    @ApiModelProperty(value = "评论者的姓名")
    private String commentName;

    @ApiModelProperty(value = "评论内容")
    @TableField("Comment_content")
    private String commentContent;

    @ApiModelProperty(value = "评论父级id，如果本身是父级为0")
    @TableField("parent_Comment_id")
    private String parentCommentId;

    @ApiModelProperty(value = "博客id")
    private String blogId;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createDate;

    @ApiModelProperty(value = "删除时间")
    private LocalDateTime deleteDate;

    @ApiModelProperty(value = "是否删除，0删除，1未删除")
    private String deleteSts;

    @ApiModelProperty(value = "是否是作者，0不是作者，1是作者")
    private String authorSts;

    @ApiModelProperty(value = "是否展示，0展示，1不展示")
    private String showSts;


}
