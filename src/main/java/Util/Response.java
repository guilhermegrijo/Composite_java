package Util;

import java.util.List;
import Client.Client;

public class Response<T> {

	public T data;

	public Status status;

	public Throwable error;

	private Response(Status status, T data, Throwable error) {
		this.status = status;
		this.data = data;
		this.error = error;
	}

	public static Response error(Throwable error) {

		return new Response(Status.ERROR, null, error);
	}

	public static Response sucess(String data) {

		return new Response(Status.SUCCESS, data, null);
	}

	public static Response sucess(List<Client> data) {

		return new Response(Status.SUCCESS, data, null);
	}

	public static Response<Client> sucess(Client data) {

		return new Response(Status.SUCCESS, data, null);
	}

}
