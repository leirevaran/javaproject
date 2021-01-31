package fr.epita.services.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.datamodel.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestHibernate {

	@Inject
	@Named("datasourceH2")
	private DataSource ds;
//
//	@Inject
//	private SessionFactory sf;

//	@Test
//	public void testHibernate() {
//		// given
//		Session session = sf.openSession();
//		Question question = new Question();
//		question.setDifficulty(1);
//		question.setQuestionTitle("this is a test from hibernate");
//
//		// when
//		Transaction tx = session.beginTransaction();
//		session.save(question);
//		Transaction tx2 = session.beginTransaction();
//		//create choices
//		tx2.commit();
//		tx.commit();
//	
//		// then
//		try (Connection connection = ds.getConnection();
//				PreparedStatement stmt = connection
//						.prepareStatement("select questionTitle from question where questionTitle = ?")) {
//			stmt.setString(1,question.getQuestionTitle() );
//			ResultSet rs = stmt.executeQuery();
//			int i = 0; 
//			while (rs.next()) {
//				System.out.println(rs.getString("questionTitle"));
//				i++;
//				//TODO : check with assertion
//			}
//			Assert.assertNotEquals(0, i);
//		} catch (Exception e) {
//
//		}
//	
//	
//
//	}

}
