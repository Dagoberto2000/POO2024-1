package aplication;

import entidades.Amigo;
import entidades.Mensagem;
import exceptions.AmigoInexistenteException;
import exceptions.AmigoNaoSorteadoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestaSistemaAmigo {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        SistemaAmigo listaAmigo = new SistemaAmigo();
        listaAmigo.cadastraAmigo("Jose", "jose@gmail.com");
        listaAmigo.cadastraAmigo("Maria", "maria@gmail.com");
        try{
            listaAmigo.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
            listaAmigo.configuraAmigoSecretoDe("maria@gmail.com", "jose@gmail.com");
            listaAmigo.enviarMensagemParaAlguem("Eu te amo Jose, casa comigo","maria@gmail.com", "jose@gmail.com", true );
            listaAmigo.enviarMensagemParaTodos("O jose é um lindo!", "maria@gmail.com", true);
            System.out.println(listaAmigo.pesquisaMensagensAnonimas());

            List<Mensagem> mensagens = new ArrayList<>(listaAmigo.pesquisaTodaasAsMensagens());
            for (Mensagem m: mensagens){
                if(m.ehAnonima()){
                    System.out.println(m.getTextoCompletoAExibir());
                }
            }



            if(listaAmigo.pesquisaAmigoSecretoDe("jose@gmail.com").equals("maria@gmail.com")) {
                System.out.println("ok");
            }




        }
        catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println(e);
        }
        sc.close();
    }
}
