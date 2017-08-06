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


	//测试
	public static void main(String[] args) 
	{
		Gobang.init();
		Gobang.print();
	}
}

