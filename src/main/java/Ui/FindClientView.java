package Ui;

import java.util.List;

import javax.inject.Inject;

import App.AppComponent;
import Client.Client;

public class FindClientView implements BaseView {

	@Inject
	FindClientPresenter presenter;

	public FindClientView (AppComponent component){
		component.inject(this);
		presenter.bind(this);
		
	}

	public void search(String name) {
		presenter.search(name);
	}

	public void showError(Throwable error) {
		System.out.println("Algo deu errado: ");
		System.out.println(error);

	}

	@Override
	public void showResult(List<Client> clients) {
		System.out.println("Lista de resultados:");

		clients.forEach(client -> System.out.println(client.toString()));

	}

}
