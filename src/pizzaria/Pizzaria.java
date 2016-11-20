/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzaria;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pizzaria {
    
    private static Scanner leitor = new Scanner (System.in);
    
    private static List<Pessoa> pessoas;
    
    public static List<Pessoa> getPessoas(){
        return pessoas;
    }
    
    private static List<Pizza> pizzas;
    
    public static List<Pizza> getPizzas(){
        return pizzas;
    }
    
    private static List<Voto> votos;
    
    public static List<Voto> getVotos(){
        return votos;
    }
       
    public static void main(String[] args) {
        
        int op = 0;
                
        pessoas = new ArrayList<Pessoa>();
        
        pizzas = new ArrayList<Pizza>();
        
        votos = new ArrayList<Voto>();
        
        do {
            op = Menu();

            switch (op) {
                case 1:
                    FacaCadastro();
                    break;
                case 2:
                    ListarUsuarios();
                    break;
                case 3:
                    EditarUsuarios();
                    break;
                case 4:
                    BuscarUsuarios();
                    break;
                case 5:
                    FacaCadastroDaPizza();
                    break;
                case 6:
                    ListarTipoDePizza();
                    break;
                case 7:
                    EditarPizzas();
                    break;
                case 8:
                    BuscarPizza();
                    break;
                case 9:
                    Vote();
                    break;
                case 10:
                    ListarVotos();
                    break;
                case 11:
                    ListarNotaDasPizzas();
                    break;
                case 12:
                    PesquisarIntera();
            }
        } while (op != 0);
    }

    private static int Menu() {
        
        System.out.println("-------------------------------");
        System.out.println("| 1 - FAZER O CADASTRO        |");
        System.out.println("| 2 - LISTAR USUÁRIOS         |");
        System.out.println("| 3 - MODIFICAR USUÁRIOS      |");
        System.out.println("| 4 - BUSCAR USUÁRIOS         |");
        System.out.println("| 5 - CADASTRAR TIPO DE PIZZA |");
        System.out.println("| 6 - LISTAR TIPOS DE PIZZAS  |");
        System.out.println("| 7 - MODIFICAR TIPOS DE PIZZA|");
        System.out.println("| 8 - BUSCAR TIPO DE PIZZA    |");
        System.out.println("| 9 - VOTAR                   |");
        System.out.println("| 10 - MOSTRAR VOTOS          |");
        System.out.println("| 11 - Listar Nota das Pizzas |");
        System.out.println("| 12 - Perquisar Vaquinha     |");
        System.out.println("-------------------------------");
        
        System.out.println("");
        System.out.println(" 0 - PARA SAIR");
        System.out.println("");
        System.out.print(" DIGITE SUA OPÇÃO: ");
        
        int op = leitor.nextInt();
        leitor.nextLine();
        System.out.println("---------------------");

        return op;
    }

    private static void FacaCadastro() {
        System.out.println("Cadastrando Usuário");
        System.out.print("Digite seu Codigo: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Digite seu Nome: ");
        String nome = leitor.nextLine();
        
        Pessoa p = new Pessoa (cod, nome);
        
        Pizzaria.pessoas.add(p);
    }

    private static void FacaCadastroDaPizza() {
        System.out.println("Cadastrando o tipo da Pizza");
        System.out.print("Digite o código da Pizza: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        System.out.print("Digite o Nome da Pizza: ");
        String nome = leitor.nextLine();
        
        Pizza pz = new Pizza (cod, nome);
        
        Pizzaria.pizzas.add(pz);
    }

    private static void Vote() {
        System.out.print("Digite o Codigo da Pessoa Votante: ");
        int codPessoa = leitor.nextInt();
        leitor.nextLine();
        
        int i = 0;
        
        Pessoa p = BuscarUsuarios (codPessoa);
        
        if(p !=null){
        
        System.out.print("Digite o Codigo da Pizza: ");
        int codPizza = leitor.nextInt();
        leitor.nextLine();
        
        Pizza pz = BuscarPizza (codPizza);
        
            if (pz != null){
                
                
                
                System.out.println(" --------------------- ");
                System.out.println("|      1 - Ruim       |");
                System.out.println("|      2 - Média      |");
                System.out.println("|      3 - Boa        |");
                System.out.println("|      4 - Muito Boa  |");
                System.out.println("|      5 - Execelente |");
                System.out.println(" --------------------- ");
                System.out.print("Digite o Seu Voto: ");
                int codVoto = leitor.nextInt();
                leitor.nextLine();
        
        
                pz.setQualidade(codPizza);
                
                Voto v = new Voto(p, pz, codVoto);

                Pizzaria.votos.add(v);

                String qualidade = ("");


                for (Voto vs : votos){

                    if( v.getPizza().getCodigo() == codPizza ){
                        if(v.getVoto() != 0){
                            i = i + 1;
                            switch (codVoto){
                                case 1:
                                    //i = i + 1;
                                    qualidade = ("Ruim");
                                    break;
                                case 2:
                                    //i = i + 1;
                                    qualidade = ("Média");
                                    break;
                                case 3:
                                    //i = i + 1;
                                    qualidade = ("Boa");
                                    break;
                                case 4:
                                    //i = i + 1;
                                    qualidade = ("Muito Boa");
                                    break;
                                case 5:
                                    //i = i + 1;
                                    qualidade = ("Execelente");
                                    break;
                            }
                        }
                        
                        
                    }
                }
                //System.out.println("A Pizza votada foi: " + pz);
                System.out.println("A qualidade da pizza votada é: " + qualidade);

                System.out.println("Voto computado com sucesso");

            }else{
                System.out.println("Voto não computado");
            } 
        
        }else{
            System.out.println("Modelo Pizza não Cadastrada");
        }
    }

    private static void ListarUsuarios() {
        for(Pessoa p: pessoas){
            Pessoa.ImprimirDados(p);
        }
    }

    private static void ListarTipoDePizza() {
        for (Pizza pz: pizzas){
            Pizza.ImprimirDados(pz);
        }
    }

    private static void EditarUsuarios() {
        System.out.print("Digite o codigo do Aluno: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        Pessoa p = BuscarUsuarios(cod);
        
        if (p != null){
            System.out.print("Digite o novo Codigo (anterior: "+ p.getCodigo() +"): ");
            int codPessoa = leitor.nextInt();
            leitor.nextLine();
            p.setCodigo(codPessoa);
            
            System.out.print("Digite o nome Nome (anterior: "+ p.getNome() +"): ");
            String nomePessoa = leitor.nextLine();
            p.setNome(nomePessoa);
            
            System.out.println("Pessoa alterada com sucesso");
        }else{
            System.out.println("Pessoa não alterada");
        }
        
    }

    private static void EditarPizzas() {
        System.out.print("Digite o codigo da Pizza: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        Pizza pz = BuscarPizza(cod);
        
        if (pz != null){
            System.out.print("Digite o novo Codigo (anterior: "+ pz.getCodigo() +"): ");
            int codPizza = leitor.nextInt();
            leitor.nextLine();
            pz.setCodigo(codPizza);
            
            System.out.print("Digite o nome Nome (anterior: "+ pz.getNome() +"): ");
            String nomePizza = leitor.nextLine();
            pz.setNome(nomePizza);
            
            System.out.println("Modelo Pizza alterada com sucesso");
        }else{
            System.out.println("Modelo Pizza não alterada");
        }
    }

    private static Pessoa BuscarUsuarios(int codigo) {
        for (Pessoa p : pessoas) {
            if (codigo == p.getCodigo()){
                return p;
            }
        }
        
        return null;
    }

    private static Pizza BuscarPizza(int codigopizza) {
        for (Pizza pz : pizzas) {
            if (codigopizza == pz.getCodigo()){
                return pz;
            }
        }
        
        return null;
    }

    private static void BuscarUsuarios() {
        System.out.print("Digite o codigo do Usuário: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        Pessoa p = BuscarUsuarios(cod);
        
        if (p != null){
            Pessoa.ImprimirDados(p);
        }else{
            System.out.println("Usuário não Cadastrado!");
        }
    }

    private static void BuscarPizza() {
        System.out.print("Digite o codigo da Pizza: ");
        int cod_pz = leitor.nextInt();
        leitor.nextLine();
        
        Pizza pz = BuscarPizza(cod_pz);
        
        if (pz != null){
            Pizza.ImprimirDados(pz);
        }else{
            System.out.println("Pizza não Cadastrada!");
        }
    }

    private static void ListarVotos() {
        for (Voto v: votos) {
            Voto.ImprimirDados(v);
        }
    }

    private static void ListarNotaDasPizzas() {
        System.out.print("Digite o Codigo da Pizza: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        boolean pizza = BuscarVotacaoPizza(cod);
        
        if(pizza == false){
            System.out.println("Pizza não cadastrada");
        }
    }
    
    private static boolean BuscarVotacaoPizza(int codigo) {
        boolean verificador;
        verificador = false;
        for(Voto v : votos){
            if(codigo == v.getPizza().getCodigo()){
                Voto.ImprimirDados(v);
                verificador = true;
            }
        }
        if(verificador == false){
            return false;
        }else{
            return true;
        }
        
    }

    private static void PesquisarIntera() {
        System.out.println("Digite o codigo do usuario: ");
        int cod = leitor.nextInt();
        leitor.nextLine();
        
        
        int maior = 0;
        
        votos.forEach((v) -> {
            if(cod == v.getPessoa().getCodigo()){
                System.out.println("A pessoa que vai solicitar a pizza é: " + v.getPessoa().getNome());
                    if(cod == v.getPessoa().getCodigo()){
                        if(v.getVoto() > maior){
                            int m = 0;
                            m = v.getVoto();
                                for(Voto vt : votos){
                                    if(vt.getVoto() == m && vt.getPizza().getId() == v.getPizza().getId()){
                                        System.out.println("As pessoas que iram divir a Pizza com você será: " + v.getPessoa().getId());
                                        Voto.ImprimirDados(vt);
                                    }
                                }
                        }
                    }
            }
        });
    }
}