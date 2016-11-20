package pizzaria;

public class Voto {
    
    private int id;
    private Pessoa pessoa;
    private Pizza pizza;
    private int voto;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }
    
    public Voto(Pessoa pessoa, Pizza pizza, int voto){
        this.pessoa = pessoa;
        this.pizza = pizza;
        this.voto = voto;
        
        this.id = Pizzaria.getVotos().size() + 1;
    }
    

    public static void ImprimirDados(Voto voto){
        System.out.println("----");
            System.out.println("id: " + voto.getId());
            System.out.println("Pessoa: " + voto.getPessoa().getNome());
            System.out.println("Pizza: " + voto.getPizza().getNome());
            System.out.println("Voto: " + voto.getVoto());
            System.out.println("----");
        
    }
    
    public static void ImprimirDadosPizza(Voto pz) {
        System.out.println("----------");
        System.out.println("Id: " + pz.getId());
        //System.out.println("Codigo: " + pz.getCodigo());
        System.out.println("Nome: " + pz.getPessoa().getNome());
        System.out.println("Voto: " + pz.getVoto());
        System.out.println("----------");
    }
    
}
