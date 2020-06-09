package com.zeriter.service.impl;

import com.zeriter.entity.Comment;
import com.zeriter.mapper.CommentMapper;
import com.zeriter.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeriter Zhang
 * @since 2020-06-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
