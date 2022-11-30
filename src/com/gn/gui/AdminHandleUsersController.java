/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gn.gui;

import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import entities.Associe;
import entities.Client;
import entities.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.ComboBoxTreeTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import services.AssocieServices;
import services.ClientServices;
import services.UserServices;

/**
 * FXML Controller class
 *
 * @author SBS
 */
public class AdminHandleUsersController implements Initializable {

    @FXML
    private JFXTreeTableView<User> usersTable;
    @FXML
    private StackPane root;
    @FXML
    private StackPane sp1;
    @FXML
    private StackPane sp2;
    @FXML
    private HBox main;
    @FXML
    private VBox content;
    
    ObservableList<User> users;
    
    ObservableList<String> actions;
    
    ArrayList<User> usersToDelete = new ArrayList<>(); 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        JFXTreeTableColumn<User,String> id = new JFXTreeTableColumn<>("User Id");
        id.setPrefWidth(150);
        id.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(String.valueOf(param.getValue().getValue().getId()));
                return (ObservableValue<String>) obsString;
            }
        });
        
        JFXTreeTableColumn<User,String> email = new JFXTreeTableColumn<>("User Email");
        email.setPrefWidth(150);
        email.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(String.valueOf(param.getValue().getValue().getEmail()));
                return (ObservableValue<String>) obsString;
            }
        });
        
        JFXTreeTableColumn<User,String> role = new JFXTreeTableColumn<>("User Role");
        role.setPrefWidth(150);
        role.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>(String.valueOf(param.getValue().getValue().getRole()));
                return (ObservableValue<String>) obsString;
            }
        });
        
        JFXTreeTableColumn<User,String> action = new JFXTreeTableColumn<>("User Action");
        action.setPrefWidth(150);
        action.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<User, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TreeTableColumn.CellDataFeatures<User, String> param) {
                ObservableValue<String> obsString = new ReadOnlyObjectWrapper<>("");
                return (ObservableValue<String>) obsString;
            }
        });
        ObservableList<String> actions = FXCollections.observableArrayList();
        actions.add("delete");
        action.setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(actions));
        
        UserServices us = new UserServices();
        
        try {
            users = us.getAllUsers();
            final TreeItem<User> root = new RecursiveTreeItem<User>(users, RecursiveTreeObject::getChildren);
            email.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
            email.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<User, String>>() {

                @Override
                public void handle(TreeTableColumn.CellEditEvent<User, String> event) {
                    TreeItem<User> currentEdititngUser = usersTable.getTreeItem(event.getTreeTablePosition().getRow());
                    System.out.println("li badaltou : "+ currentEdititngUser.getValue().toString());
                    currentEdititngUser.getValue().setEmail(event.getNewValue());
                }
            });
            action.setOnEditCommit(new EventHandler<TreeTableColumn.CellEditEvent<User, String>>() {

                @Override
                public void handle(TreeTableColumn.CellEditEvent<User, String> event) {
                    TreeItem<User> currentEdititngUser = usersTable.getTreeItem(event.getTreeTablePosition().getRow());
                    System.out.println("li badaltou : "+ currentEdititngUser.getValue().toString());
                    usersToDelete.add(currentEdititngUser.getValue());
                }
            });
            this.usersTable.setEditable(true);
            this.usersTable.getColumns().setAll(id,email,role,action);
            this.usersTable.setRoot(root);
            this.usersTable.setShowRoot(false);
        } catch (SQLException ex) {
            Logger.getLogger(AdminHandleUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    

    @FXML
    private void update(MouseEvent event) throws SQLException {
        System.out.println(usersToDelete.size());
        UserServices us = new UserServices();
        ClientServices cs = new ClientServices();
        AssocieServices as = new AssocieServices();
        //delete first
        for (int i=0; i<usersToDelete.size();i++) {
            if (usersToDelete.get(i).getRole().equals("client")) {
                Client c = new Client();
                c.setId(usersToDelete.get(i).getId());
                System.out.println(c.toString());
                System.out.println(c.getId());
                boolean res = cs.deleteClient(c);
                System.out.println("Client with id "+usersToDelete.get(i).getId()+" delete : " + res);
            } else
            if (usersToDelete.get(i).getRole().equals("associe")) {
                Associe a = new Associe();
                a.setId(usersToDelete.get(i).getId());
                boolean res = as.deleteAssocie(a);
                System.out.println("Associe with id "+usersToDelete.get(i).getId()+" delete : " + res);
            }
            for (int j=0;j<users.size();j++) {
                if (users.get(j).getId() == usersToDelete.get(i).getId() ) {
                    users.remove(j);
                }
            }
        }
        System.out.println("haw li 93ad");
        // update 
        for (int i=0;i<users.size();i++) {
             if (users.get(i).getRole().equals("client")) {
                Client c = new Client();
                c.setId(users.get(i).getId());
                c.setEmail(users.get(i).getEmail());
                boolean res = cs.updateClientByAdmin(c);
                System.out.println("Client with id "+users.get(i).getId()+" update : " + res);
            } else
            if (users.get(i).getRole().equals("associe")) {
                Associe a = new Associe();
                a.setId(users.get(i).getId());
                a.setEmail(users.get(i).getEmail());
                boolean res = as.updateAssocieByAdmin(a);
                System.out.println("Associe with id "+users.get(i).getId()+" update : " + res);
            }
        }
    }
    
}
