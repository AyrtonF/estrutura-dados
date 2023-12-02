import java.util.Scanner;
public class Menu {
public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
        int opc;

        do {
           System.out.println("--------------------------------------------------");
            
            exibirMenu();
            opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Lista.main(args);
                    break;
                case 2:
                    Fila.main(args);
                    break;
                case 3:
                    Pilha.main(args);
                    break;
                case 4:
                    Arvore.main(args);
                break;
                case 0:
                    System.out.println("Encerrando programa...");
                    break;
                default:
                    System.out.println("Opção inválida");

            }

           
        } while (opc != 5);
        sc.close();
    }
  }	    

 public static void exibirMenu() {
        System.out.println("######### Menu ##########");
        System.out.println("# 1 - LISTA    	    #");
        System.out.println("# 2 - FILA		    #");
        System.out.println("# 3 - PILHA		    #");
        System.out.println("# 4 - ARVORE	    #");
        System.out.println("# 0 - ENCERRAR          #");
        System.out.println("########################");
        System.out.print("Escolha uma opção: ");
    }
    
}
