package portfolio.capstone;

import java.sql.*; import java.util.*;

public final class StudentDao {
    public List<Program> findPrograms() throws SQLException {
        List<Program> rows = new ArrayList<>();
        try (Connection c=DatabaseUtil.open(); PreparedStatement p=c.prepareStatement("SELECT program_id, program_name FROM programs ORDER BY program_name"); ResultSet r=p.executeQuery()) {
            while(r.next()) rows.add(new Program(r.getInt(1), r.getString(2)));
        }
        return rows;
    }
    public List<Student> findAll() throws SQLException {
        List<Student> rows=new ArrayList<>();
        String sql="SELECT s.student_id,s.registration_number,s.first_name,s.last_name,s.email,p.program_id,p.program_name FROM students s LEFT JOIN programs p ON p.program_id=s.program_id ORDER BY s.student_id";
        try(Connection c=DatabaseUtil.open(); PreparedStatement p=c.prepareStatement(sql); ResultSet r=p.executeQuery()) {
            while(r.next()) rows.add(new Student(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getObject(6)==null?null:new Program(r.getInt(6),r.getString(7))));
        }
        return rows;
    }
    public void insert(Student s) throws SQLException {
        String sql="INSERT INTO students(registration_number,first_name,last_name,email,program_id) VALUES(?,?,?,?,?)";
        try(Connection c=DatabaseUtil.open(); PreparedStatement p=c.prepareStatement(sql)) { p.setString(1,s.getRegistrationNumber());p.setString(2,s.getFirstName());p.setString(3,s.getLastName());p.setString(4,s.getEmail()); if(s.getProgram()==null)p.setNull(5,Types.INTEGER);else p.setInt(5,s.getProgram().id()); p.executeUpdate(); }
    }
}
