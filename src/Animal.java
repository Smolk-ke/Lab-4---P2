import java.util.Scanner;

public class Animal {

	private int fome;
	private int energia;
	private int felicidade; 
	protected String nome;
	protected String especie;
	
	public Animal(String nome, String especie) {
		this.nome = nome;
		this.especie = especie;
		this.fome = 50;
		this.energia = 100;
		this.felicidade = 50;
	}
	
	protected void passarTempo() {
		fome += 5;
		if (fome > 100) {
			fome = 100;
		}else if (fome < 0) {
			fome = 0;
		}
		
		energia -= 3;
		if(energia < 0) {
			energia = 0;
		}else if (energia > 100) {
			energia = 100;
		}
		
		if (fome >= 80) {
			felicidade -= 10;
		}
		if (energia < 10) {
			felicidade -= 5;
		}
		
		if (felicidade < 0) {
			felicidade = 0;
		}else if (felicidade > 100) {
			felicidade = 100;
		}
	}
	
	public void alimentar(int quantidade) {
		if(quantidade >= 0) {
			fome -= quantidade;
			if (fome < 0) { 
				fome = 0;
			}
			passarTempo();
		}else {
			System.out.println("A quantidade de alimento não pode ser negativa."); 
		}
		
	}
	
	public void brincar() {
		if (energia < 20) {
			System.out.println("O " + this.nome + " está cansado(a).");
		}else { 
			energia -= 20;
			if(energia < 0) {
				energia = 0;
			}
			felicidade += 15;
			if(felicidade > 100) {
				felicidade = 100;
			}
			passarTempo();
		}
		
	}
	
	public void dormir() {
		energia = 100;
		fome += 25;
		passarTempo();				
	}
	
	public void getStatus() {
		if (felicidade >= 70) {
			System.out.println("Seu bixinho está radiante de felicidade.");
		}else if(felicidade >= 40 && felicidade <70) {
			System.out.println("Seu bichinho está bem, mas podia estar melhor.");
		}else {
			System.out.println("Seu bichinho está triste, cuide melhor dele.");
		}
	}
	
	public int getFome() {
		return fome;
	}
	
	public int getEnergia() {
		return energia;
	}
	
	public int getFelicidade() {
		return felicidade;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nome do bicho: ");
		String nome = scanner.nextLine();
		System.out.print("Especie do bicho: ");
		String especie = scanner.nextLine();
		
		Animal bicho = new Animal(nome, especie);
		
		System.out.println("1. Ver status");
		System.out.println("2. Alimentar");
		System.out.println("3. Brincar");
		System.out.println("4. Dormir");
		System.out.println("5. Sair");
		int opcao;
		
		do {
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			switch (opcao) {
			case 1:
				bicho.getStatus();
				break;
			case 2:
				System.out.print("Quantidade de alimento: ");
				int qtdAlimento= scanner.nextInt();
				bicho.alimentar(qtdAlimento);
				break;
			case 3:
				bicho.brincar();
				break;
			case 4:
				bicho.dormir();
				break;
			case 5:
				System.out.println("Jogo encerrado.");
				System.out.println("Fome: "  + bicho.getFome());
				System.out.println("Energia: " + bicho.getEnergia());
				System.out.println("Felicidade: " + bicho.getFelicidade());
				break;
			}
		} while (opcao != 5); 
		scanner.close();
	}
	
	
}
