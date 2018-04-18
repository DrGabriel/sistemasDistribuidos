package faculdade.sistemasDistribuidos.trabalho1.rmi;

import java.math.BigDecimal;
import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

import org.hibernate.annotations.SourceType;

public class RepositorioNotasClient {
	public static void main(String[] args) {
		try{
			boolean saiuDoPrograma = false;
			BigDecimal notaPrecisa;
			int opcao = 0;
			String matriculaAluno = null;
			String codigoDisciplina = null;
			Scanner input = new Scanner(System.in);
			Float nota;
			RepositorioNotasInterface repo = (RepositorioNotasInterface) Naming.lookup("rmi://localhost/RepositorioNotas");
			
			do{
				System.out.flush();
				System.out.println("Repositorio de notas");
				System.out.println("1 para cadastrar uma nota.");
				System.out.println("2 para consulta nota de um aluno em uma disciplina.");
				System.out.println("3 para consultar lista de notas de um aluno.");
				System.out.println("4 para consultar cr de um aluno.");
				System.out.println("5 para sair do programa");
				System.out.print("Opcao: ");
				try{
					opcao = input.nextInt();
				}catch(Exception e){
					System.out.flush();
					System.err.println("Digite uma opcao valida!");
					System.out.println("Aperte uma tecla para continuar.");
					input.nextLine();
					continue;
				}
				
				switch(opcao){
					case 1:
						System.out.flush();
						System.out.println("Cadastrar nota");
						System.out.print("Digite a matricula do aluno: ");
						matriculaAluno = input.next();
						System.out.print("Digite o codigo da disciplina: ");
						codigoDisciplina = input.next();
						System.out.println("Digite a nota: ");	
						try{
							nota = input.nextFloat();
							notaPrecisa = new BigDecimal(nota);
						}catch (Exception e){
							System.err.println(e.getMessage());
							continue;
						}
						try{
							repo.cadastrar_nota(matriculaAluno, codigoDisciplina, notaPrecisa);
						}catch (Exception e){
							System.err.println(e.getMessage());
							continue;
						}
						
						break;
					case 2:
						System.out.flush();
						System.out.println("Consultar nota em uma disciplina");
						System.out.print("Digite a matricula do aluno: ");
						matriculaAluno = input.next();
						System.out.print("Digite o codigo da disciplina: ");
						codigoDisciplina = input.next();
						try{
							BigDecimal notaAluno = repo.consultar_nota(matriculaAluno, codigoDisciplina);
							if(notaAluno == null){
								System.out.println("Nao foi encontrada nota para o aluno: " + matriculaAluno
										+ "na disciplina " + codigoDisciplina);
							}else{
								System.out.println("Nota para o aluno: " + matriculaAluno
										+ "na disciplina " + codigoDisciplina + ": " + notaAluno);
							}
						}catch (Exception e){
							System.err.println(e.getMessage());
							continue;
						}
						break;
					case 3:
						System.out.flush();
						System.out.println("Consultar lista de notas.");
						System.out.print("Digite a matricula do aluno: ");
						matriculaAluno = input.next();
						try{
							List<Object[]> notasAluno = repo.consultar_notas(matriculaAluno);
							if(notasAluno == null){
								System.out.println("Nao foi encontrada nota para o aluno: " + matriculaAluno);
							}else{
								System.out.println("Notas para o aluno: " + matriculaAluno);
								notasAluno.forEach((notaDisciplina)->System.out.println("Nota:  " + notaDisciplina[0] + " diciplina: " + notaDisciplina[1]));
							}
						}catch (Exception e){
							System.err.println(e.getMessage());
							continue;
						}
						break;
					case 4:
						System.out.flush();
						System.out.println("Consultar cr.");
						System.out.print("Digite a matricula do aluno: ");
						matriculaAluno = input.next();
						try{
							BigDecimal cr = repo.consular_cr(matriculaAluno);
							if(cr == null){
								System.out.println("Nao foi encontrado cr para o aluno: " + matriculaAluno);
							}else{
								System.out.println("Cr para o aluno: " + matriculaAluno + " \ncr: " + cr);
							}
						}catch (Exception e){
							System.err.println(e.getMessage());
							continue;
						}
						break;
					case 5:
						saiuDoPrograma = true;
					default:
						System.out.println("Selecione uma opção valida.");
						break;
				}
			}while(!saiuDoPrograma);
			System.out.println("tchau");
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
