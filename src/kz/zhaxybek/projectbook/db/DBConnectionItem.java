package kz.zhaxybek.projectbook.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnectionItem {
    private static Connection connection;
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bitlab",
                    "root",
                    "root");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Items> getItems(){
        ArrayList<Items> itemss = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM items");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Items items = new Items();
                items.setName(resultSet.getString("name"));
                items.setId(resultSet.getLong("id"));
                items.setDescription(resultSet.getString("description"));
                items.setPrice(resultSet.getDouble("price"));
                itemss.add(items);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return itemss;

    }
    public static void addCritique(Items items){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO items (name, description, price) " +
                    "VALUES (?, ?, ?)");
            statement.setString(1, items.getName());
            statement.setString(2, items.getDescription());
            statement.setDouble(3, items.getPrice());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }}