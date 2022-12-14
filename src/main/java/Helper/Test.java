package Helper;

public class Test {

	public static void main(String[] args) {
		
		String s= "My name is Manish";
		String rev ="";
	   
	String s1[]=s.split(" ");
	
	int l= s1.length;
	System.out.println(l);
	
	 for(int i=l-1;i>=0;i--) {
		 
		 rev=rev+" "+
		 s1[i];
		 
		  
	 }
	 System.out.println(rev);

	}

}
