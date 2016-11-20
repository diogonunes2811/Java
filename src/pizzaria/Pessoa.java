package pizzaria;

public class Pessoa {
    
    private int id;
    private int codigo;
    private String nome;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Pessoa(int cod, String nome) {
        this.codigo = cod;
        this.nome = nome;
        
        this.id = Pizzaria.getPessoas().size() +1;
    }
    
    public static void ImprimirDados(Pessoa p) {
        System.out.println("----------");
        System.out.println("Id: " + p.getId());
        System.out.println("Codigo: "+ p.getCodigo());
        System.out.println("Nome: " + p.getNome());
        System.out.println("----------");
    }
    
}
