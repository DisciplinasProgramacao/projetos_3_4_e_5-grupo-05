package Projeto1;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SerieTest {
  Serie s;
  
  @BeforeEach
  void setUp() {
    s = new Serie("Batman", "Drama", "ingles", 20, 0);
  }


  @Test
  @DisplayName("Criando uma serie e verificando os seus valores")
  void CreateSerie() {
    assertEquals("Batman", s.getNome());
    assertEquals("Drama", s.getGenero());
    assertEquals("ingles", s.getIdioma());
    assertEquals(20, s.getQuantidadeEpisodios());
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
