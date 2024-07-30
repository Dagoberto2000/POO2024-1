package entidades;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    public MensagemParaAlguem(String emailDestinatario, boolean anonima, String emailRemetente, String texto) {
        super(anonima, emailRemetente, texto);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if(ehAnonima()){
            return "Mensagem  para " + this.emailDestinatario + " Texto: "+ this.getTexto();
        }
        return "Mensagem de: " + this.getEmailRemetente()+ " para " + this.emailDestinatario + ". Texto: " + this.getTexto();
    }

}
