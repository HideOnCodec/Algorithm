import java.util.Scanner;
public class Main {
	
	int Search(int N) {
		int i=0;
		int count=0;
		while(true) {
			if(Integer.toString(i).contains("666")) {
				count++;
			}
			if(count==N)
				return i;
			i++;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Main Main = new Main();
		
		int N = sc.nextInt();
		
		System.out.println(Main.Search(N));
		sc.close();
	}

}
