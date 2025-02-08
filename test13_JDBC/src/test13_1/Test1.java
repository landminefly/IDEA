package test13_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/atguigu", "root", "073412");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM t_emp");
        ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM t_emp");
        while(resultSet.next()){
            System.out.print(resultSet.getInt("emp_id") + "\t");
            System.out.print(resultSet.getString("emp_name") + "\t");
            System.out.print(resultSet.getDouble("emp_salary") + "\t");
            System.out.print(resultSet.getInt("emp_age") + "\n");
        }
    }
}
