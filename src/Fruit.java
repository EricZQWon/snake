import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Fruit {
	/**
	 * @param location "果子的位置"
	 */
	static Point location=new Point((int)(Math.random()*40)*10, (int)(Math.random()*35)*10);
	public void random(){
		 location=new Point((int)(Math.random()*35)*10, (int)(Math.random()*30)*10);
	}
	public Fruit()
	{
		//随机产生果子的出现位置
		
		/*
		 * 用迭代器遍历一遍蛇体，检验果子与蛇体位置是否重叠，如果没有，则绘制
		 * 否则重新调用一遍构造函数产生新的位置
		 */
	}
	/*
	 * 判断果子是否被吃掉
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
	 * 绘制果子的方法
	 */
	public void drawFruit(Graphics g)
	{
		g.setColor(Color.RED);
		g.fillRect(location.x, location.y, General.x_width,General.y_height);
	
		
	}
}
