import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Snake extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2570480595748705100L;
	/**
	 * @param position "蛇的位置，包括蛇头和蛇体"
	 */
	static boolean life=true;
	public	static int score;
	public	static int  Long=1; 
	int speed;
	
	//绘制蛇体方法
	public void drawSnake(Graphics g)
	{
		
		g.setColor(Color.BLACK);
		for(int i=0;i<Model.snake.size();i++){
		g.fillRect(Model.snake.get(i).point.x,Model.snake.get(i).point.y, General.x_width, General.y_height);
		}
	}
	//判定游戏是否继续/结束
	public void isAlive()
	{
		//蛇体是否接触容器的边界
		if(Model.snake.getFirst().point.x>=400||Model.snake.getFirst().point.y>=350
				||Model.snake.getFirst().point.x<0||Model.snake.getFirst().point.y<0)
			life=false;
		//调用迭代器 比较头结点 point值与蛇体其他元素值是否相等
		for(int i=1;i<Model.snake.size()-1;i++)
		{
			if(Model.snake.get(i).point.equals(Model.snake.getFirst().point))
				life=false;
		}
		
	}
	
}
