package db;

import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAOUsuario {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("TableView");
    EntityManager manager = factory.createEntityManager();

    public void inserirDados(String nome, int rg, String data, String user){
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setRg(rg);
        usuario.setData(data);
        usuario.setUser(user);

        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

    public void listarUsuarios(){
        String jpql = "select c from Usuario c";
        TypedQuery<Usuario> typedQuery = manager.createQuery(jpql, Usuario.class);
        List<Usuario> listaUsuario = typedQuery.getResultList();

        for (Usuario usuario : listaUsuario) {
            usuario.setNome();
               System.out.println(usuario.getNome() + usuario.getUser() + usuario.getRg());
        }

    }
}
