package by.andrey.twikssi.exer2simpledatabase.service;

import by.andrey.twikssi.exer2simpledatabase.bean.Book;
import by.andrey.twikssi.exer2simpledatabase.exceptions.ItemNotFoundException;
import by.andrey.twikssi.exer2simpledatabase.interfaces.Repository;

import java.util.List;
import java.util.Map;

public class BookRepository implements Repository<Book> {
    private Map<String, Book> repositoryBooks;

    public BookRepository(Map<String, Book> repositoryBooks) {
        this.repositoryBooks = repositoryBooks;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(String id) throws ItemNotFoundException {
        for (Map.Entry<String, Book> book: repositoryBooks.entrySet()){
            if (book.getValue().getId().equalsIgnoreCase(id)){
                return book.getValue();
            }
        }
        throw new ItemNotFoundException();
    }

    @Override
    public void save(Book item) {
        repositoryBooks.put(item.toString(),item);
    }

    @Override
    public void delete(String id) throws ItemNotFoundException {
        for (Map.Entry<String, Book> book: repositoryBooks.entrySet()){
            if (book.getValue().getId().equalsIgnoreCase(id)){
                repositoryBooks.remove(book.getKey(),book.getValue());
                return;
            }
        }
        throw new ItemNotFoundException();
    }
}
