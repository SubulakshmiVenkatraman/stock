
package com.cts;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.entity.Company;
import com.cts.entity.IPOsPlanned;
import com.cts.entity.Sector;
import com.cts.entity.StockExchange;
import com.cts.entity.StockValue;
import com.fasterxml.classmate.AnnotationConfiguration;

@SpringBootApplication
public class SpringbootJpa12Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpa12Application.class, args);
		Configuration config = new Configuration();
		config.addAnnotatedClass(Company.class);
		config.addAnnotatedClass(IPOsPlanned.class);
		config.addAnnotatedClass(StockValue.class);
		config.addAnnotatedClass(StockExchange.class);
		config.addAnnotatedClass(Sector.class);
		config.configure("pom.xml");
		
		SessionFactory factory =config.buildSessionFactory();
		Session session=factory.getCurrentSession();
		session.beginTransaction();
	
		Company company=new Company();
		company.setCompanyName("XYZ");
		company.setTurnover(3000000);
		company.setCeo("ABC");
		company.setBoardOfDirectors("BOD");
		company.setListedInStockExchange("YES");
		company.setSectors("North");
		company.setStockCode(23);
		
		IPOsPlanned iposPlanned= new IPOsPlanned();
	
		iposPlanned.setStock_exchange("NSE");
		iposPlanned.setPricePerShare(300);
		
		session.save(company);
		session.save(iposPlanned);
		
		
		session.getTransaction().commit();

		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Application");
		

		
	}
}

	