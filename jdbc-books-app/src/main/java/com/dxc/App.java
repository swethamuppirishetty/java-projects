package com.dxc;

import java.sql.SQLException;
import java.util.List;



import com.dxc.dao.BookDao;
import com.dxc.model.Book;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Book animal=new Book("Animal","George","12345");
        Book dune=new Book("Dune","Herbert","123-45-89");
        Book theHobbit=new Book("Hobbit","Tolkein","12345");


        BookDao bookDao=new BookDao();

        List<Book> books=List.of(animal,dune,theHobbit);
        books.forEach(bk -> {
            try {
                bookDao.save(bk);
                
            } catch (SQLException e) {
                //TODO: handle exception
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });

    }
}
