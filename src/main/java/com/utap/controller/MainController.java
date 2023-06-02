package com.utap.controller;

import com.utap.library.students;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class MainController implements Initializable {

    @FXML
    private TextField idField;

    @FXML
    private TextField nombreField;

    @FXML
    private TextField apellidoField;

    @FXML
    private TextField materiaField;

    @FXML
    private TextField notaField;

    @FXML
    private Button insertButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<students> TableView;

    @FXML
    private TableColumn<students, Integer> idColumn;

    @FXML
    private TableColumn<students, String> nombreColumn;

    @FXML
    private TableColumn<students, String> apellidoColumn;

    @FXML
    private TableColumn<students, String> materiaColumn;

    @FXML
    private TableColumn<students, Integer> notaColumn;

    @FXML
    private void insertButton() {
        String query = "insert into students (Id, Nombre, Apellido, Materia, Nota) values (" + idField.getText() + ",'" + nombreField.getText() + "','" + apellidoField.getText() + "','" + materiaField.getText() + "'," + notaField.getText() + ")";
        executeQuery(query);
        String query2 = "insert into materias (Id, Nombre)"
        showstudents();

    }


    @FXML
    private void updateButton() {
        String query = "UPDATE students SET Nombre='" + nombreField.getText() + "',Apellido='" + apellidoField.getText() + "',Materia='" + materiaField.getText() + ",Nota=" + notaField.getText() + " WHERE ID=" + idField.getText() + "";
        executeQuery(query);
        showstudents();
    }

    @FXML
    private void deleteButton() {
        String query = "DELETE FROM students WHERE ID=" + idField.getText() + "";
        executeQuery(query);
        showstudents();
    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showstudents();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://mysql-williamsh.alwaysdata.net/williamsh_crud?autoReconnect=true&useSSL=false", "williamsh_crud", "Principal54321*");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<students> getStudentsList() {
        ObservableList<students> studentsList = FXCollections.observableArrayList();
        Connection connection = getConnection();
        String query = "SELECT * FROM students ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            students students;
            while (rs.next()) {
                students = new students(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Materia"), rs.getInt("Nota"));
                studentsList.add(students);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentsList;
    }

    // I had to change ArrayList to ObservableList I didn't find another option to do this but this works :)
    public void showstudents() {
        ObservableList<students> list = getStudentsList();

        idColumn.setCellValueFactory(new PropertyValueFactory<students, Integer>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<students, String>("nombre"));
        apellidoColumn.setCellValueFactory(new PropertyValueFactory<students, String>("apellido"));
        materiaColumn.setCellValueFactory(new PropertyValueFactory<students, String>("materia"));
        notaColumn.setCellValueFactory(new PropertyValueFactory<students, Integer>("nota"));

        TableView.setItems(list);
    }

}
