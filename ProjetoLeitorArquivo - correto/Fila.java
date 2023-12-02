// 01614959 André Filipe de Oliveira Figueiredo
// 01599936 Ayrton Leonardo Fernandes de Melo
// 01615970 Estephani Germana Pereira da Silva
// 01616532 Abner de Lima Nunes






import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//arquivos para leitura e tratamento de excessão na leitura de arquivo
import java.io.File;
import java.io.FileNotFoundException;




public class Fila {

    
    public static void main(String[] args) {
        //Fila de produtos
       
        Queue<Regpro> produtos = new LinkedList(); 
        //caminho do arquivo
        String caminhoArquivo = "Arquivos/Produto.txt";
        // arquivo do tipo file que lê o caminho 
        File arquivo = new File(caminhoArquivo);

        // try_catch obrigatorio
        try{
            //scanner do arquivo
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {//loop de repetição para todas as linhas do arquivo
                //conteúdo da linha
                ArrayList<String> lista;
                String linha = leitor.nextLine();
                // através de dessa função estou separando os itens pelo ; oq é mais seguro
                lista = contar(linha);
                
                 
                 int codigo = Integer.parseInt(lista.get(0).trim());
                 String descricao = lista.get(1);
                 int quantidade = Integer.parseInt(lista.get(2).trim());
                 double preco = Double.parseDouble(lista.get(3).trim());
                 int categoria = Integer.parseInt(lista.get(4).trim());
                 
                /* Essa é a forma antiga e que funciona
                 porém quando se adiciona espaços vazios no txt entre os itens,
                         ele deixa de funcionar */
                /*
                int codigo = Integer.parseInt(linha.substring(0,2));
                String descricao =  linha.substring(3,35).trim();
                double preco = Double.parseDouble(linha.substring(42,45).trim());
                int quantidade = Integer.parseInt(linha.substring(36,41).trim());
                int categoria = Integer.parseInt(linha.substring(46, 47)); 
                */
                
                Regpro item = new Regpro(codigo, descricao, preco, quantidade, categoria);
                produtos.add(item);
                
            }

            for (Regpro produto : produtos) {
                System.out.println(produto.getRelatorio());
            }
           
            
        }catch(FileNotFoundException e){ // cao não exista o arquivo
            System.out.println("Arquivo não encontrado!");
        }



    }


    public static ArrayList<String> contar(String linha){
            int marcador = 0;
            ArrayList<String> lista = new ArrayList<>();
            for (int i = 0; i < linha.length(); i++) {
                    
                    char letra = linha.charAt(i);
                    //percorre a lista e se encontra um ; armazena o valor
                    if (letra == ';') {
                    if (marcador == 0) {
                        lista.add(linha.substring(marcador, i));
                        marcador = i;
                    }else if(letra ==';' && marcador > 0){
                       
                       lista.add(linha.substring(marcador+1, i));
                        marcador = i;
                    }
                }
                // esse aqui é para o ultimo item que não vai ter ; no final
                if (i == linha.length()-1) {
                   
                    lista.add(linha.substring(marcador+1, i+1));
                }
                }

            return lista;
    }
}

//Adicionei categoria nesse codigo e também adicionei essa nova informação no construtor

