package com.kaishengit.service;
import com.kaishengit.pojo.Book;
import com.kaishengit.pojo.Publisher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.inject.Inject;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class BookServiceTestCase {
private Logger logger= (Logger) LoggerFactory.getLogger(BookServiceTestCase.class);
    @Inject
    private BookService bookService;
    @Test
    public void testSaveBook(){
        Book book =new Book();
        book.setBookname("JavaEE");
        book.setBookauthor("TOm");
        book.setBookprice(98.F);
        book.setBooknum(100);
        book.setTypeid(9);
        book.setPubid(2);
        bookService.saveBook(book);
    }
    @Test
    public void testDelBook(){
        bookService.delBook(36);
    }
    @Test
    public void testFindBookById(){
        Book book=bookService.findBookById(35);
        logger.debug("{}",book);
        Assert.assertNotNull(book);

    }
    @Test
    public void testUpdateBook(){
       Book book=bookService.findBookById(35);
        book.setBookname("JAVAEE");
        bookService.updateBook(book);
        logger.debug("{}",book);
    }
    @Test
    public void testFindAllBook(){
        List<Book> bookList=bookService.findAllBook();
        for (Book book:bookList) {
            System.out.println(book);

        }

    }
    @Test
    public void testFindAllPublisher(){
        List<Publisher> publisherList=bookService.findAllPublisher();
        for (Publisher publisher:publisherList){
            System.out.println(publisher);
        }

    }
}
