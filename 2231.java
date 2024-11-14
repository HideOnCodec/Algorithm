import java.util.Scanner;


public class Main {
	
	int DisassembleSum(int N) {
		for(int i=0; i<N; i++) {
			int m1 = i/1000000;
			int m2 = (i-m1*1000000)/100000;
			int m3 = (i-m1*1000000-m2*100000)/10000;
			int m4 = (i-m1*1000000-m2*100000-m3*10000)/1000;
			int m5 = (i-m1*1000000-m2*100000-m3*10000-m4*1000)/100;
			int m6 = (i-m1*1000000-m2*100000-m3*10000-m4*1000-m5*100)/10;
			int m7 = i-m1*1000000-m2*100000-m3*10000-m4*1000-m5*100-m6*10;
			int sum = i + m1+m2+m3+m4+m5+m6+m7;
			if(sum==N)
				return i;
		}
		return 0;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Main Main = new Main();
		
		int N = scanner.nextInt();
		System.out.println(Main.DisassembleSum(N));
		
		scanner.close();
	}

}
