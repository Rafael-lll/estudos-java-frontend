import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class primeiroPasso {
    public static void main(String[] args) throws Exception {
        String curso = "Análise e Desenvolvimento de Sistemas";
        int tempoEstudoDiario = 1;  //Horas
        double rendimentoCdi = 11.75;
        boolean focadoNoObjetivo = true;
        

        System.out.println("Estudante de:" + curso);
        System.out.println("Meta diária:" + tempoEstudoDiario + "hora(s)");
        System.out.println("Taxa atual do cdi:" + rendimentoCdi + "%");

        if (focadoNoObjetivo) {
            System.out.println("Voce terá sucesso no bootcamp");
        }

        ArrayList<String> minhaLista = listarAtivos();
        simuladorDeRendimento();
        //calculadoraYield();
        //verificadorDeLotes();
        //analiseDeRisco();
        //gerenciarCarteira();
        //salvarCarteiraEmArquivo(minhaLista);
    }

    public static void simuladorDeRendimento(){

        double saldoInicial = 0;
        double aporteMensal = 0;

        Scanner teclado = new Scanner(System.in); // declaração para entrada de dados atraves do usuario
        boolean sucesso = false; //uso de flags

        System.out.println("Exercicio 1: Simulador de rendimento (operadores basicos)");
        
        while (!sucesso) {
            try{
                System.out.print("Informe seu saldo atual: ");
                saldoInicial = teclado.nextDouble();
                sucesso = true; //uso de flags
            } catch(InputMismatchException e){
                System.err.println("ERRO: Por favor digite apenas numeros decimais usando virgula.");
                teclado.next(); //obrigatorio no try-catch
            }
        } //try-catch usado para garantir a segurança dos dados, para que seja feita a inserção de forma correta dos dados

        while (sucesso) {
            try{
                System.out.print("Informe qual vai ser o seu aporte mensal: ");
                aporteMensal = teclado.nextDouble();
                sucesso = false; 
            } catch(InputMismatchException e){
                System.err.println("ERRO: Por favor digite apenas numeros decimais usando virgula.");
                teclado.next(); 
            }
        } 

        saldoInicial += aporteMensal;

        System.out.println("Saldo total registado com sucesso: " + saldoInicial);

        double taxaCdiMensal = 0.01;

        double saldoTotal = saldoInicial + (saldoInicial * taxaCdiMensal);

        System.out.println("Novo saldo com os rendimentos: " +  saldoTotal);  
    }

    public static void calculadoraYield() {
        Scanner teclado = new Scanner(System.in);
        double precoMxrf = 0;
        double ultimoRend = 0;
        boolean sucesso = false;

        System.out.println("Exercicio 2: Calculadora de Dividend Yield (porcentagem)");

        while (!sucesso) {
            try{
                System.out.println("Digite o valor atual da cota: (ex: 9,43) ");
                precoMxrf = teclado.nextDouble();
                sucesso = true;
            } catch (InputMismatchException e) {
            System.err.println("Erro: Digite apenas numeros decimais usando virgula!");
            teclado.next();
        }
        }

        while (sucesso) {
            try{
                System.out.print("Digite o valor do ultimo rendimento: ");
                ultimoRend = teclado.nextDouble();
                sucesso = false;
            } catch (InputMismatchException e) {
            System.err.println("Erro: Digite apenas numeros decimais usando virgula!");
            teclado.next();
        }
        }
        
        double yield = (ultimoRend / precoMxrf ) * 100;
        double yieldAnual = yield * 12;

        System.out.println("O rendimento desta FII mensal foi de: " + yield + "%");
        System.out.println("O rendimento desta FII Anual foi de: " + yieldAnual + "%");
    }
    
    public static void verificadorDeLotes() {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Exercicio 3: O verificador de lotes (Módulos %)");

        try{
            System.out.print("Digite a quantidade de ações que deseja comprar: ");
            int qntdAcoes = teclado.nextInt();
            int sobra = qntdAcoes % 10;
        
            System.out.println("Vão sobrar " + sobra + " ações de um lote completo de 10");

                if (sobra == 0) {
                    System.out.println("É um lote perfeito");   
                    }
        } catch (InputMismatchException e) {
            System.err.println("ERRO: voce deve digitar um numero inteiro valido!");
        } finally {
            System.out.println("Fim de verificação.");
        }
        
    }
    
    public static void analiseDeRisco() {
        Scanner teclado = new Scanner(System.in);
        double saldo = 0;
        int volatilidade = 0;
        boolean sucesso = false;

        System.out.println("Análise de riscos");

        while (!sucesso) {
            try {   
                System.out.print("Informe o seu saldo: ");
                saldo = teclado.nextDouble();
                sucesso = true;
        } catch (InputMismatchException e) {
            System.err.println("ERRO: voce deve digitar um numero em decimal valido!");

            teclado.next();
            }
        }

        while (sucesso) {
            try {
            System.out.print("Informe a volatilidade do fundo em uma escala de  1 a 10 (de baixa para alta): ");
            volatilidade = teclado.nextInt();
            sucesso = false;
        } catch (InputMismatchException e) {
            System.err.println("ERRO: voce deve digitar um numero inteiro valido!");

            teclado.next();
            }
        }

        if (saldo >= 1000 && volatilidade <= 3) {
            System.out.println("Aporte recomendado! Saldo e volatilidade dentro dos parametros de recomendação! ");
            
        }else if (saldo < 1000 && volatilidade <= 3 ) {
            System.out.println("Aporte  é recomendado! Mas o seu saldo está abaixo do recomendado. ");
        } else {
            System.out.println("Aporte não recomendando. Volatilidade muito alta para o perfil");
        }

    }

    public static void gerenciarCarteira() {

        ArrayList<String> carteira = new ArrayList<>();

        carteira.add("MXRF11");
        carteira.add("GARE11");
        carteira.add("KNCR11");
        carteira.add("IT4USA");

        System.out.println("Sua carteira atual possui: " + carteira.size() + " ativos.");

        for (String ativo : carteira) {
            System.out.println("Ativo monitorado: " + ativo);
        }
    }

    public static ArrayList<String> listarAtivos() {
        ArrayList<String> ativos = new ArrayList<>();

        ativos.add("MXRF11");
        ativos.add("GARE11");
        ativos.add("CONSR45");
        ativos.add("KNCR11");

        for (String ativo : ativos) {
            System.out.println("Analisando indicadores de: " + ativo);
        }
        return ativos;
    }

    public static void salvarCarteiraEmArquivo(ArrayList<String> ativos) {
            String nomeArquivo = "carteira_investimentos.txt"; //definição do nome do arq que será criado

            try(FileWriter fw = new FileWriter(nomeArquivo); //logica da criação
                PrintWriter pw = new PrintWriter(fw)) {
                
                    for (String ativo : ativos) {
                        pw.println(ativo); //recebendo os elementos no arq
                    }
                
                    System.out.println("Carteira salva com sucesso em: " + nomeArquivo ); //se tudo der certo..
            } catch (IOException e) {
                System.err.println("Erro ao salvar o arquivo: " + e.getMessage()); // caso seja demonstrada alguma falha...
            }

    }
}
