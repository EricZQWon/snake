import java.awt.event.*;
public class GreedSnakeListenner extends KeyAdapter implements ActionListener{
	int towards;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		Model start=new Model();
		start.flag=false;
	}
	@Override 
	public void keyPressed(KeyEvent e)
	{
		int cmd=e.getKeyCode();
		switch (cmd) {
		case KeyEvent.VK_DOWN:	towards=2;
		if(!(towards+Model.snake.getFirst().direction==10))
		{
			Model.snake.getFirst().direction=towards;
		}
			
			break;
		case KeyEvent.VK_UP:	towards=8;
		if(!(towards+Model.snake.getFirst().direction==10))
		{
			Model.snake.getFirst().direction=towards;
		}
			
			break;

		case KeyEvent.VK_LEFT:	towards=4;
		if(!(towards+Model.snake.getFirst().direction==10))
		{
			Model.snake.getFirst().direction=towards;
		}
			
			break;
		case KeyEvent.VK_RIGHT:	towards=6;
		if(!(towards+Model.snake.getFirst().direction==10))
		{
			Model.snake.getFirst().direction=towards;
		}
			
			break;

		default:
			break;
		}
		new paint().repaint();
	}
}
