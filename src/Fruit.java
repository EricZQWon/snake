import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Fruit {
	/**
	 * @param location "���ӵ�λ��"
	 */
	static Point location=new Point((int)(Math.random()*40)*10, (int)(Math.random()*35)*10);
	public void random(){
		 location=new Point((int)(Math.random()*35)*10, (int)(Math.random()*30)*10);
	}
	public Fruit()
	{
		//����������ӵĳ���λ��
		
		/*
		 * �õ���������һ�����壬�������������λ���Ƿ��ص������û�У������
		 * �������µ���һ�鹹�캯�������µ�λ��
		 */
	}
	/*
	 * �жϹ����Ƿ񱻳Ե�
	 */
	public boolean isEaten(Point xPoint)
	{
		if(location.x==xPoint.x&&location.y==xPoint.y)
		{
			Snake.Long+=1;
			
		}
		return location.equals(Model.snake.getFirst().point);
	}
	/*
	 * ���ƹ��ӵķ���
	 */
	public void drawFruit(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(location.x, location.y, General.x_width,General.y_height);
	
		
	}
}
