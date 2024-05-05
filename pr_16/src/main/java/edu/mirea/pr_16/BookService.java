package edu.mirea.pr_16;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterThrowing;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;

    public List<BookDto> getBooks() {
        session = sessionFactory.getCurrentSession();
        var transaction = session.beginTransaction();
        List<Book> books = session.createQuery("from Book").list();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            bookDtos.add(new BookDto(book.getId(), book.getName(), book.getCreationDate(), book.getAuthor()));
        }
        transaction.commit();
        session.close();
        return bookDtos;
    }
    public void deleteBookByName(String name) {
        session = sessionFactory.getCurrentSession();
        var transaction = session.beginTransaction();
        session.createQuery("delete from Book where name = :name").setParameter("name", name).list();
        transaction.commit();
        session.close();
    }
    public void addNewBook(Book book) {
        session = sessionFactory.getCurrentSession();
        var transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
    }
    public void addAuthorToBook(String bookName, String authorName) {
        session = sessionFactory.getCurrentSession();
        var transaction = session.beginTransaction();
        Book book = (Book) session.createQuery("from Book where name=:name").setParameter("name", bookName).getSingleResult();
        Author author = (Author) session.createQuery("from Author where name=:name").setParameter("name", authorName).getSingleResult();
        book.setAuthor(author);
        transaction.commit();
        session.close();
    }
}
