package com.rosu.cotroller;

import com.rosu.model.User;
import com.rosu.repository.UserRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TODO: Add scenes for different operations: e.g. login, register.
//TODO: make all the tabs hidden. Login window opens when you click an option in the menu
//TODO: After login success show other tabs. Clear text fields. Show message
//TODO: after clicking register , empty textboxes, show message user registered

//TODO: create other entities. Task, Subtask + repository for each
//TODO: create tab for registering tasks
//TODO: create controls for registering subtasks
//TODO: create tab for assign task. Two comoboboxes. One for tasks, one for all users.


public class Controller {
    @FXML
    private Label lblInformation;

    @FXML
    private TextField txtFieldUsernameRegister;

    @FXML
    private PasswordField pwdFieldRegister;

    @FXML
    private PasswordField pwdFieldConfirmRegister;

    @FXML
    private Button btnRegister;

    @FXML
    private TextField txtFieldUsernameLogin;

    @FXML
    private PasswordField pwdFieldLogin;

    @FXML
    private Button btnLogin;

    private UserRepository userRepository;
    private boolean isConnectionSuccessful = false;

    public void initialize() {
        try {
            persistenceConnection();
        }
        catch (Exception ex) {
            System.out.println("Connection is not allowed");
            isConnectionSuccessful = false;
        }
    }

    private void persistenceConnection() {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("TODOFx");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        userRepository = new UserRepository(entityManager);
    }

    @FXML
    private void registerUser(ActionEvent actionEvent) {
        //TODO: Add button to show password -> Ionut's ideea
        //TODO: Check if username already exists
        //TODO: Check if password contains certain characters
        //TODO: Save encrypted(encoded) password in DB. Be careful how to read them unencrypted

        User user = userRepository.findByUsername(txtFieldUsernameRegister.getText());
        if(pwdFieldRegister.getText().equals(pwdFieldConfirmRegister.getText())) {
            user = new User();

            user.setUsername(txtFieldUsernameRegister.getText());
            user.setPassword(pwdFieldRegister.getText());

            userRepository.save(user);
        }
    }

    @FXML
    private void loginUser(ActionEvent actionEvent) {
        //TODO: implement login action

    }
}
