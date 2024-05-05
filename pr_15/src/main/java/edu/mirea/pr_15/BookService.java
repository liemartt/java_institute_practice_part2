package edu.mirea.pr_15;


import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final SessionFactory sessionFactory;
    private Session session;

    public List<Book> getBooks() {
        session = sessionFactory.getCurrentSession();
        var transaction = session.beginTransaction();
        List<Book> books = session.createQuery("from Book").list();
        transaction.commit();
        session.close();
        return books;
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
}
