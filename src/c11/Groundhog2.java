package c11;

public class Groundhog2 extends Groundhog{
	public Groundhog2(int n) {
		super(n);
	}
	@Override
	public int hashCode() {
		return number;
	}
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Groundhog2 
				&& ((Groundhog2)obj).number == number);
	}
}
