package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SchoolDao;
import model.dao.StudentDao;
import model.entities.School;
import model.entities.Student;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);

		int op = 0, aux, grade;
		String name, demand;
		Date birthDate;
		Student student;
		School school;
		List<School> listSch = new ArrayList<>();
		List<Student> listStu = new ArrayList<>();

		StudentDao studentDao = DaoFactory.createStudentDao();
		SchoolDao schoolDao = DaoFactory.createSchoolDao();

		System.out.println("Bem vindo ao sistema de TestJDBC");
		while (op != 12) {
			System.out.println("\nLista de op��es: ");
			System.out.println(opcoes() + "\n");
			System.out.print("Escolha a sua op��o(1-12): ");
			op = sc.nextInt();
			switch (op) {
			case 1:
				System.out.println("Voc� escolheu 'Inserir escola'.");
				System.out.print("Digite o nome da nova escola a ser inserida: ");
				sc.nextLine();
				name = sc.nextLine();
				school = new School(null, name);
				schoolDao.insert(school);
				System.out.println("Inser��o realizada com sucesso.");
				System.out.println("O id da escola " + school.getName() + " � : " + school.getId());
				break;
			case 2:
				System.out.println("Voc� escolheu 'Atualizar escola'.");
				System.out.println("Digite o id da escola a ser atualizada: ");
				aux = sc.nextInt();
				school = schoolDao.findById(aux);
				System.out.print("Digite o novo nome para a escola: ");
				sc.nextLine();
				name = sc.nextLine();
				school.setName(name);
				schoolDao.update(school);
				System.out.println("Atualiza��o realizada com sucesso.");
				System.out.println("A escola de id " + school.getId() + " passou a se chamar " + school.getName());
				break;
			case 3:
				System.out.println("Voc� escolheu 'Deletar escola'.");
				System.out.println("Digite o id da escola a ser deletada: ");
				aux = sc.nextInt();
				schoolDao.deleteById(aux);
				System.out.println("Dele��o realizada com sucesso.");
				break;
			case 4:
				System.out.println("Voc� escolheu 'Encontrar por escola'.");
				System.out.println("Digite o id da escola a ser encontrada: ");
				aux = sc.nextInt();
				school = schoolDao.findById(aux);
				System.out.println("Busca por escola realizada com sucesso.");
				System.out.println("A escola �: " + school);
				break;
			case 5:
				System.out.println("Voc� escolheu 'Listar todas as escolas'.");
				listSch = schoolDao.findAll();
				System.out.println("Segue a lista das escolas cadastradas:");
				listSch.forEach(System.out::println);
				break;
			case 6:
				System.out.println("Voc� escolheu 'Inserir aluno'.");
				System.out.print("Digite o nome do novo aluno a ser inserido: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("Digite sua data de nascimento: ");
				birthDate = sdf.parse(sc.next());
				System.out.print("Digite a queixa principal: ");
				sc.nextLine();
				demand = sc.nextLine();
				System.out.print("Digite a sua s�rie: ");
				grade = sc.nextInt();
				System.out.print("Digite o id da escola do aluno: ");
				aux = sc.nextInt();
				school = schoolDao.findById(aux);
				student = new Student(null, name, birthDate, demand, grade, school);
				studentDao.insert(student);
				System.out.println("Inser��o realizada com sucesso.");
				System.out.println("O id do aluno " + student.getName() + " � : " + student.getId());
				break;
			case 7:
				System.out.println("Voc� escolheu 'Atualizar aluno'.");
				System.out.println("Digite o id do aluno a ser atualizado: ");
				aux = sc.nextInt();
				student = studentDao.findById(aux);
				System.out.print("Digite o novo nome para o aluno: ");
				sc.nextLine();
				name = sc.nextLine();
				student.setName(name);
				studentDao.update(student);
				System.out.println("Atualiza��o realizada com sucesso.");
				System.out.println("O aluno de id " + student.getId() + " passou a se chamar " + student.getName());
				break;
			case 8:
				System.out.println("Voc� escolheu 'Deletar aluno'.");
				System.out.println("Digite o id do aluno a ser deletado: ");
				aux = sc.nextInt();
				studentDao.deleteById(aux);
				System.out.println("Dele��o realizada com sucesso.");
				break;
			case 9:
				System.out.println("Voc� escolheu 'Encontrar por aluno'.");
				System.out.println("Digite o id do aluno a ser encontrado: ");
				aux = sc.nextInt();
				student = studentDao.findById(aux);
				System.out.println("Busca por aluno realizada com sucesso.");
				System.out.println("O aluno �: " + student);
				break;
			case 10:
				System.out.println("Voc� escolheu 'Listar todos os alunos'.");
				listStu = studentDao.findAll();
				System.out.println("Segue a lista dos alunos cadastrados:");
				listStu.forEach(System.out::println);
				break;
			case 11:
				System.out.println("Voc� escolheu 'Listar alunos por escola'");
				System.out.print("Digite o id da escola: ");
				aux = sc.nextInt();
				school = new School(aux, null);
				listStu = studentDao.findBySchool(school);
				listStu.forEach(System.out::println);
				break;
			case 12:
				break;
			default:
				System.out.println("Op��o inv�lida. Digite novamente entre 1 e 12.");
				break;
			}
		}
		System.out.println("At� mais!");
	}

	public static String opcoes() {
		return "1. Inserir escola;\n2. Atualizar escola;\n" + "3. Deletar escola\n4. Encontrar por escola\n"
				+ "5. Listar todas as escolas;\n" + "6. Inserir aluno;\n7. Atualizar aluno;\n"
				+ "8. Deletar aluno\n9. Encontrar por aluno\n10. Listar todas os alunos;\n"
				+ "11. Listar alunos por escola;\n12. Sair;";
	}
}
