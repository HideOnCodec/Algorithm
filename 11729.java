import java.util.Scanner;
import java.io.*;
public class Main{
	public static StringBuilder show = new StringBuilder();
	int Min(int num) {
		if(num==1)return 1;
		return Min(num-1)*2+1;
	}

	void HanoiRoute(int num,int first,int mid,int end) {
		if(num==1) {
			show.append(first+" "+end+"\n");
			return;
		}
		HanoiRoute(num-1,first,end,mid);
		show.append(first+" "+end+"\n");
		HanoiRoute(num-1,mid,first,end);
		
	}
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		Main test = new Main();
		int num = scanner.nextInt();
		
		System.out.println(test.Min(num));
		test.HanoiRoute(num,1,2,3);
		System.out.println(show);
		
	}
}
