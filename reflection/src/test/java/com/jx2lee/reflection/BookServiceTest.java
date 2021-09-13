package com.jx2lee.reflection;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    void 의존성_주입() {
        assertNotNull(bookService);
        System.out.println("bookService = " + bookService);

        assertNotNull(bookService.bookRepository);
        System.out.println("bookService.bookRepository = " + bookService.bookRepository);
    }
    
    @Test
    void 의존성_주입을_하지않은_경우() {
        BookService bookServiceNoDi = new BookService();
        
        assertNotNull(bookServiceNoDi);
        System.out.println("bookServiceNoDi = " + bookServiceNoDi);
        
        assertNull(bookServiceNoDi.bookRepository);
        System.out.println("bookServiceNoDi.bookRepository = " + bookServiceNoDi.bookRepository);
        
    }

}
