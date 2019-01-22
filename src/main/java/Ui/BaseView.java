package Ui;

import java.util.List;

import Client.Client;

public interface BaseView {

	
	
	public void showError(Throwable error);
	
	public void showResult(List<Client> data);
}
