package model;

public class Car {
	private int id;
	private String model;
	private String license_plate;
	private String color;
	private int year;
	private float fine_amount;
	private boolean available;
	
	public Car() {	
	}

	public Car(String model, String license_plate, String color, int year, float fine_amount) {
		this.model = model;
		this.license_plate = license_plate;
		this.color = color;
		this.year = year;
		this.fine_amount = fine_amount;
		this.available = true;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public float getFine_amount() {
		return fine_amount;
	}

	public void setFine_amount(float fine_amount) {
		this.fine_amount = fine_amount;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return id + " Modelo=" + model + ", Placa=" + license_plate + ", Cor=" + color
				+ ", Ano=" + year + ", Valor aluguel=" + fine_amount + ", Disponibilidade=" + available;
	}
	
}
