package sudokueski;

import java.io.FileInputStream;

public class Dosya {
	public static int[][] dizi = new int[21][21];
	public static int[][] orijinalDizi;
	public static String s="";
	
	public void dosyaOku(String url) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(url);
			
			int deger;
			
			while((deger = fis.read()) != -1) {
				s+=(char)deger;
			}
			
			s = s.replace("*", "0");
            s = s.replace("\n", "");
            s = s.replace("\r", "");
            
            String[] a = s.split("\\B");
            
            int say1 = 0;
			for(int i = 0;i<21 ;i++) {
				for(int j=0;j<21;j++) {
					if(i<=5 || i>=15) {
						if(j==9) {
							j+=2;
						}
						else {
							dizi[i][j] = Integer.parseInt(a[say1]);
							say1++;
						}
					}
					else if(i>8 && i<=11) {
						if(j>5 && j<=14) {
							dizi[i][j] = Integer.parseInt(a[say1]);
							say1++;
						}
					}
					else {
						dizi[i][j] = Integer.parseInt(a[say1]);
						say1++;
					}
					 
				}
			}	
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		orijinalDizi = dizi;

	}
	
	public void matrisYazdir(int[][] matris) {
		for(int i = 0;i<21;i++) {
			for(int j=0;j<21;j++) {
				System.out.print(matris[i][j]);
			}
			System.out.println();
		}
	}
}