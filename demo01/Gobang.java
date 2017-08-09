//hah

import java.util.Scanner;

public class Gobang
{
	//棋盘的二维数组
	public static String[][] chesses = new String[16][16];

	//初始化棋盘每个元素赋值为*
	public static void init()
	{
		for (int row = 0; row < 16; row++) 
		{
			for (int col = 0; col < 16; col++) 
			{
				chesses[row][col] = "*";
			}
		}
	}


	public static void print()
	{
		//在列标的开头空出来一些
		System.out.print("  ");

		for (int index = 0; index < 16; index++) 
		{
			//打印列标的时候用 0-f 表示 int需要转成16进制以字符串输出
			System.out.print(Integer.toHexString(index) + "  ");	
		}
		System.out.println();


		//打印棋盘
		for (int row = 0; row < chesses.length; row++) 
		{
			//在打印棋盘的每一行之前先打印 行标
			System.out.print(Integer.toHexString(row) + " ");

			for (int col = 0; col < chesses[row].length; col++) 
			{
				System.out.print(chesses[row][col] + "  ");		
			}
			System.out.println();	
		}
	}



	public static boolean check(int xValue, int yValue)
	{
		return vertical(xValue,yValue) >= 5 || horizontal(xValue,yValue) >=5 || diagonalX(xValue,yValue) >= 5 || diagonalY(xValue,yValue) >= 5;
	}

	public static int vertical(int xValue, int yValue)
	{
		String chess = chesses[xValue][yValue];
		int count = 1;


		//上
		int Xtemp = xValue - 1;
		int Ytemp = yValue;

		while (Xtemp >= 0 && chess.equals(chesses[Xtemp][Ytemp])) 
		{
			count++;
			Xtemp--;	
		}


		//下
		int tempX = xValue + 1;
		int tempY = yValue;
		while (tempX <= 16 && chess.equals(chesses[tempX][tempY])) 
		{
			count++;
			tempX++;	
		}


		return count;
	}


	public static int horizontal(int xValue, int yValue)
	{
		String chess = chesses[xValue][yValue];
		int count = 1;


		//左
		int Xtemp = xValue;
		int Ytemp = yValue - 1;

		while (Ytemp >= 0 && chess.equals(chesses[Xtemp][Ytemp])) 
		{
			count++;
			Ytemp--;	
		}


		//右
		int tempX = xValue;
		int tempY = yValue + 1;
		while (tempY <= 16 && chess.equals(chesses[tempX][tempY])) 
		{
			count++;
			tempY++;	
		}


		return count;
	}



	public static int diagonalX(int xValue, int yValue)
	{
		String chess = chesses[xValue][yValue];
		int count = 1;


		//左上
		int Xtemp = xValue - 1;
		int Ytemp = yValue - 1;

		while (Xtemp >= 0 && Ytemp>=0 && chess.equals(chesses[Xtemp][Ytemp])) 
		{
			count++;
			Xtemp--;
			Ytemp--;	
		}


		//右下
		int tempX = xValue + 1;
		int tempY = yValue + 1;
		while (tempX <= 16 && tempY <=16 && chess.equals(chesses[tempX][tempY])) 
		{
			count++;
			tempX++;
			tempY++;	
		}


		return count;
	}



	public static int diagonalY(int xValue, int yValue)
	{
		String chess = chesses[xValue][yValue];
		int count = 1;


		//右上
		int Xtemp = xValue - 1;
		int Ytemp = yValue + 1;

		while (Xtemp >= 0 && Ytemp <=16 && chess.equals(chesses[Xtemp][Ytemp])) 
		{
			count++;
			Xtemp--;
			Ytemp++;	
		}


		//左下
		int tempX = xValue + 1;
		int tempY = yValue - 1;
		while (tempX <= 16 && tempY >= 0 && chess.equals(chesses[tempX][tempY])) 
		{
			count++;
			tempX++;
			tempY--;	
		}


		return count;
	}




	//测试
	public static void main(String[] args) 
	{
			Scanner in = new Scanner(System.in);

			String[] who = {"黑方","白方"};
			String[] whochess = {"@","#"};

			int whoCount = 0;

			init();

			while(true)
			{
				print();
				System.out.println("请" + who[whoCount % 2] + "落子：ps(坐标中间以空格分开)");
				//输入棋盘坐标 完成落子
				String x = in.next();
				String y = in.next();

				//将用户输入的坐标16进制 转为 10进制，定位棋盘的位置
				int xValue = Integer.valueOf(x,16);
				int yValue = Integer.valueOf(y,16);

				if("*".equals(chesses[xValue][yValue]))
				{
					chesses[xValue][yValue] = whochess[whoCount % 2];


					//落完子判断输赢
					if(check(xValue,yValue))
					{
						print();
						System.out.println(who[whoCount % 2] + "胜，游戏结束！");
						break;
					}

					whoCount ++;//写到这个循环里面，控制落子对象
				}
				else {
					System.out.println("此处已有人落子，请重新输入！！");
				}
				
			}
	}
}

