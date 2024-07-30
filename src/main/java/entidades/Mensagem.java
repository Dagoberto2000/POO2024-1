package entidades;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem(boolean anonima, String emailRemetente, String texto) {
        this.anonima = anonima;
        this.emailRemetente = emailRemetente;
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    public boolean ehAnonima(){
        return anonima;
    }
    public abstract String  getTextoCompletoAExibir();

}
