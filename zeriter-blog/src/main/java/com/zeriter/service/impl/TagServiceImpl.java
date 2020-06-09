package com.zeriter.service.impl;

import com.zeriter.entity.Tag;
import com.zeriter.mapper.TagMapper;
import com.zeriter.service.ITagService;
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
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
