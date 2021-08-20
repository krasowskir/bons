package com.example.bons;

import com.example.bons.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@PostConstruct
//	public void start(){
//		log.info("starting createAddresses");
//		SessionFactory sessionFactory;
//
//		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//				.configure()
//				.build();
//		Session session = null;
//		try {
//			sessionFactory = new MetadataSources(registry)
//					.addResource("Address.hbm.xml")
//					.buildMetadata()
//					.buildSessionFactory();
////			sessionFactory = new Configuration()
////					.configure()
////					.buildSessionFactory();
//			session = sessionFactory.openSession();
//			Transaction firstTrans = session.beginTransaction();
//			Address berlinAddress = new Address("richard", "krasowski", "Düsseldorfer Straße 59", "10707", "Berlin", "015140460849");
//			Address lidiaBerlAddress = new Address("lidia", "krasowski", "Düsseldorfer Straße 59", "10707", "Berlin", "0171202555483");
//			session.save(berlinAddress);
//			session.save(lidiaBerlAddress);
//			firstTrans.commit();
//			session.flush();
//			session.close();
//			log.info("finish createAddresses");
//		} catch (Exception e){
//			StandardServiceRegistryBuilder.destroy( registry );
//		}
//	}


}
