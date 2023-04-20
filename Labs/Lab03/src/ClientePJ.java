import java.util.ArrayList;
import java.util.Date;

public class ClientePJ extends Cliente{
    private String CNPJ;
    private Date dataFundacao;


    // Construtor
    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculos, String cNPJ, Date dataFundacao) {
        super(nome, endereco, listaVeiculos);
        CNPJ = cNPJ;
        this.dataFundacao = dataFundacao;
    }


    // Métodos
    // Getters (acessors) e Setters (mutators)
    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String cNPJ) {
        CNPJ = cNPJ;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }


    // Funções da Classe
    public boolean validarCNPJ(String cpf) {

        // LEMBRAR:
        // Alterar as posições de verificação
        // Quantidade de caracteres é 14, e não 11


        // 1. Removendo todos os caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // 2. Verificando se o CPF tem 11 dígitos
        if (cpf.length() != 11) return false;

        // 3. Verificando se todos os dígitos são iguais
        char primeiro = cpf.charAt(0);
        for (int i = 1; i < 11; i++) {
            if (primeiro == cpf.charAt(i)) return false;
        }

        // 4. Calculando os dígitos verificadores
        // Convertendo String para int
        int temp = 0;
        int primeiro_verificador_calculado = 0;
        int segundo_verificador_calculado = 0;

        // Primeiro dígito:
        for (int i = 0; i < 9; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
        }
        temp = temp % 11;
        if (temp > 1) primeiro_verificador_calculado = 11 - temp;

        // Segundo dígito
        temp = 0;
        for (int i = 0; i < 10; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
        }
        temp = temp % 11;
        if (temp > 1) segundo_verificador_calculado = 11 - temp;

        // 5.Verificando se os dígitos verificadores calculados são iguais aos dígitos
        int primeiro_verificador_cpf = Character.getNumericValue(cpf.charAt(9));
        int segundo_verificador_cpf = Character.getNumericValue(cpf.charAt(10));
        
        if (primeiro_verificador_calculado == primeiro_verificador_cpf 
            && segundo_verificador_calculado == segundo_verificador_cpf) return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() +
               "CNPJ: " + this.CNPJ + "\n" +
               "Data da FUndação: " + this.dataFundacao + "\n";
    }
}
