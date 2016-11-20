package pizzaria;

public class Pizza {

    private int id;
    private int codigo;
    private String nome;
    private int nota;
    private int qualidade;

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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getQualidade() {
        return qualidade;
    }

    public void setQualidade(int qualidade) {
        this.qualidade = qualidade;
    }
    
    public Pizza(int cod, String nome) {
        this.codigo = cod;
        this.nome = nome;
        
        this.id = Pizzaria.getPizzas().size() + 1;
    }
    
    public static void ImprimirDados(Pizza pz) {
        System.out.println("----------");
        System.out.println("Id: " + pz.getId());
        System.out.println("Codigo: " + pz.getCodigo());
        System.out.println("Nome: " + pz.getNome());
        System.out.println("----------");
    }
    
    public static void ImprimirDadosPizza(Pizza pz) {
        System.out.println("----------");
        System.out.println("Id: " + pz.getId());
        System.out.println("Codigo: " + pz.getCodigo());
        System.out.println("Nome: " + pz.getNome());
        System.out.println("Qualidade: " + pz.getQualidade());
        System.out.println("----------");
    }
    
}
