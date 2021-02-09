package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Employee {

	private String nome;
	private Double salariobase;
	private WorkerLevel level;
	// Associations
	private Department department;
	private List<Contract> contracts = new ArrayList<>();

	// constructor
	public Employee(String nome, Double salariobase, WorkerLevel level, Department department) {
		this.nome = nome;
		this.salariobase = salariobase;
		this.level = level;
		this.department = department;
	}

	// empty constructor
	public Employee() {

	}

	// Getters - Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalariobase() {
		return salariobase;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public void setSalariobase(Double salariobase) {
		this.salariobase = salariobase;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	// Add contract
	public void addContract(Contract contrato) {
		this.contracts.add(contrato);
	}

	// Remove contract
	public void removeContract(Contract contrato) {
		this.contracts.remove(contrato);
	}
	
	
	// Calculate the income with salary and benefits	
	public double income(int ano, int mes) {
		double sum = salariobase;
		Calendar cal = Calendar.getInstance();

		for (Contract contrato : contracts) {

			cal.setTime(contrato.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_mont = cal.get(Calendar.MONTH) + 1;

			if (ano == c_year && mes == c_mont) {
				sum += contrato.totalValue();
			}

		}
		return sum;
	}


}
