// import java.util.ArrayList;
import java.util.Date;

public class ClientePF extends Cliente {
    // Propriedades
    private final String CPF;
    private String genero;
    private Date dataLicensa;
    private String educacao;
    private Date dataNascimento;
    private String classeEconomica;


    // Construtor
    public ClientePF(String nome, String endereco, String CPF, String genero,
            Date dataLicensa, String educacao, Date dataNascimento, String classeEconomica) {
        super(nome, endereco);
        this.CPF = CPF;
        this.genero = genero;
        this.dataLicensa = dataLicensa;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        this.classeEconomica = classeEconomica;
    }


    // Métodos
    // Getters (acessors) and Setters (mutators)
    public String getCPF() {
        return CPF;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataLicensa() {
        return dataLicensa;
    }

    public void setDataLicensa(Date dataLicensa) {
        this.dataLicensa = dataLicensa;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }
    

    // - Funções da Classe ClientePF

    public boolean validarCPF(String cpf) {
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
        int temp = 0;
        int resto;
        int verificador_calculado_1 = 0; // Primeiro verificador calculado
        int verificador_calculado_2 = 0;  // Segundo verificador calculado

        // Primeiro dígito:
        for (int i = 0; i < 9; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
        }
        resto = temp % 11;
        if (temp > 1) verificador_calculado_1 = 11 - resto;

        // Segundo dígito:
        temp = 0;
        for (int i = 0; i < 10; i++) {
            temp = temp + (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
        }
        resto = temp % 11;
        if (temp > 1) verificador_calculado_2 = 11 - resto;

        // 5.Verificando se os dígitos verificadores calculados são iguais aos dígitos do CPF
        int verificador_cpf_1 = Character.getNumericValue(cpf.charAt(9)); // Primeiro verificador do CPF = dígito 10
        int verificador_cpf_2 = Character.getNumericValue(cpf.charAt(10)); // Segundo verificador do CPF = dígito 11
        
        if (verificador_calculado_1 == verificador_cpf_1 && verificador_calculado_2 == verificador_cpf_2) return true;
        else return false;
    }

    @Override
    public String toString() {
        return super.toString() +
               "CPF: " + this.CPF + "\n" +
               "Gênero: " + this.genero + "\n" +
               "Data da Licensa: " + this.dataLicensa + "\n" +
               "Educação: " + this.educacao + "\n" +
               "Data de Nascimento: " + this.dataNascimento + "\n" +
               "classe Econômica: " + this.classeEconomica + "\n";
    }
}
