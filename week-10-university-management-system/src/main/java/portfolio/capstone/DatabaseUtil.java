package portfolio.capstone;
import java.sql.*;
public final class DatabaseUtil { private DatabaseUtil(){} public static Connection open() throws SQLException { String url=env("DB_URL","jdbc:mysql://localhost:3306/university_db"); return DriverManager.getConnection(url, env("DB_USER","root"), env("DB_PASSWORD","")); } private static String env(String key,String fallback){String v=System.getenv(key); return v==null||v.isBlank()?fallback:v;} }
