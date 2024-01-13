package sudokueski;

public class Thrters implements Runnable{
	Cozum c;
	int satirBas , sutunBas;
	String name;
	
	public Thrters(int satirBas, int sutunBas,String name) {
		this.satirBas = satirBas;
		this.sutunBas = sutunBas;
		this.name = name;
		c = new Cozum(this.satirBas,this.sutunBas);
	}
	
	@Override
	public void run() {
		try {
			System.out.println(name);
			c.ekle2(Dosya.dizi,name);
		} catch (Exception e) {
			
		}
	}

	
}
