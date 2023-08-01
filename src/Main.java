import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.text.ParseException;

//Nome do autor: Nathasha de Araújo Fariña
//RA:20129284-5 || Programação de Sistemas II

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scannerData = new Scanner(System.in);
        Scanner scannerCpf = new Scanner(System.in);
        Scanner scannerTxt = new Scanner(System.in);
        int opcoes = 0;

        ArrayList<Cidadao> list = new ArrayList<>();
        Enfermeira enferm = new Enfermeira();

        System.out.println("**Sistema Único de Vacinação**");
        System.out.println("-------------------------------");

        System.out.println("Nome da enfermeira aplicadora:");
        enferm.setNomePessoa(scannerTxt.next());

        System.out.println("CPF da enfermeira aplicadora (digite somente números):");
        enferm.setCpfPessoa(scannerCpf.next());

        System.out.println("Escolha uma das opções abaixo:");

        do {
            exibirMenu();
        opcoes = scannerData.nextInt();
        switch (opcoes) {
            case 1:
                Cidadao cidadao = new Cidadao();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                //Solicitando informação de nome do cidadão e CPF, assim como as datas das vacinações.
                System.out.println("Nome do cidadão:");
                cidadao.setNomePessoa(scannerTxt.next());
                System.out.println("CPF do cidadão (digite somente números):");
                cidadao.setCpfPessoa(scannerCpf.next());

                System.out.println("Data da primeira dose da vacina (dd/mm/aaaa):");
                cidadao.setPrimeiraDose(scannerTxt.next());
                Date doseUm = dateFormat.parse(cidadao.getPrimeiraDose());

                System.out.println("Data da segunda dose da vacina (dd/mm/aaaa):");
                cidadao.setSegundaDose(scannerTxt.next());
                Date doseDois = dateFormat.parse(cidadao.getSegundaDose());

                //Calculando as datas informadas pela enfermeira.
                long date = Math.abs(doseUm.getTime() - doseDois.getTime());
                long dia = TimeUnit.DAYS.convert(date, TimeUnit.MILLISECONDS);

                //Caso inferior a 4 meses as doses, informar que não tem direito a uma nova dose e voltar ao menu.
                if (dia < 120) {
                    System.out.println("A segunda dose não pode ser aplicada! Aplicar somente 4 meses depois da 1º dose!");
                } else {
                    System.out.println("Data da terceira dose da vacina (dd/mm/aaaa):");
                    cidadao.setTerceiraDose(scannerTxt.next());
                    Date doseTres = dateFormat.parse(cidadao.getTerceiraDose());

                    //Calculando as datas informadas pela enfermeira.
                    date = Math.abs(doseDois.getTime() - doseTres.getTime());
                    dia = TimeUnit.DAYS.convert(date, TimeUnit.MILLISECONDS);

                    if (dia < 120) {
                        System.out.println("A terceira dose não pode ser aplicada! Aplicar somente 4 meses depois da 2ª dose");
                    } else {
                        System.out.println("Data da quarta dose da vacina (dd/mm/aaaa):");
                        cidadao.setQuartaDose(scannerTxt.next());
                        Date doseQuatro = dateFormat.parse(cidadao.getQuartaDose());

                        //Calculando as datas informadas pela enfermeira.
                        date = Math.abs(doseTres.getTime() - doseQuatro.getTime());
                        dia = TimeUnit.DAYS.convert(date, TimeUnit.MILLISECONDS);

                        if (dia < 120) {
                            System.out.println("A quarta dose não pode ser aplicada! Aplicar somente 4 meses depois da 3ª dose");
                        } else {
                            //Registrar cidadão com aplicação de vacina completa.
                            list.add(cidadao);
                        }
                    }
                }
                break;

            case 2:
                //Verificação de registro de paciente.
                if (list.size() > 0) {
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).dados();
                    }
                } else {
                    System.out.println("Não há dados cadastrados.");
                }
                break;
            case 0:
                break;
            default:
                //Caso usuário não tenha selecionado nenhuma das opções do menu.
                System.out.println("Inválido! Selecione uma das opções abaixo.");
                break;
        }
    }
        while(opcoes !=0);
    }

    //Menu do sistema.
    private static void exibirMenu() {
        System.out.println("+--------------------------------------+");
        System.out.println("|                 MENU                 |");
        System.out.println("+--------------------------------------+");
        System.out.println(
                        "| 1 - Vacinar paciente                 |\n" +
                        "| 2 - Listar pacientes vacinados       |\n" +
                        "| 0- Sair                              |");
        System.out.println("+--------------------------------------+\n\n");
    }
}
