package com.hk.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanManagementTest {

	// spring 5.0.x doc
	// https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/

	// download jars here https://repo1.maven.org/maven2/org/springframework/
	public static void main(String[] args) {
		System.out.println("stat of main(-) method");

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/hk/cfgs/applicationContext.xml");

		DataSource dataSource = applicationContext.getBean("dataSource", DataSource.class);

		fetchAndDisplayRecords(dataSource);
		
		((AbstractApplicationContext) applicationContext).close();

		System.out.println("end of main(-) method");
	}

	private static void fetchAndDisplayRecords(DataSource dataSource) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			 // Get connection from DataSource
            connection = dataSource.getConnection();

            // Create statement
            statement = connection.createStatement();

            // Execute query
            resultSet = statement.executeQuery("SELECT name, aadhar_number FROM aadhar");

            // Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String aadharNumber = resultSet.getString("aadhar_number");
                System.out.println(name + ": " + aadharNumber);
            }			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
            // Close resources in finally block to ensure proper cleanup
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}
}
