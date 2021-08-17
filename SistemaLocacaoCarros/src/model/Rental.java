package model;

import java.util.Date;

public class Rental {
	private int id;
	private String client_cpf;
	private String car_license_plate;
	private Date date_rental;
	private boolean rented;
	
	public Rental() {
	}
	
	public Rental(String client_cpf, String car_license_plate) {
		this.client_cpf = client_cpf;
		this.car_license_plate = car_license_plate;
		this.rented = true;
		this.date_rental = new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClient_cpf() {
		return client_cpf;
	}

	public void setClient_cpf(String client_cpf) {
		this.client_cpf = client_cpf;
	}

	public String getCar_license_plate() {
		return car_license_plate;
	}

	public void setCar_license_plate(String car_license_plate) {
		this.car_license_plate = car_license_plate;
	}

	public Date getDate_rental() {
		return date_rental;
	}

	public void setDate_rental(Date date_rental) {
		this.date_rental = date_rental;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	@Override
	public String toString() {
		return id + " CPF cliente=" + client_cpf + ", Placa carro=" + car_license_plate + ", Data aluguel=" + date_rental
				+ ", Vigor=" + rented;
	}
}
