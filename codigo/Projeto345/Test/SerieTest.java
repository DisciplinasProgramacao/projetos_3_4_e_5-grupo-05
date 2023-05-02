import static org.junit.jupiter.api.Assertions.*;

 import org.junit.jupiter.api.BeforeEach;
 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;

 public class SerieTest {
   Serie s;
   String nome = "Batman";
   String genero = "Drama";
   String idioma = "Inglês";
   String dataDeLancamento = "12/0/2023";
   int quantidadeEpisodios = 20;

   @BeforeEach
   void setUp() {
     s = new Serie(nome,genero, idioma, dataDeLancamento,quantidadeEpisodios);
   }


   @Test
   @DisplayName("Criando uma serie e verificando os seus valores")
   void CreateSerie() {
     assertEquals(nome, s.getNome());
     assertEquals(genero, s.getGenero());
     assertEquals(idioma, s.getIdioma());
     assertEquals(quantidadeEpisodios, s.getQuantidadeEpisodios());
     assertEquals(dataDeLancamento, s.getDataDeLancamento());
     assertEquals(0, s.getAudiencia());
   }


   @Test
   @DisplayName("Registrando uma nova audiencia")
   void registrarAudiencia() {
     assertEquals(0, s.getAudiencia());
     s.registrarAudiencia();
     assertEquals(1, s.getAudiencia());
   }
 }
