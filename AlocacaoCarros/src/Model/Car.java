package Model;

public class Car {
	private String model;
	private String license_plate ;
	private String color;
	private int year;
	private double fine_amount;
	private boolean rent;
	
	public Car() {	
	}

	public Car(String model, String license_plate, String color, int year, double fine_amount) {
		this.model = model;
		this.license_plate = license_plate;
		this.color = color;
		this.year = year;
		this.fine_amount = fine_amount;
		this.rent = false;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicense_plate() {
		return license_plate;
	}

	public void setLicense_plate(String license_plate) {
		this.license_plate = license_plate;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(double fine_amount) {
		this.fine_amount = fine_amount;
	}

	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}

	@Override
	public String toString() {
		return "Modelo= " + model + ", Placa= " + license_plate + ", Cor= " + color + ", Ano= " + year
				+ ", Valor aluguel= " + fine_amount + ", Alugado= " + rent;
	}
	
}
