package com.example.demo.service;

import com.example.demo.model.DTO.PostOfficeDTO;
import com.example.demo.model.PostOffice;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostOfficeService {
    private final SessionFactory sessionFactory;
    private Session session;

    public PostOfficeService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public boolean addPostOffice(PostOfficeDTO postOfficeDTO) {
        PostOffice postOffice = new PostOffice(postOfficeDTO.getName(), postOfficeDTO.getCityName());
        var transaction = session.beginTransaction();
        if (session.createQuery("select u from PostOffice u where u.name = \""+postOffice.getName()+"\"", PostOffice.class).getResultList().isEmpty()){
            session.persist(postOffice);
            transaction.commit();
            return true;
        } else{
            transaction.commit();
            return false;
        }
    }

    public boolean deletePostOffice(String name) {
        var transaction = session.beginTransaction();
        try {
            // Получаем почтовое отделение по имени
            List<PostOffice> postOffices = session.createQuery("select p from PostOffice p where p.name = :name", PostOffice.class)
                    .setParameter("name", name)
                    .getResultList();
            if (postOffices.isEmpty()) {
                transaction.commit();
                return false; // Почтовое отделение с таким именем не найдено
            }
            session.remove(postOffices.get(0)); // Удаляем почтовое отделение
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public List<PostOffice> getPostOffices() {
        return session.createQuery("select p from PostOffice p", PostOffice.class).getResultList();
    }

    public List<PostOffice> getPostOfficeByName(String name) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> criteriaQuery = criteriaBuilder.createQuery(PostOffice.class);
        Root<PostOffice> root = criteriaQuery.from(PostOffice.class);

        Predicate predicate = criteriaBuilder.equal(root.get("name"), name);
        criteriaQuery.where(predicate);

        return session.createQuery(criteriaQuery).getResultList();
    }

    public List<PostOffice> getPostOfficeByCityName(String cityName) {
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<PostOffice> criteriaQuery = criteriaBuilder.createQuery(PostOffice.class);
        Root<PostOffice> root = criteriaQuery.from(PostOffice.class);

        Predicate predicate = criteriaBuilder.equal(root.get("cityName"), cityName);
        criteriaQuery.where(predicate);

        return session.createQuery(criteriaQuery).getResultList();
    }
}
