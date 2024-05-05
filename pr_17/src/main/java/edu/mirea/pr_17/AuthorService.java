package edu.mirea.pr_17;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    public List<Author> getAuthorsAsc(String fieldToSort) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> authorCriteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = authorCriteriaQuery.from(Author.class);
        authorCriteriaQuery.select(root).orderBy(builder.asc(root.get(fieldToSort)));
        Query<Author> query = session.createQuery(authorCriteriaQuery);
        return query.getResultList();
    }
    public List<Author> getAuthorsDesc(String fieldToSort) {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Author> authorCriteriaQuery = builder.createQuery(Author.class);
        Root<Author> root = authorCriteriaQuery.from(Author.class);
        authorCriteriaQuery.select(root).orderBy(builder.desc(root.get(fieldToSort)));
        Query<Author> query = session.createQuery(authorCriteriaQuery);
        return query.getResultList();
    }
}
