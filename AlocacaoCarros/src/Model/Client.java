package Model;

public class Client {
	private String name;
	private String address;
	private String contact;
	private String cpf;
	
	public Client() {	
	}
	
	public Client(String name, String address, String contact, String cpf) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.cpf = cpf;
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
		return "Name= " + name + ", address= " + address + ", contact= " + contact + ", cpf= " + cpf;
	}
	
}
