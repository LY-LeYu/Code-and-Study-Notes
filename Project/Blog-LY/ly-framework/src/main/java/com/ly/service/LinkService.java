package com.ly.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ly.domain.ResponseResult;
import com.ly.domain.entity.Link;
import com.ly.domain.vo.LinkVo;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2023-08-02 21:17:55
 */
public interface LinkService extends IService<Link> {

    ResponseResult getAllLink();

    ResponseResult getLinkPage(Integer pageNum, Integer pageSize, String linkName, String status);

    ResponseResult addLink(LinkVo linkVo);

    ResponseResult getLink(Long id);

    ResponseResult updateLink(LinkVo linkVo);

    ResponseResult deleteLink(Long linkId);
}

