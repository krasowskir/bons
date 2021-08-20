package com.example.bons;

import com.example.bons.entity.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionManager;

import javax.annotation.PostConstruct;

@Component
public class Start {

    @Autowired
    private HibernateTransactionManager transactionManager;

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(HibernateTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public Start() {
    }

    @PostConstruct
    public void start(){
//        SessionFactory sessionFactory = this.transactionManager.getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction firstTrans = session.beginTransaction();
//        Address berlinAddress = new Address(1,"richard", "krasowski", "Düsseldorfer Straße 59", "10707", "Berlin", "015140460849");
//        Address lidiaBerlAddress = new Address(2,"lidia", "krasowski", "Düsseldorfer Straße 59", "10707", "Berlin", "0171202555483");
//        session.save(berlinAddress);
//        session.save(lidiaBerlAddress);
////        firstTrans.commit();
////        session.getTransaction().commit();
//        session.flush();
//        session.close();
    }
}
