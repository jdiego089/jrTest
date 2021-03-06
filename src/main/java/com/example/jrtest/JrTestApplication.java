package com.example.jrtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.*;

@SpringBootApplication
public class JrTestApplication {

  public static void main( String[] args ) throws SQLException {

    System.out.println( "Creating database, started" );
    Connection conn = DriverManager.getConnection( "jdbc:h2:mem:testdb", "user", "password" );
    try ( Statement st = conn.createStatement() ) {
      st.execute( "create schema company" );
      st.execute( "create table company.customer(id integer, name varchar(10), age integer, address varchar, salary integer )" );
      st.execute( "INSERT INTO company.customer VALUES (1, 'Juan', 32, 'Alajuela', 2000 ) " );
      st.execute( "INSERT INTO company.customer VALUES (2, 'Diego', 25, 'Heredia', 1500 ) " );
      st.execute( "INSERT INTO company.customer VALUES (3, 'Brayan', 23, 'Cartago', 2000 ) " );
      st.execute( "INSERT INTO company.customer VALUES (4, 'Marvin', 25, 'San Jose', 6500 ) " );
      st.execute( "INSERT INTO company.customer VALUES (5, 'Rodolfo', 27, 'Guanacaste', 8500 ) " );
      st.execute( "INSERT INTO company.customer VALUES (6, 'Oscar', 22, 'Puntarenas', 4500 ) " );
      st.execute( "INSERT INTO company.customer VALUES (7, 'Maria', 24, 'Limon', 10000 ) " );
    }
    System.out.println( "Creating database, ended" );
    SpringApplication.run( JrTestApplication.class, args );
  }

}
