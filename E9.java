public class E9 {
	private double rupee;


	public E9(double rupee) {
		this.rupee = rupee;
	}


	public double getRupee() {
		return rupee;
	}


	public void setRupee(double rupee) {
		this.rupee = rupee;
	}


	public double convertToDollar() {
		// 1 Indian Rupee equals approximately 0.014 USD
		return rupee * 0.014;
	}


	public double convertToPound() {
		// 1 Indian Rupee equals approximately 0.010 GBP
		return rupee * 0.010;
	}


	public static void main(String[] args) {
		E9 converter = new E9(500); // 1000 Indian Rupees
		System.out.println("Amount in Rupee: " + converter.getRupee());
		System.out.println("Amount in Dollar: " + converter.convertToDollar());
		System.out.println("Amount in Pound: " + converter.convertToPound());
	}
}