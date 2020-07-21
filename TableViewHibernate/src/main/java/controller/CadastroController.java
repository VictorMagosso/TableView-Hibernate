package controller;

import db.DAOUsuario;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TableView");
    EntityManager manager = factory.createEntityManager();
    @FXML
    TableView<Usuario> tabela;
    @FXML
    TableColumn<Usuario, Integer> idCol, rgCol;
    @FXML
    TableColumn<Usuario, String> nomeCol, dataCol, userCol;
    @FXML
    TextField nome, rg, user;
    @FXML
    DatePicker dataNasc;

    DAOUsuario daoUsuario = new DAOUsuario();
    List<Usuario> listaUsuario = new ArrayList<>();
    int i;
    String jpql = "select c from Usuario c";

    public void salvarDados() {
        daoUsuario.inserirDados(
                nome.getText().toUpperCase(),
                Integer.parseInt(rg.getText()),
                dataNasc.getValue().toString(),
                user.getText().toUpperCase()
        );
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        rgCol.setCellValueFactory(new PropertyValueFactory<>("rg"));
        dataCol.setCellValueFactory(new PropertyValueFactory<>("data"));
        userCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        TypedQuery<Usuario> typedQuery = manager.createQuery(jpql, Usuario.class);
        listaUsuario = typedQuery.getResultList();
        tabela.getItems().setAll(FXCollections.observableArrayList(listaUsuario));
    }

}
