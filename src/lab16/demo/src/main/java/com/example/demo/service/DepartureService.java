package com.example.demo.service;

import com.example.demo.model.DTO.DepartureDTO;
import com.example.demo.model.Departure;
import com.example.demo.model.PostOffice;
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

    public boolean addDeparture(DepartureDTO departureDTO) {
        PostOffice postOffice = session.createQuery("select u from PostOffice u where u.id = :id", PostOffice.class).setParameter("id", departureDTO.getPostOfficeId()).getSingleResult();
        if (postOffice == null){
            return false;
        }
        Departure departure = new Departure(departureDTO.getType(), departureDTO.getDepartureDate(), postOffice);
        var transaction = session.beginTransaction();
        if (session.createQuery("select u from Departure u where u.type = \""+departure.getType()+"\"", Departure.class).getResultList().isEmpty()){
            session.persist(departure);
            transaction.commit();
            return true;
        }else{
            transaction.commit();
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
