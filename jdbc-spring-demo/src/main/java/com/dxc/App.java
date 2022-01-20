package com.dxc;

import java.sql.SQLException;
import java.util.List;

import com.dxc.dao.BookDao;
import com.dxc.model.Book;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");

        ctx.refresh();
        Book animal=new Book("Animal","George","12345");
        Book dune=new Book("Dune","Herbert","123-45-89");
        Book theHobbit=new Book("Hobbit","Tolkein","12345");


    

        List<Book> books=List.of(animal,dune,theHobbit);

        BookDao bookDao = ctx.getBean("bookDao", BookDao.class);

        books.forEach(bk -> {
            try {
                bookDao.save(bk);
                
            } catch (SQLException e) {
            
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });

        

        try {
            bookDao.findAll().forEach(System.out::println);
        } catch (SQLException e) {
        
            e.printStackTrace();
        }


        ctx.registerShutdownHook();
    }
}
