package business;
public class Avaliacao {

  
    // Declaração de variáveis

  
  public static int sequencia = 0;
  private int id;

  private int idConteudo;
  private Cliente autor; 
  private int nota;
  private String comentario;
  private float media;
  
    // Construtores

  public Avaliacao(int idConteudo, Cliente c, int nota) {
    this.id = sequencia++;
    this.idConteudo = idConteudo;
    this.autor = c;
    this.nota = nota;
    this.comentario = null;
  }

  public Avaliacao(int idConteudo, Cliente c, int nota, String comentario) {
    this.id = sequencia++;
    this.idConteudo = idConteudo;
    this.autor = c;
    this.nota = nota;
    this.comentario = comentario;

  }

  public Avaliacao(){
    
  }
  
    //Getters e Setters

  public float getMedia() {
	return media;
  }

  public void setMedia(float media) {
	this.media = media;
  }
  
  public Cliente getAutor() {
	 return autor;
  }

  public void setAutor(Cliente autor) {
	 this.autor = autor;
  }
  
  public int getIdConteudo() {
    return this.idConteudo;
  }

  public int getNota() {
    return this.nota;
  }

  public String getComentario() {
    return this.comentario;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


}