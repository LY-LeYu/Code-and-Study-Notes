package com.atguigu.spring.service;

import com.atguigu.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional //通过注解进行事务管理，本质上就是aop中的环绕标记，在类上标记，对类中所有方法生效
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Transactional //通过注解进行事务管理，本质上就是aop中的环绕标记
//    @Transactional(readOnly = true)
    @Override
    public void buyBook(Integer bookId, Integer userId) {
        //查询图书的价格
        Integer price = bookDao.getPriceByBookId(bookId);
        //更新图书的库存
        bookDao.updateStock(bookId);
        //更新用户的余额
        bookDao.updateBalance(userId, price);
    }
}
