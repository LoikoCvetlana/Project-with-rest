//package com.sportoras.database.util;
//
//import com.sportoras.database.entity.*;
//import com.sportoras.database.entity.Review;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Component
//public class DatabaseHelper {
//
//    private final EntityManagerFactory entityManagerFactory;
//
//    @Autowired
//    public DatabaseHelper(EntityManagerFactory entityManagerFactory) {
//        this.entityManagerFactory = entityManagerFactory;
//    }
//
//    public void cleanDatabase() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("delete from Material").executeUpdate();
//        entityManager.createQuery("delete from Product").executeUpdate();
//        entityManager.createQuery("delete from Review").executeUpdate();
//        entityManager.createQuery("delete from UserDetail").executeUpdate();
//        entityManager.createQuery("delete from User").executeUpdate();
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//
//    public void prepareData() {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Material material1 = new Material("Ткань", "Описание ткани");
//        Material material2 = new Material("Ткань2", "Описание ткани2");
//        Material material3 = new Material("Ткань3", "Описание ткани3");
//
//        entityManager.persist(material1);
//        entityManager.persist(material2);
//        entityManager.persist(material3);
//
//        User rcop = new User("mail0", "222", FullName.of("Irina", "Nikolaevna"));
//        User gocor = new User("mail2", "111",  FullName.of("Ivan", "Nikiforovich"));
//        User iv = new User("mail", "password",  FullName.of("Irina", "Pshirkova"));
//
//        entityManager.persist(rcop);
//        entityManager.persist(gocor);
//        entityManager.persist(iv);
//
//
//        entityManager.persist(UserDetail.of("RCOP", "", "375 29555 55 55",
//                "Information1", rcop));
//
//        entityManager.persist(UserDetail.of("RCOP", "", "375 29555 55 55",
//                "Information1", rcop));
//        entityManager.persist(UserDetail.of("GOCOR", "Manager",
//                "375 555 333 55", "Information2", gocor));
//
//        entityManager.persist(new Review(rcop, "Cool", LocalDate.now()));
//        entityManager.persist(new Review(rcop, "Огонь!",  LocalDate.of(2016, 10, 02)));
//        entityManager.persist(new Review(rcop, "Boo", LocalDate.now()));
//
//
//
//        entityManager.persist(Product.of("Костюм спортивный парадный", "КР15",
//                "http://sportoras.com/wp-content/uploads/2015/01/kr15-624x936.jpg", BigDecimal.valueOf(108.00),material1));
//        entityManager.persist(Product.of("Игровая форма", "КР14",
//                "http://sportoras.com/wp-content/uploads/2015/01/kr14-624x936.jpg", BigDecimal.valueOf(60.00f), material2));
//        entityManager.persist(Product.of("Костюм спортивный парадный", "КР32",
//                "http://sportoras.com/wp-content/uploads/2017/10/kostjumy-10-red1-624x964.jpg", BigDecimal.valueOf(132.00f), material1));
//        entityManager.persist(Product.of("Костюм спортивный парадный", "КР35",
//                "http://sportoras.com/wp-content/uploads/2018/04/img_6475-7-1-small-624x882.jpg", BigDecimal.valueOf(150.00f),material3));
//
//
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
//}
