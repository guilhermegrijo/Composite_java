package Ui;

import java.util.Scanner;

import App.AppComponent;

public class MainView {

	Scanner scanner = new Scanner(System.in);
	

	AppComponent component;

	FindClientView view;

	public MainView(AppComponent component) {

		view = new FindClientView(component);
		run();

	}

	public void run() {

		while (true) {
			System.out.println("Escolha as opções a baixo ou tecle 'q' para sair");
			System.out.println("1 - Procurar cliente");
			System.out.println("2 - Saldo do cliente");
			System.out.println("3 - transferir dinheiro");

			String query = scanner.nextLine();
			switch (query) {
			case "1":
				System.out.println("Nome do cliente");
				query = null;
				query = scanner.nextLine();	
				view.search(query);
				clearConsole();
				break;
				
			case "2":
				break;
			
			case "3":
				break;			

			}
			if (query.equalsIgnoreCase("q"))
				break;

		}
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}
}
