package com.ly.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ly.constant.SystemConstants;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Link;
import com.ly.domain.vo.LinkVo;
import com.ly.domain.vo.PageVo;
import com.ly.enums.AppHttpCodeEnum;
import com.ly.exception.SystemException;
import com.ly.mapper.LinkMapper;
import com.ly.service.LinkService;
import com.ly.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

/**
 * 友链(Link)表服务实现类
 *
 * @author makejava
 * @since 2023-08-02 21:17:55
 */
@Service("linkService")
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link> implements LinkService {

    @Override
    public ResponseResult getAllLink() {
        //查询所有审核通过的
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Link::getStatus, SystemConstants.LINK_STATUS_NORMAL);
        List<Link> links = list(queryWrapper);
        //转换成vo
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(links, LinkVo.class);
        //封装返回
        return ResponseResult.okResult(linkVos);
    }

    @Override
    public ResponseResult getLinkPage(Integer pageNum, Integer pageSize, String linkName, String status) {
        LambdaQueryWrapper<Link> queryWrapper = new LambdaQueryWrapper<>();
        //在判断tag的name和remark是否相等之前,要先判断name和remark是否有值
        queryWrapper.eq(StringUtils.hasText(linkName),Link::getName,linkName);
        queryWrapper.eq(StringUtils.hasText(status),Link::getStatus,status);
        //分页查询tag
        Page<Link> page = new Page();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page, queryWrapper);
        //封装数据返回
        List<LinkVo> linkVos = BeanCopyUtils.copyBeanList(page.getRecords(),LinkVo.class);
        PageVo pageVo = new PageVo(linkVos,page.getTotal());
        return ResponseResult.okResult(pageVo);
    }

    @Override
    public ResponseResult addLink(LinkVo linkVo) {
        //对标签名进行非空判断
        if(!(StringUtils.hasText(linkVo.getName()))){
            throw new SystemException(AppHttpCodeEnum.LINK_ERROR);
        }
        Link link = BeanCopyUtils.copyBean(linkVo, Link.class);
        save(link);
        return ResponseResult.okResult();
    }

    @Override
    public ResponseResult getLink(Long id) {
        Link link = getById(id);
        if(Objects.isNull(link)){
            throw new SystemException(AppHttpCodeEnum.LINK_ERROR);
        }
        LinkVo linkVo = BeanCopyUtils.copyBean(link, LinkVo.class);
        return ResponseResult.okResult(linkVo);
    }

    @Override
    public ResponseResult updateLink(LinkVo linkVo) {
        if (!StringUtils.hasText(linkVo.getName())) {
            throw new SystemException(AppHttpCodeEnum.LINK_ERROR);
        }
        Link link = BeanCopyUtils.copyBean(linkVo, Link.class);
        updateById(link);
        return ResponseResult.okResult();
    }

    @Autowired
    private LinkMapper linkMapper;
    @Override
    public ResponseResult deleteLink(Long linkId) {
        //判断id对应Link是否存在
        Link link = baseMapper.selectById(linkId);
        if(Objects.isNull(link) ){
            throw new SystemException(AppHttpCodeEnum.LINK_ERROR);
        }
        //根据id修改逻辑删除标识
        LambdaUpdateWrapper<Link> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(Link::getId, linkId);
        updateWrapper.set(Link::getDelFlag,1);
        linkMapper.update(null,updateWrapper);
        return ResponseResult.okResult();
    }
}
