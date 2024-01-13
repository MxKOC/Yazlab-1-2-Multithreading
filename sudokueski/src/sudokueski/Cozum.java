package sudokueski;

public class Cozum {
private static final int BOYUT = 9;//Tablonun kaÃ§a kaÃ§ olduÄŸu belirtiliyor.
	Object lock1 = new Object();
        Object lock2 = new Object();
	private int[][] sudoku;
	private int satirBas;
	private int sutunBas;
	
	public Cozum() {
		
	}
	
	public Cozum(int satirBas,int sutunBas) {
		this.satirBas = satirBas;
		this.sutunBas = sutunBas;
	}
		
	public Cozum(int[][] sudoku,int satirBas,int sutunBas) {
		this.sudoku = sudoku;
		this.satirBas = satirBas;
		this.sutunBas = sutunBas;
		
	}

        
        
        public synchronized void ekle1(int[][] sudoku,String name) throws InterruptedException {
            
            sudokuCoz(Dosya.dizi,name);
            
            
        }
        
        
        public synchronized void ekle2(int[][] sudoku,String name) throws InterruptedException {
            
            sudokuCoz(Dosya.dizi,name);
            
            
        }
        
        
        
        
        
        
	public void yazdir(int[][] sudoku) {
		for(int i=0;i<BOYUT;i++) {
			for(int j=0;j<BOYUT;j++) {
				System.out.print(sudoku[i][j]);
			}
			System.out.println();
		}
	}

	//NumaranÄ±n bulunduÄŸu satÄ±rda arama yapar.
	private boolean satirdaAra(int[][] sudoku, int numara , int satir) {
		for(int i = sutunBas;i<BOYUT+sutunBas ;i++) {
			if(sudoku[satir][i] == numara) {
				return true;
			}
		}
		return false;
	}
	
	//NumaranÄ±n bulunduÄŸu sÃ¼tÃ¼nda arama yapar.
	private boolean sutundaAra(int[][] sudoku, int numara , int sutun) {
		for(int i = satirBas;i<BOYUT+satirBas ;i++) {
			if(sudoku[i][sutun] == numara) {
				return true;
			}
		}
		return false;
	}
	///////////////////////OSMAN EKLEDİ
	private boolean tersSatirdaAra(int[][] sudoku, int numara , int satir) {
		for(int i = sutunBas-8;i<sutunBas+1;i++) {
			if(sudoku[satir][i] == numara) {
				return true;
			}
		}
		return false;
	}
	//////////////////////OSMAN EKLEDİ
	private boolean tersSutundaAra(int[][] sudoku, int numara , int sutun) {
		for(int i = satirBas-8;i<satirBas+1 ;i++) {
			if(sudoku[i][sutun] == numara) {
				return true;
			}
		}
		return false;
	}
	
	
	//NumaranÄ±n bulunduÄŸu 3x3 kutucukta arama yapar.
	private boolean kutudaAra(int[][] sudoku, int numara , int satir,int sutun) {
		// NumaranÄ±n bulunduÄŸu 3x3 lÃ¼k kutunun sol Ã¼st noktasÄ±nÄ±n koordinatlarÄ±nÄ± buluyoruz.
		int localBoxsatir = satir - satir%3;
		int localBoxsutun = sutun - sutun%3;
		
		for(int i = localBoxsatir;i<localBoxsatir+3;i++) {
			for(int j = localBoxsutun ; j<localBoxsutun+3;j++) {
				if(sudoku[i][j] == numara) {
					return true;
				}
			}
		}
		return false;
	}
	
        //NumaranÄ±n bulunduÄŸu 3x3 kutucukta arama yapar.
	private boolean terskutudaAra(int[][] sudoku, int numara , int satir,int sutun) {
		// NumaranÄ±n bulunduÄŸu 3x3 lÃ¼k kutunun sol Ã¼st noktasÄ±nÄ±n koordinatlarÄ±nÄ± buluyoruz.
		int localBoxsatir = satir - satir%3;
		int localBoxsutun = sutun - sutun%3;
		
		for(int i = localBoxsatir;i<localBoxsatir+3;i++) {
			for(int j = localBoxsutun ; j<localBoxsutun+3;j++) {
				if(sudoku[i][j] == numara) {
					return true;
				}
			}
		}
		return false;
	}
        
        
	//SatÄ±rda arama , sÃ¼tÃ¼nda arama ve 3x3 kutucukta arama kodlarÄ±nÄ±n birleÅŸtirildiÄŸi metot
	private  boolean yerlesirMi(int[][] sudoku, int numara , int satir,int sutun) {
		if(!satirdaAra(sudoku, numara, satir) 
			&& !sutundaAra(sudoku, numara, sutun)
			&& !kutudaAra(sudoku, numara, satir, sutun)) {
			return true;
		}
		return false;
	}
	/////////////////////OSMAN EKLEDİ
	private  boolean tersYerlesirMi(int[][] sudoku, int numara , int satir,int sutun) {
		if(!tersSatirdaAra(sudoku, numara, satir) 
			&& !tersSutundaAra(sudoku, numara, sutun)
			&& !terskutudaAra(sudoku, numara, satir, sutun)) {
			return true;
		}
		return false;
	}
	
	//Ã‡Ã¶zÃ¼m metodu
	public boolean sudokuCoz(int[][] sudoku,String name) throws InterruptedException {
            
            //synchronized(lock2){
            
		for(int i=satirBas;i<BOYUT+satirBas;i++) {
			for(int j=sutunBas;j<BOYUT+sutunBas;j++) {
				if(sudoku[i][j] == 0) {
					for(int denenecekDeger = 1;denenecekDeger<=BOYUT;denenecekDeger++) {
						if(yerlesirMi(sudoku, denenecekDeger, i, j)) {
							sudoku[i][j] = denenecekDeger;
							
							
                                                        
                                                        if(sudokuCoz(sudoku,name)) {
							
                                                            return true;
							}
							else{
								sudoku[i][j] = 0;
							}
						}
					}
					
					return false;
				}
				
				
			}
		}
		return true;
	
	}
        
        
        
        
        
        
        
        
        
        
        	//Ã‡Ã¶zÃ¼m metodu 2222222222222
	public boolean sudokuCoz2(int[][] sudoku,String name) throws InterruptedException {
		
            //synchronized(lock1){
            
            for(int i=satirBas;i>=0;i--) {
			for(int j=sutunBas;j>=0;j--) {
                System.out.println("name : "+i+"  "+j);
				if(sudoku[i][j] == 0) {
					for(int denenecekDeger = 1;denenecekDeger<=BOYUT;denenecekDeger++) {
						if(tersYerlesirMi(sudoku, denenecekDeger, i, j)) {
							sudoku[i][j] = denenecekDeger;
							Dosya.dizi[i][j] = denenecekDeger;
							//System.out.println("Atandı : "+i+","+j);
                                                        
							
                                                        
                            if(sudokuCoz2(sudoku,name)) {
                            	return true;
							}
							else{
								sudoku[i][j] = 0;
								Dosya.dizi[i][j] = 0;

							}
						}
					}
					
					return false;
				}
				
				
			}
		}
		return true;
	
            
            }
        
        

        
}


