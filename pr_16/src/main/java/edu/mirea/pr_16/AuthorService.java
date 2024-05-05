package edu.mirea.pr_16;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    private void init(){
        session = sessionFactory.openSession();
    }
    public List<Author> getAuthors() {
        return session.createQuery("from Author").list();
    }
    public void addAuthor(Author author) {
        session.beginTransaction();
        session.persist(author);
        session.getTransaction().commit();
    }
    public void deleteAuthorByName(String name) {
        session.beginTransaction();
        session.createQuery("delete from Author where name = :name").setParameter("name", name).executeUpdate();
        session.getTransaction().commit();
    }
}
