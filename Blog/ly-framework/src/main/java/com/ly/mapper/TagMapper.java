package com.ly.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ly.domain.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;


/**
 * 标签(Tag)表数据库访问层
 *
 * @author makejava
 * @since 2023-08-08 13:25:52
 */
@Mapper
public interface TagMapper extends BaseMapper<Tag> {

}

