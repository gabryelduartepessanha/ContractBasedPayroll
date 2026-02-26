package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Informe com o nome do departamento: ");
        String departamentName = sc.nextLine();
        System.out.println("Informe os dados do colaborador!");
        System.out.print("Informe o nome do trabalhador: ");
        String workerName = sc.nextLine();
        System.out.print("Senioridade: ");
        String workerLevel = sc.nextLine();
        System.out.print("Salário base: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));

        System.out.print("Informe a quantidade de contratos o funcionário tem: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Informe os dados do contrato " + i + ":");
            System.out.print("Data (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração do contrato (horas): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Informe o mês e ano para calcular o salário (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Nome: " + worker.getName());
        System.out.println("Departamento: " + worker.getDepartament().getName());
        System.out.println("Salário de: " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}