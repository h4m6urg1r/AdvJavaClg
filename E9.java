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
		return rupee * 0.012;
	}
	public double convertToPound() {
		return rupee * 0.0096;
	}
	public static void main(String[] args) {
		E9 converter = new E9(1000);
		System.out.println("Amount in Rupee: " + converter.getRupee());
		System.out.println("Amount in Dollar: " + converter.convertToDollar());
		System.out.println("Amount in Pound: " + converter.convertToPound());
	}
}