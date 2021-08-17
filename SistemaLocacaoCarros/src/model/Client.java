package model;

public class Client {
	private int id;
	private String name;
	private String address;
	private String contact;
	private String cpf;
	
	public Client() {	
	}
	
	public Client(String name, String address, String contact, String cpf) {
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return id + " Nome=" + name + ", Endereco=" + address + ", Telefone=" + contact + ", CPF=" + cpf;
	}	
}
