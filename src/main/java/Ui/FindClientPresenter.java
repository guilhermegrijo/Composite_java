package Ui;

import java.util.List;

import javax.inject.Inject;

import Client.Client;
import Client.FindClientInteractor;
import Util.Response;

public class FindClientPresenter {
	
	@Inject
	FindClientInteractor interactor;
	
	BaseView view;
	
	@Inject
	public FindClientPresenter() {
		
	}
	
	
	public void bind(BaseView view) {
		this.view = view;			
	}
	
	public void search(String name) {
		processResponse(interactor.execute(name));
		
		
	}
	
	private void processResponse(Response<List<Client>> response) {
        switch (response.status) {
        
           case SUCCESS:
             view.showResult(response.data);
                break;

           case ERROR:
              view.showError(response.error);
              break;
       }
 }
	
	
	

}
