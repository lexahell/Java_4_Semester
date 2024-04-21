package com.example.demo.service;

import com.example.demo.model.Departure;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartureService {
    private final SessionFactory sessionFactory;
    private Session session;

    public DepartureService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public boolean addDeparture(Departure departure) {
        var transaction = session.beginTransaction();
        try {
            session.persist(departure);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean deleteDeparture(Long id) {
        var transaction = session.beginTransaction();
        try {
            Departure departure = session.get(Departure.class, id);
            if (departure == null) {
                transaction.commit();
                return false;
            }
            session.delete(departure);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public List<Departure> getDepartures() {
        return session.createQuery("select d from Departure d", Departure.class).getResultList();
    }
}
