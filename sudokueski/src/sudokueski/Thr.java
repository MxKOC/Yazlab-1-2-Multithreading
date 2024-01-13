package sudokueski;

public class Thr implements Runnable{
	Cozum c;
	int satirBas , sutunBas;
	String name;
	
	public Thr(int satirBas, int sutunBas,String name) {
		this.satirBas = satirBas;
		this.sutunBas = sutunBas;
		this.name = name;
		c = new Cozum(this.satirBas,this.sutunBas);
	}
	
	@Override
	public void run() {
		try {
			System.out.println(name);
			c.ekle1(Dosya.dizi,name);
		} catch (Exception e) {
			
		}
	}

	
}
