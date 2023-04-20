import java.util.Date;
import java.util.Random;

public class Sinistro {
    // Propriedades
    private int id;
    private Date data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;


    // Construtor
    public Sinistro(int id, Date data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.id = setId();
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
    }


    // Métodos
    // Getters (acessors) e Setters (mutators)
    public int getId() {
        return id;
    }

    public int setId() {
        Random num = new Random();
        int id = num.nextInt(9999999 - 1000000) + 1000000;
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    @Override
    public String toString() {
        return "ID: " + this.id + "\n" +
               "data: " + this.data + "\n" +
               "Endereço: " + this.endereco + "\n" +
               "Seguradora: " + this.seguradora + "\n" +
               "Veículo: " + this.veiculo + "\n" +
               "Cliente: " + this.cliente + "\n";
    }
}