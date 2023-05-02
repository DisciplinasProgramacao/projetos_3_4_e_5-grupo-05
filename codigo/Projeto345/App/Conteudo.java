import java.util.Random;
abstract public class Conteudo {
  
  private final static Random gerador = new Random();
    private final static String[] GENEROS = {
            "Ação", "Terror", "Comédia",
            "Suspense", "Drama", "Anime",
            "Aventura", "Sci-fy", "Superhero",
            "Documentario"
    };
    private final static String[] IDIOMAS = {
            "Ingles", "Português", "Espanhol",
            "Mandarim", "Turco", "Francês",
            "Russo", "Alemão", "Japonês",
            "Koreano", "Italiano", "Grego"
    };

    protected int id;
    protected String nome;
    protected String idioma;
    protected String genero;
    protected int audiencia;
    protected int nota;
    protected String dataDeLancamento;

    public Conteudo(int id, String nome, String dataDeLancamento) {
        this.id = id;
        setNome(nome);
        setIdioma(IDIOMAS[gerador.nextInt(IDIOMAS.length)]);
        setGenero(GENEROS[gerador.nextInt(GENEROS.length)]);
        setDataDeLancamento(dataDeLancamento);
        this.audiencia = 0;
        this.nota = 0;
    }

    public Conteudo() {
        this.id = gerador.nextInt(1000);
        this.nome = "";
        setIdioma(IDIOMAS[gerador.nextInt(IDIOMAS.length)]);
        setGenero(GENEROS[gerador.nextInt(GENEROS.length)]);
        this.audiencia = 0;
        this.dataDeLancamento = "";
        this.nota = 0;
    }

    public int getNota(){
      return this.nota;
    }
  public void setNota(int nota){
    this.nota = nota;
  }
  
    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getIdioma() {
        return this.idioma;
    }

    public String getGenero() {
        return this.genero;
    }

    public int getAudiencia() {
        return this.audiencia;
    }

    public String getDataDeLancamento() {
        return this.dataDeLancamento;
    }

    public void setNome( String nome) {
        if (nome.length() < 2) {
            System.out.println("AVISO: o nome deve ter mais de 2 silabas");
            return;
        }
        this.nome = nome;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDataDeLancamento(String dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public void registrarAudiencia() {
        this.audiencia++;
    }

}