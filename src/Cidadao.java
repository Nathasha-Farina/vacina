public class Cidadao extends Pessoa{

    //Subclasse de Pessoa.
    private String primeiraDose;
    private String segundaDose;
    private String terceiraDose;
    private String quartaDose;

    public Cidadao(){
    }

    //Get e Set das 4 doses.
    public String getPrimeiraDose(){

        return primeiraDose;
    }
    public void setPrimeiraDose(String primeiraDose){

        this.primeiraDose = primeiraDose;
    }

    public String getSegundaDose(){

        return segundaDose;
    }
    public void setSegundaDose(String segundaDose){

        this.segundaDose = segundaDose;
    }

    public String getTerceiraDose(){

        return terceiraDose;
    }
    public void setTerceiraDose(String terceiraDose){

        this.terceiraDose = terceiraDose;
    }

    public String getQuartaDose(){

        return quartaDose;
    }
    public void setQuartaDose(String quartaDose){

        this.quartaDose = quartaDose;
    }

    //Dados para imprimir na opção do menu Listar Pacientes Vacinados.
    public void dados(){
        System.out.println("Nome do cidadão: "+getNomePessoa());
        System.out.println("CPF do cidadão: "+getCpfPessoa());
        System.out.println("Data da 1ª dose: "+getPrimeiraDose());
        System.out.println("Data da 2ª dose: "+getSegundaDose());
        System.out.println("Data da 3ª dose: "+getTerceiraDose());
        System.out.println("Data da 4ª dose: "+getQuartaDose());
        System.out.println("------------------------------------");
    }
}
