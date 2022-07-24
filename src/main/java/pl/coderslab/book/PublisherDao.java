package pl.coderslab.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.book.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Book> findAll() {
        return entityManager.createQuery("select p from Publisher p")
                .getResultList();
    }

    public void save(Publisher publisher) {
        entityManager.persist(publisher);
    }


    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }


    public void update(Publisher publisher) {
        entityManager.merge(publisher);
    }

    public void delete(Publisher publisher) {
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }
}
