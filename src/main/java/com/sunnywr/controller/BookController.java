package com.sunnywr.controller;

import com.sunnywr.model.Result;
import com.sunnywr.repository.BookRepository;
import com.sunnywr.service.BookService;
import com.sunnywr.entity.Book;
import com.sunnywr.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    /**
     * 查询所有图书列表
     * @return
     */
    @GetMapping("/books")
    public List<Book> bookList() {
        logger.info("Calling bookList()...");
        return bookRepository.findAll();
    }

    /**
     * 添加一本图书
     * @return
     */
    @PostMapping("/books")
    public Result<Book> bookAdd(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            String errMsg = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.errorValidation(-1, errMsg);
        }
        return ResultUtil.successValidation(bookRepository.save(book));
    }

    /**
     * 查询一本图书
     * @param id
     * @return
     */
    @GetMapping("/book/{id}")
    public Book bookQuery(@PathVariable("id") Integer id) {
        return bookRepository.findOne(id);
    }

    /**
     * 通过名称查询一本图书
     * @param name
     * @return
     */
    @GetMapping("/book/name/{name}")
    public List<Book> bookQueryByName(@PathVariable("name") String name) {
//        return bookRepository.findByName(name);
        return bookRepository.findByNameContaining(name);

    }

    /**
     * 更新一本图书
     * @param id
     * @return
     */
    @PutMapping("/book/{id}")
    public Book bookUpdate(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("author") String author) {
        Book book = new Book();
        book.setId(id);
        book.setAuthor(author);
        book.setName(name);
        return bookRepository.save(book);
    }

    /**
     * 删除一本图书
     * @param id
     * @return
     */
    @DeleteMapping("/book/{id}")
    public void bookDelete(@PathVariable("id") Integer id) {
        bookRepository.delete(id);
    }

    /**
     * 数据库事务
     */
    @PostMapping("/books/two")
    public void bookInsertTwo() {
        bookService.insertTwo();
    }

    @GetMapping("books/getBookPrice/{id}")
    public void getBookPrice(@PathVariable("id") Integer id) throws Exception {
        bookService.getBookPrice(id);
    }
}
