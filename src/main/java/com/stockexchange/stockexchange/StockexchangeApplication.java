package com.stockexchange.stockexchange;

import com.stockexchange.stockexchange.model.ERole;
import com.stockexchange.stockexchange.model.Role;
import com.stockexchange.stockexchange.model.User;
import com.stockexchange.stockexchange.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class StockexchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockexchangeApplication.class, args);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Role role=new Role();
        role.setName(ERole.ROLE_ADMIN);
        role.setId(1);
        session.save(role);

        session.getTransaction().commit();
        session.close();

    }



}
