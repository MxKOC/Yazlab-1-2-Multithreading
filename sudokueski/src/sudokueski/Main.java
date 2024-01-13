package sudokueski;


import java.awt.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	static boolean kNoktaDoluMu=false;
        static long  basla;
        static long  bitir;
        public static int[] dizisay = new int[100];
        public static int[] dizisay2 = new int[100];
	public static void main(String[] args) throws Exception {
		Dosya d = new Dosya();
		String url = "C:\\Users\\Muhammed KOÇ\\Documents\\NetBeansProjects\\sudokueski\\src\\sudokueski\\nokta.txt";
		d.dosyaOku(url);
		
                new Ciz();


                  Thread threadx = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int xxx=0;
                        while(xxx<30){
                            int dolu=0;
                        for (int i = 0; i < 21; i++) {
                            for (int j = 0; j < 21; j++) {
                                if(Dosya.dizi[i][j]!=0)
                                    dolu++;
                                    
                            }
 
                        }
                        xxx++;
                        System.out.println("---->"+dolu+"aaaaaaaaaaa");
                        dizisay[xxx]=dolu;

                            try {
                                Thread.sleep(10);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }

                    }
                    }
                });
                
                  
                    Thread thready = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int xxx=0;
                        while(xxx<30){
                            int dolu=0;
                        for (int i = 0; i < 21; i++) {
                            for (int j = 0; j < 21; j++) {
                                if(Dosya.dizi[i][j]!=0)
                                    dolu++;
                                    
                            }
 
                        }
                        xxx++;
                        System.out.println("---->"+dolu+"sssssssssss");
                        dizisay2[xxx]=dolu;



                    }
                    }
                });
                  
                  
		
		int[][] d2 = Dosya.dizi;
		d.matrisYazdir(d2);
		System.out.println();
		
		int[][] kritikNokta1 = new int[][] {
			{6,6},{6,7},{6,8},{7,6},{7,7},{7,8},{8,6},{8,7},{8,8}
		};
		
                
                
                
                
                
                
                long start1 = System.currentTimeMillis();
                threadx.start();
                
                //Ister1();
                
		long  end1 = System.currentTimeMillis();     
                basla= end1-start1;
                
                

	
                long start2 = System.currentTimeMillis();
                thready.start();

                Ister2();                
                
                long  end2 = System.currentTimeMillis();     
                bitir= end2-start2;

        
                
        }
         
        
        
	private static void Ister1() throws InterruptedException {
		Thr thr1 = new Thr(0,0,"t1");
		Thread t1 = new Thread(thr1);
                 
		Thr thr2 = new Thr(0,12,"t2");
		Thread t2 = new Thread(thr2);
		
		
		Thr thr4 = new Thr(12,0,"t4");
		Thread t4 = new Thread(thr4);
                         
		Thr thr5 = new Thr(12,12,"t5");
		Thread t5 = new Thread(thr5);
		
		t1.start();
        t2.start();
        t4.start();
        t5.start();


        t1.join();
        t2.join();
        t4.join();
        t5.join();
        
        Dosya.dizi = Dosya.orijinalDizi;
	}
	
	private static void Ister2() throws InterruptedException{
		Thr thr1 = new Thr(0,0,"t1");
		Thread t1 = new Thread(thr1);
        Thrters thr1_1 = new Thrters(8,8,"t1_1");
		Thread t1_1 = new Thread(thr1_1);
                 
		Thr thr2 = new Thr(0,12,"t2");
		Thread t2 = new Thread(thr2);
        Thr thr2_2 = new Thr(8,20,"t2");
		Thread t2_2 = new Thread(thr2_2);
		
		
		Thr thr4 = new Thr(12,0,"t4");
		Thread t4 = new Thread(thr4);
        Thr thr4_4 = new Thr(20,8,"t4");
		Thread t4_4 = new Thread(thr4_4);
                         
		Thr thr5 = new Thr(12,12,"t5");
		Thread t5 = new Thread(thr5);
		Thr thr5_5 = new Thr(20,20,"t5");
		Thread t5_5 = new Thread(thr5_5);
		
		t1.start();
        t1_1.start();
        t2.start();
        t2_2.start();
        t4.start();
        t4_4.start();
        t5.start();
        t5_5.start();


        t1.join();
        t1_1.join();
        t2.join();
        t2_2.join();
        t4.join();
        t4_4.join();
        t5.join();
        t5_5.join();
	}
                
                
}
