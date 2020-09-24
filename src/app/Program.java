package app;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Department;
import entities.Employee;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String departamento = scan.nextLine();
		
		System.out.println("Entre com o nome do funcionario: ");
		String nome = scan.nextLine();
		
		System.out.println("Entre com o nivel do funcionario: ");
		String nivel = scan.nextLine();
		
		System.out.println("Entre com o salario base do funcionario: ");
		Double salario = scan.nextDouble();
		
		Employee funcionario = new Employee(nome, salario, WorkerLevel.valueOf(nivel), new Department(departamento));
		
		
		System.out.println("Quantos contratos esse funcionario tem: ");
		int n = scan.nextInt();
		
		for (int i = 0; i < n; i++) {
			
			System.out.print("Entre com os dados do contrato #"+ i+1 + ": ");
			
			System.out.print("Data (DD/MM/AAAA): ");
			Date data = sdf.parse(scan.next());					
			
			System.out.print("Valor por hora: ");
			double valor = scan.nextDouble();
			
			System.out.print("Horas: ");
			int horas = scan.nextInt();
			
			Contract contrato = new Contract(data, valor, horas);
			
			funcionario.addContract(contrato);
			
		}
		
		System.out.println();
		System.out.println("Entre com o mes e ano para calcular o rendimento: ");
		String mesano = scan.nextLine();
		int mes = Integer.parseInt(mesano.substring(0, 2));
		int ano = Integer.parseInt(mesano.substring(3));
		
		System.out.println();
		System.out.print("Nome: "+ funcionario.getNome());
		System.out.print("Departamento: "+ funcionario.getDepartment().getName());
		System.out.print("Rendimento em : "+ mesano + ": " + funcionario.income(ano, mes));
		
		
		scan.close();		

	}

}
