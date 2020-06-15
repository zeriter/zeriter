package com.zeriter.service.impl;

import com.zeriter.entity.Tag;
import com.zeriter.mapper.TagMapper;
import com.zeriter.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zeriter.util.Sequence;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

    @Resource
    private TagMapper tagMapper;
    @Override
    public void addTag(String tagName) {
        Tag tag = new Tag();
        tag.setTagId(Sequence.getTagSeq());
        tag.setTagName(tagName);
        tag.setCreateDate(new Date());
        tagMapper.insert(tag);
    }
}
