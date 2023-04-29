package kz.zhaxybek.projectbook.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection{
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
    public static ArrayList<Book> getBooks(){
        ArrayList<Book> books = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM books");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Book book = new Book();
                book.setName(resultSet.getString("name"));
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescription(resultSet.getString("description"));
                book.setGenre(resultSet.getString("genre"));
                book.setPrice(resultSet.getDouble("price"));
                books.add(book);
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return books;
    }
    public static void addBook(Book book){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO books (name, price, author, genre, description) " +
                    "VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, book.getName());
            statement.setDouble(2, book.getPrice());
            statement.setString(3, book.getAuthor());
            statement.setString(4, book.getGenre());
            statement.setString(5, book.getDescription());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static Book getBook(int id){
        Book book = null;
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM books WHERE id = ? LIMIT 1");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                book = new Book();
                book.setName(resultSet.getString("name"));
                book.setId(resultSet.getInt("id"));
                book.setAuthor(resultSet.getString("author"));
                book.setDescription(resultSet.getString("description"));
                book.setGenre(resultSet.getString("genre"));
                book.setPrice(resultSet.getDouble("price"));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }
    public static void updateBook(Book book){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE books " +
                    "SET " +
                    "name = ?, " +
                    "price = ?, " +
                    "genre = ?, " +
                    "description = ?, " +
                    "author = ? " +
                    "WHERE id = ?");
            statement.setString(1, book.getName());
            statement.setDouble(2, book.getPrice());
            statement.setString(3, book.getGenre());
            statement.setString(4, book.getDescription());
            statement.setString(5, book.getAuthor());
            statement.setInt   (6, book.getId());
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void deleteBook(int id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM books WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}