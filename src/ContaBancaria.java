import java.sql.*;
import java.util.Scanner;

public class ContaBancaria
{
    public static void main(String[] args)
    {
        boolean opcaoInvalida = true;
        int opcao;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tabajara Bank System");
        System.out.println("Digite a sua opção: ");
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Consultar Conta");
        System.out.println("3 - Alterar Conta");
        System.out.println("4 - Remover Conta");
        System.out.println("5 - Exibe todas as contas");
        System.out.println("9 - Sair do Sistema");

        while(opcaoInvalida)
        {
            try
            {
                System.out.print("Sua opção: ");
                opcao = scanner.nextInt();
                System.out.println("Opção selecionada: " + opcao);

                switch(opcao)
                {
                    case 1 :
                        CadastrarUsuario();
                        opcaoInvalida = false;
                        break;
                    case 2 :
                        MostrarConta();
                        opcaoInvalida = false;
                        break;
                    case 3 :
                        opcaoInvalida = false;
                        break;
                    case 4 :
                        opcaoInvalida = false;
                        break;
                    case 5 :
                        opcaoInvalida = false;
                        break;
                    case 9:
                        System.out.println("Obrigado por usar o Tabajara Bank System!");
                        opcaoInvalida = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida!");
                }
            }
            catch(NumberFormatException e)
            {

            }
        }



    }

    public static void CadastrarUsuario()
    {
        String name;
        String password;
        float balance = 0;
        boolean validOption = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Cadastrar usuário: ");
        name = scanner.nextLine();

        System.out.println("Cadastrar senha: ");
        password = scanner.nextLine();

        while (!validOption)
        {
            try
            {
                System.out.print("Insira saldo: ");
                balance = Float.parseFloat(scanner.nextLine());
                validOption = true;
            }
            catch (Exception e)
            {
                System.out.println("Saldo Inválido. Favor inserir saldo correto.");
            }
        }

        try
        {
            Connection conexao = SQLConnection.open();
            Statement s = conexao.createStatement();

            s.executeUpdate("INSERT INTO accounts (name, balance) VALUES ('"+ name +"', '"+ balance+"')");
            conexao.close();
        }
        catch(Exception e)
        {

        }
    }

    public static void MostrarConta()
    {
        try
        {
            Connection conexao = SQLConnection.open();
            Statement s = conexao.createStatement();

            System.out.println( s.executeQuery("SELECT * FROM accounts"));
            conexao.close();
        }
        catch(Exception e)
        {

        }
    }
}
