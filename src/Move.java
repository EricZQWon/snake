import java.awt.Point;


public class Move {
	public 	Point point=new Point(19, 4);
	public	int direction=8;
	@SuppressWarnings("static-access")
	public Move(int x,int y,int d){
		this.point.x=x;
		this.point.y=y;
		this.direction=d;
	}
	public Move(){
		
	}
	public	void move_on()
	{
		
		Fruit fruit=new Fruit();
		Snake snake=new Snake();
		
		/*
		 * 对第一个元素即蛇头进行判断，根据所指方向对x,y坐标进行操作
		 * 完毕后重绘界面，达到动态移动效果
		 */
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				while(Snake.life){
					
					

					switch (Model.snake.getFirst().direction) {
					case 2:
						Model.snake.offerFirst(new Move(Model.snake.
								peek().point.x, Model.snake.peek().point.y+General.y_height,
								Model.snake.peek().direction));
						Model.snake.removeLast();
						break;
					case 8:
						Model.snake.offerFirst(new Move(Model.snake.
								peek().point.x, Model.snake.peek().point.y-General.y_height,
								Model.snake.peek().direction));
						Model.snake.removeLast();
						break;
					case 4:
						Model.snake.offerFirst(new Move(Model.snake.
								peek().point.x-General.x_width, Model.snake.peek().point.y,
								Model.snake.peek().direction));
						Model.snake.removeLast();
						break;
					case 6:
						Model.snake.offerFirst(new Move(Model.snake.
								peek().point.x+General.x_width, Model.snake.peek().point.y,
								Model.snake.peek().direction));
						Model.snake.removeLast();
						break;
					default:
						break;
					}
					//调用绘制方法进行重绘
					
					
							// TODO 自动生成的方法存根
					
							//对蛇体进行移动操作，即每一个节点都到了前一个节点的位置上
							
							
							/*	进行完移动操作之后判断一下是否吃到果子
							 * 如果被吃掉，则把果子的位置和赋值给read,将原头结点的方向赋值给read
							 * 最后将read插入snake头结点
							 */
							if(fruit.isEaten(Model.snake.getFirst().point))
							{
								Move r=new Move();
								r.point=fruit.location;
								r.direction=Model.snake.get(0).direction;
								Model.snake.offerLast(r);
								fruit.random();
								Model.main_paint.draw();
							}
					
					/*
					 * 判断是否撞墙或吃到身体（结束游戏）
					 */
					snake.isAlive();
					try {
						Model.main_paint.draw();
						Thread.sleep(General.sleep_time);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
					//move_on();
				}//while()
				System.err.println("游戏结束");
			}
		}).start();
	}//end move_on
}
