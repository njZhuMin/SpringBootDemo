package com.sunnywr.service;

import com.sunnywr.entity.Book;
import com.sunnywr.enums.ResultEnum;
import com.sunnywr.exception.BookException;
import com.sunnywr.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Transactional 
    public void insertTwo() {
        Book book1 = new Book();
        book1.setAuthor("transaction");
        book1.setName("事务管理1");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setAuthor("transaction");
        book2.setName("事务管理2");
        bookRepository.save(book2);
    }

    public void getBookPrice(Integer id) throws Exception {
        Book book = bookRepository.findOne(id);
        Float price = book.getPrice();
        if(price <= 20) {
            throw new BookException(ResultEnum.RANGE_0_20);
        } else if(price > 20 && price <= 30) {
            throw new BookException(ResultEnum.RANGE_20_30);
        }
    }

    /**
     * 测试方法：通过id查询图书信息
     * @param id
     * @return
     */
    public Book findOne(Integer id) {
        return bookRepository.findOne(id);
    }
}
