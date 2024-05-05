package edu.mirea.pr_17;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

    public List<BookDto> getBooksAsc(String fieldToSort) {
        session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root).orderBy(builder.asc(root.get(fieldToSort)));
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        return query.getResultList().stream().map(x -> new BookDto(x.getId(), x.getName(), x.getCreationDate(), x.getAuthor())).toList();
    }
    public List<BookDto> getBooksDesc(String fieldToSort) {
        session = sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Book> bookCriteriaQuery = builder.createQuery(Book.class);
        Root<Book> root = bookCriteriaQuery.from(Book.class);
        bookCriteriaQuery.select(root).orderBy(builder.desc(root.get(fieldToSort)));
        Query<Book> query = session.createQuery(bookCriteriaQuery);
        return query.getResultList().stream().map(x -> new BookDto(x.getId(), x.getName(), x.getCreationDate(), x.getAuthor())).toList();
    }
}
