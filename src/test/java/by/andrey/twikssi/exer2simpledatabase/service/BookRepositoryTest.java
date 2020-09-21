package by.andrey.twikssi.exer2simpledatabase.service;

import by.andrey.twikssi.exer2simpledatabase.bean.Book;
import by.andrey.twikssi.exer2simpledatabase.exceptions.ItemNotFoundException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BookRepositoryTest {
    BookRepository bookRepository;
    Map<String, Book> booksMap;

    @Before
    public void setup(){
        booksMap = new HashMap<>();

        booksMap.put("1", new Book("0","Mom wash", "Gena",456));
        booksMap.put("2", new Book("1","War and peace", "WaterMan",1056));
        booksMap.put("3", new Book("2","Fiesta", "Hemingway",400));
        booksMap.put("4", new Book("3","Doar is travelling", "Dora",300));
        booksMap.put("5", new Book("45","Under Water", "SpanchBob",556));

       bookRepository = new BookRepository(booksMap);
    }

    @Test
    public void findByIdReturnBook() throws ItemNotFoundException {
        Book underWater = new Book ("45","Under Water", "SpanchBob",556);

        assertEquals(true, underWater.equals(bookRepository.findById("45")));
    }

    @Test(expected = ItemNotFoundException.class)
    public void findByIdReturnException() throws ItemNotFoundException {
        bookRepository.findById("154");
    }

    @Test
    public void save() throws ItemNotFoundException {
        Book lifeIsShort = new Book("34","Life is short", "Remark", 390);
        bookRepository.save(lifeIsShort);

        assertEquals(lifeIsShort, bookRepository.findById("34"));
    }

    @Test(expected = ItemNotFoundException.class)
    public void deleteDone() throws ItemNotFoundException {
        bookRepository.delete("2");

        bookRepository.findById("2");
    }

    @Test(expected = ItemNotFoundException.class)
    public void deleteThrowsException() throws ItemNotFoundException {
        bookRepository.delete("2534534");
    }

    @Test
    public void findAll() {
        assertEquals(0,bookRepository.findAll().size());
    }
}