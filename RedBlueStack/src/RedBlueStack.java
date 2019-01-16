/* Mark Schuberth
 * 
 * Implementation of two stacks, red and blue, that use the same array
 * The red and blue stacks have their own push and pop operations and grow
 * from opposite sides until there is no more room left in the stack causing
 * an overflow error. Each method runs in constant time O(1)
 * 10/8/2018
 */
public class RedBlueStack 
{
	int size;
	int redTop, blueTop;
	int Stack[];
	
	//RedBlueStack constructor that sets up the blue and red stacks to start on opposite sides of the array
	//red stack on the left and blue stack on the right to prevent overflow
	public RedBlueStack(int N)
	{
		Stack = new int[N];
		size = N;
		//when an element is pushed to redTop it will start at [0], when
		//the stack is empty it will have [] equal to N - 1
		redTop = -1;
		//when an element is pushed to blueTop it will start at [N - 1] or end of the array
		//which is equal to size of the array
		blueTop = size;
	}
	
	public void redPush(int x)
	{
		if(redTop < size - 1)
		{
			//the red stack grows and the index moves in from one side
			redTop++;
			Stack[redTop] = x;
			System.out.println("The number pushed to the red stack is " + x);
		}
		else if(redTop > size - 1)
		{
			System.out.println("Stack overflow error");
		}
	}
	
	public void bluePush(int x)
	{
		if(redTop < size - 1)
		{
			//the blue stack grows and the index moves in from the other side (n-1)
			//which allows for an efficient way for each stack to grow in from opposite
			//side of the same array
			blueTop--;
			Stack[blueTop] = x;
			System.out.println("The number pushed to the blue stack is " + x);
		}
		//if the stack is full and another element is pushed it will cause an overflow error
		//the code below lets the user know if there is an overflow error
		else if(redTop > size - 1)
		{
			System.out.println("Stack overflow error");
		}
	}

	public int redPop()
	{
		//due to LIFO the last element pushed into the red stack will be
		//the first element popped out of the red stack
		if(redTop >= 0)
		{
			int x = Stack[redTop];
			redTop--;
			System.out.println("The number popped from the red stack is " + x);
			return x;
		}
		//if an element is popped when the stack is empty it will cause an underflow error
		//the code below prevents an underflow error and lets the user know if there
		//is an underflow error
		else if(redTop < 0)
		{
			System.out.println("Stack underflow error");
		}
		return 0;
	}
	
	public int bluePop()
	{
		if(blueTop < size)
		{
			int x = Stack[blueTop];
			blueTop++;
			System.out.println("The number popped from the blue stack is " + x);
			return x;
		}
		else if(blueTop > size)
		{
			System.out.println("Stack underflow error");
		}
		return 0;
	}
	
	public static void main(String[] args)
	{
		System.out.println("One stack, Two stack, Red stack, Blue Stack!");
		System.out.println("--------------------------------------------");
		
		RedBlueStack RB = new RedBlueStack(100);
		RB.redPush(6);      //adds 6 to red stack
		RB.bluePush(1);     //adds 1 to blue stack
		RB.bluePush(5);     //adds 5 to blue stack
		RB.redPop();        //removes 6 from red stack
		RB.bluePush(9);    //adds 9 to blue stack
		RB.bluePop();     //removes 9 from blue stack
		RB.redPush(2);    //adds 2 to red stack
		RB.bluePush(3);  //adds 3 to blue stack
		RB.redPush(4);   //adds 4 to red stack
		RB.redPush(8);   //adds 8 to red stack
		RB.bluePush(7);   //adds 7 to blue stack
		RB.redPush(10);   //adds 10 to red stack
		RB.bluePop();     //removes 7 from blue stack
		RB.redPop();		//removes 10 from red stack
		RB.redPop();		//removes 8 from red stack
		RB.bluePop();	//removes 3 from blue stack
	}
}
