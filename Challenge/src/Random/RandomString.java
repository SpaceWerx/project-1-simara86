package Random;

import java.util.Random;

public class RandomString {
	public static void main(String[] args)    
    {        
      	String[] arr={"1", "2", "3", "4", "5"};
      	Random r=new Random();        
      	int randomNumber=r.nextInt(arr.length);
      	System.out.println(arr[randomNumber]);
    }

}
