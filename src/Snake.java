import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Snake extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2570480595748705100L;
	/**
	 * @param position "�ߵ�λ�ã�������ͷ������"
	 */
	static boolean life=true;
	public	static int score;
	public	static int  Long=1; 
	int speed;
	
	//�������巽��
	public void drawSnake(Graphics g)
	{
		
		g.setColor(Color.BLACK);
		for(int i=0;i<Model.snake.size();i++){
		g.fillRect(Model.snake.get(i).point.x,Model.snake.get(i).point.y, General.x_width, General.y_height);
		}
	}
	//�ж���Ϸ�Ƿ����/����
	public void isAlive()
	{
		//�����Ƿ�Ӵ������ı߽�
		if(Model.snake.getFirst().point.x>=400||Model.snake.getFirst().point.y>=350
				||Model.snake.getFirst().point.x<0||Model.snake.getFirst().point.y<0)
			life=false;
		//���õ����� �Ƚ�ͷ��� pointֵ����������Ԫ��ֵ�Ƿ����
		for(int i=1;i<Model.snake.size()-1;i++)
		{
			if(Model.snake.get(i).point.equals(Model.snake.getFirst().point))
				life=false;
		}
		
	}
	
}
