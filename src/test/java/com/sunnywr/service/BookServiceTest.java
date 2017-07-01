package com.sunnywr.service;

import com.sunnywr.entity.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Test
    public void findOneTest() {
        Book book = bookService.findOne(3);
        Assert.assertEquals(new Float(15), (Float)book.getPrice());
    }
}
