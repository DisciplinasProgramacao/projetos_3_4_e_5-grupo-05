// import static org.junit.jupiter.api.Assertions.*;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;

// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

// public class EspecialistaTest {

//     Especialista e;
//     String nome = "Arthur";
//     String senha = "senha";
//     String login = "login";
//     List<Conteudo> listaParaVer;
//     List<Conteudo> listaJaVista;
//     List<Date> listDatasAssistidas;

//     @BeforeEach
//     void setUp() {
//         listaParaVer = new ArrayList<>();
//         listaJaVista = new ArrayList<>();
//         listDatasAssistidas = new ArrayList<>();
//         e = new Especialista(nome, senha, login, listaParaVer, listaJaVista, listDatasAssistidas);
//     }


//     @Test
//     @DisplayName("Testando dados iniciais de cliente especialista")
//     void CreateEspecialista() {
//         assertEquals(nome, e.getNomeDeUsuario());
//         assertEquals(senha, e.getSenha());
//         assertEquals(login, e.getLogin());
//         assertNotNull(e.getListaJaVista());
//         assertNotNull(e.getListaJaVista());
//         assertNotNull(e.getListaDatasAssistidasSeries());
//     }


// //    @Test
// //    @DisplayName("Comentario de um cliente especialista")
// //    void testComentar() {
// //        assertNotNull(e.comentar());
// //    }
// }
