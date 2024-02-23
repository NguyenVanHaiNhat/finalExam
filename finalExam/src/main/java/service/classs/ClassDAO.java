package service.classs;

import config.ConnectionDB;
import model.Class;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO implements IClassDAO{
    @Override
    public List<Class> findAll() {
        List<Class> classList = new ArrayList<>();
        Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet;
        try {
            connection = ConnectionDB.getConnection();
            statement = connection.prepareStatement("select * from class;");
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id_class = resultSet.getInt("id_class");
                String nameClass = resultSet.getString("nameClass");
                classList.add(new Class(id_class, nameClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return classList;
    }
}
