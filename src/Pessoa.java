public abstract class Pessoa {
    //Superclasse de Enfermeira e Cidadão.
    private String cpfPessoa;
    private String nomePessoa;

    //CPF e Nome.
    public String getCpfPessoa(){

        return cpfPessoa;
    }
    public void setCpfPessoa(String cpfPessoa){

        this.cpfPessoa = cpfPessoa;
    }


    public String getNomePessoa(){

        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa){

        this.nomePessoa = nomePessoa;
    }
}

