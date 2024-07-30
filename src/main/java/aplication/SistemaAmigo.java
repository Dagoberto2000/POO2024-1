package aplication;

import entidades.Amigo;
import entidades.Mensagem;
import entidades.MensagemParaAlguem;
import entidades.MensagemParaTodos;
import exceptions.AmigoInexistenteException;
import exceptions.AmigoNaoSorteadoException;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigo = new ArrayList<>();
    private List<Mensagem> mensagem = new ArrayList<>();

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo amigo1 = new Amigo(nomeAmigo, emailAmigo);
        amigo.add(amigo1);
    }
    public Amigo pesquisaAmigo(String emailAmigo){
        for(Amigo a: amigo){
            if(a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        return null;
    }
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        MensagemParaTodos m = new MensagemParaTodos(ehAnonima, emailRemetente, texto);
        mensagem.add(m);
    }
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        MensagemParaAlguem m = new MensagemParaAlguem(emailDestinatario,ehAnonima, emailRemetente, texto);
        mensagem.add(m);
    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> msgAnonima = new ArrayList<>();
        for(Mensagem m: mensagem){
            if(m.ehAnonima()){
                msgAnonima.add(m);
            }
        }
        return msgAnonima;
    }
    public List<Mensagem> pesquisaTodaasAsMensagens(){
        return mensagem;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
            for (Amigo a : amigo) {
                if (a.getEmail().equals(emailDaPessoa)) {
                    a.setEmailAmigoSorteado(emailAmigoSorteado);
                    break;
                }
            }

    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoSorteadoException, AmigoInexistenteException{
        for(Amigo a: amigo){
            if(a.getEmail().equals(emailDaPessoa)){
                if(a.getEmailAmigoSorteado()!= null){
                    return a.getEmailAmigoSorteado();
                }
                throw new AmigoNaoSorteadoException("Esse amiguinho não foi sorteado.");
            }
        }
        throw new AmigoInexistenteException(" Amigo não existe");
    }
}
