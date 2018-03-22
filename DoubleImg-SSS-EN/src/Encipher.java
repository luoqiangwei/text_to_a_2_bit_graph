import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Encipher extends JFrame {
	// 14 * 16  可写 32 个字母
	public byte[] temp = new byte[224];
	public String w;
	public Encipher(){
		this.setBackground(Color.white);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1150, 1100);
		this.setUndecorated(true); 
		this.setVisible(true);
		// 要转化的文字
		w = "Now,I can use English~Year!~Soon"; 
		char[] t = w.toCharArray();
		char c;
		// 解构
		for(int i = 0; i < t.length && i < 32; i++){
			temp[7*i+6] = (byte) (t[i] & 0x1);
			temp[7*i+5] = (byte) ((t[i] & 0x2) >>> 1);
			temp[7*i+4] = (byte) ((t[i] & 0x4) >>> 2);
			temp[7*i+3] = (byte) ((t[i] & 0x8) >>> 3);
			temp[7*i+2] = (byte) ((t[i] & 0x10) >>> 4);
			temp[7*i+1] = (byte) ((t[i] & 0x20) >>> 5);
			temp[7*i+0] = (byte) ((t[i] & 0x40) >>> 6);
		}
		// 重构
		/*for(int i = 0; i < t.length && i < 32; i++){
			c = (char) ((temp[16*i+0] << 15) | (temp[16*i+1] << 14) | (temp[16*i+2] << 13) | (temp[16*i+3] << 12) | (temp[16*i+4] << 11) | (temp[16*i+5] << 10) | (temp[16*i+6] << 9) | (temp[16*i+7] << 8) | (temp[16*i+8] << 7) | (temp[16*i+9] << 6) | (temp[16*i+10] << 5) | (temp[16*i+11] << 4) | (temp[16*i+12] << 3) | (temp[16*i+13] << 2) | (temp[16*i+14] << 1) | (temp[16*i+15]));
			System.out.print(c);
		}*/
	}
	@Override
	public void paint(Graphics g){
		Random ra = new Random();// 随机色彩
		int x = 5;
		int y = 5;
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1150, 1100);
		ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + "\\1.jpg"); 
		Image img = icon.getImage(); 
		//g.drawImage(img, 5, 5, icon.getIconWidth(), icon.getIconHeight(), this);
		//g.drawImage(img, 5, 5, Cube.length * 32, Cube.length * 32, this);
		g.setColor(Color.YELLOW);
		g.drawLine(5, 5, 5 + Cube.length * 14,5);
		g.drawLine(5, 5, 5,5 + Cube.length * 16);
		g.drawLine(5, 5 + Cube.length * 16, 5 + Cube.length * 14,5 + Cube.length * 16);
		g.drawLine(5, 5, 5,5 + Cube.length * 14);
		g.drawLine(5 + Cube.length * 14, 5, 5 + Cube.length * 14, 5 + Cube.length * 16);
		//g.setColor(Color.BLACK);
		for(int i = 0; i < temp.length; i++){
			if(temp[i] == 1){
				g.setColor(new Color(Math.abs(ra.nextInt() % 200), Math.abs(ra.nextInt() % 200), Math.abs(ra.nextInt() % 200))); // 随机色彩
				g.fillRect(x, y, Cube.length, Cube.length);
				//g.fill3DRect(x, y, Cube.length, Cube.length, true);
				//g.fillArc(x, y, Cube.length, Cube.length, 0, 360);
				//g.fillOval(x, y, Cube.length, Cube.length);
				//g.fillRoundRect(x, y, Cube.length, Cube.length, Cube.length / 4, Cube.length / 4);
			}
			x += Cube.length;
			if(x == (5 + Cube.length * 14)){
				y += Cube.length;
				x = 5;
			}
		}
	}
}
