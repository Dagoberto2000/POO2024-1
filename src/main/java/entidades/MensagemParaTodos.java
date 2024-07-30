package entidades;


public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(boolean anonima, String emailRemetente, String texto) {
        super(anonima, emailRemetente, texto);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if(ehAnonima()){
            return "Mensagem para todos. Texto:" + this.getTexto();
        }
        return "Mensagem de" + this.getEmailRemetente() + "para todos.  Texto:" + this.getTexto();
    }
}
