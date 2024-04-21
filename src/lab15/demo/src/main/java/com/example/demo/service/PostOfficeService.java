package com.example.demo.service;

import com.example.demo.model.PostOffice;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

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

    public boolean addPostOffice(PostOffice postOffice) {
        var transaction = session.beginTransaction();
        try {
            // Проверяем наличие почтового отделения с таким же именем в базе данных
            List<PostOffice> existingPostOffices = session.createQuery("select p from PostOffice p where p.name = :name", PostOffice.class)
                    .setParameter("name", postOffice.getName())
                    .getResultList();
            if (!existingPostOffices.isEmpty()) {
                transaction.rollback(); // Откатываем транзакцию, так как объект уже существует
                return false;
            }
            session.persist(postOffice); // Сохраняем новое почтовое отделение в базе данных
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
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
}
