package treeClasses;

public class Pair<E, F> {
	private E f;
		private F s;
		
	public Pair() {
		f = null;
			s = null;
	}
	
	public Pair(E f) {
		this.f = f;
			this.s = null;
	}
	
	public Pair(E f, F s) {
		this.f = f;
			this.s = s;
	}

	@Override
	public String toString() { return "(" + f + "," + s + ")"; }
	
	public E first() {	return f;	}
		public void setFirst(E nF) {this.f = nF;}

	public F second() {	return s;	}
		public void setSecond(F nS) {this.s = nS;}
	
}