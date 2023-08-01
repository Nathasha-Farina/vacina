public class Enfermeira extends Pessoa {
    //Subclasse de Pessoa.
    public Enfermeira(){
    }

    //Solicitar nome e CPF da enfermeira.
    public void informacaoEnfermeira(){
        System.out.println("Nome da enfermeira aplicadora: " +getNomePessoa());
        System.out.println("CPF da enfermeira aplicadora: " +getCpfPessoa());
    }
}
