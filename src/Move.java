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
		 * �Ե�һ��Ԫ�ؼ���ͷ�����жϣ�������ָ�����x,y������в���
		 * ��Ϻ��ػ���棬�ﵽ��̬�ƶ�Ч��
		 */
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
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
					//���û��Ʒ��������ػ�
					
					
							// TODO �Զ����ɵķ������
					
							//����������ƶ���������ÿһ���ڵ㶼����ǰһ���ڵ��λ����
							
							
							/*	�������ƶ�����֮���ж�һ���Ƿ�Ե�����
							 * ������Ե�����ѹ��ӵ�λ�ú͸�ֵ��read,��ԭͷ���ķ���ֵ��read
							 * ���read����snakeͷ���
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
					 * �ж��Ƿ�ײǽ��Ե����壨������Ϸ��
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
				System.err.println("��Ϸ����");
			}
		}).start();
	}//end move_on
}
