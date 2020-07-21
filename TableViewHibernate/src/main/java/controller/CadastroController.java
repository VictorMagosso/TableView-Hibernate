package controller;

import db.DAOUsuario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Usuario;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroController implements Initializable {
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
        rgCol.setCellValueFactory(new PropertyValueFactory<>("data"));
        dataCol.setCellValueFactory(new PropertyValueFactory<>("user"));

        listaUsuarios();
    }
    private ObservableList<Usuario> listaUsuarios(){
        daoUsuario.listarUsuarios();
        return FXCollections.observableArrayList(

        );
    }
}
