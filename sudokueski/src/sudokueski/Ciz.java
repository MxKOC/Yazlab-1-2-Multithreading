package sudokueski;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TimerTask;
import java.util.stream.Collectors;

public class Ciz
{
	private final int width = 1888;
	private final int height = 1077;

	private final JPanel panel;

	public Ciz()
	{
		JFrame frame = new JFrame();
		frame.setTitle("Yazlab ");
		frame.setSize(width, height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel()
		{
			@Override
			protected void paintComponent(Graphics g)
			{
				super.paintComponent(g);

				Graphics2D g2d = (Graphics2D) g;
				g2d.setStroke(new BasicStroke(2));
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

				draw(g2d);
			}
		};

		panel.setOpaque(false);
		frame.add(panel);

		frame.setVisible(true);

		Timer cizimGuncelleme = new Timer(50, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				panel.repaint();
			}
		});

		cizimGuncelleme.start();
	}



	private void draw(Graphics2D g)
	{

            g.setColor(Color.YELLOW);
                 Font currentFont = g.getFont();
                 Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.6F);
                 g.setFont(newFont);
            
            
            g.drawLine(1300, 200, 1300, 400);
            g.drawLine(1300, 400, 1500, 400);
            
            g.drawLine(1380, 400, 1380, (int) (400-Main.basla));
            g.drawLine(1350, 400, 1350, (int) (400-Main.bitir));
            
                g.drawString(String.format(" %d ", Main.basla), 800, 850);
                g.drawString(String.format(" %d ", Main.bitir), 800, 890);
                 
                 
            g.drawLine(1300, 500, 1300, 700);
            g.drawLine(1300, 700, 1500, 700);
            for (int i = 1; i < 6; i++) {
                g.drawLine(1350+(i)*10, 700, 1350+(i)*10, 700-Main.dizisay[i]+50);
            }
            
            
            
            g.drawLine(1600, 500, 1600, 700);
            g.drawLine(1600, 700, 1800, 700);
            for (int i = 0; i < 6; i++) {
                g.drawLine(1600+(i)*10, 700, 1600+(i)*10, 700-Main.dizisay2[i]);
            }
            
            
            
            
            
            
            
            
            
            
            
               for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                        
                 if(i<=5 || i>=15) {
						if(j==9) {
							j+=2;
						}
						else {
                                                      g.drawString(String.format(" %d ", Dosya.dizi[i][j]), 200+i*20, 200+j*20);
						}
					}
					else if(i>8 && i<=11) {
						if(j>5 && j<=14) {
                                                    g.drawString(String.format(" %d ", Dosya.dizi[i][j]), 200+i*20, 200+j*20);
						}
					}
					else {
                                                    g.drawString(String.format(" %d ", Dosya.dizi[i][j]), 200+i*20, 200+j*20);
					}

                
            }    
                   
            }
            
            
	}
}