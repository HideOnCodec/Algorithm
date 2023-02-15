import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	char Wstart[][]= {{'W','B','W','B','W','B','W','B'},
					  {'B','W','B','W','B','W','B','W'},
					  {'W','B','W','B','W','B','W','B'},
  					  {'B','W','B','W','B','W','B','W'},
					  {'W','B','W','B','W','B','W','B'},
					  {'B','W','B','W','B','W','B','W'},
					  {'W','B','W','B','W','B','W','B'},
					  {'B','W','B','W','B','W','B','W'}};
	char Bstart[][]= {{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'},
						{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'},
						{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'},
						{'B','W','B','W','B','W','B','W'},
						{'W','B','W','B','W','B','W','B'}};
	int TestChess(int i,int j,char[][] chess) {
		int changeB=0,changeW=0;
		char test[][];
		test = Bstart.clone();
		for(int x=i;x<i+8; x++){
			for(int y=j; y<j+8; y++) {
				if(chess[x][y]!=test[x-i][y-j])
					changeB++;
			}	
		}
		test = Wstart.clone();
		for(int x=i;x<i+8; x++){
			for(int y=j; y<j+8; y++) {
				if(chess[x][y]!=test[x-i][y-j])
					changeW++;
			}	
		}
		return Math.min(changeW, changeB);
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine()," ");
		Main Main = new Main();
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		char[][] chess = new char[N][M];
		for(int i=0; i<N; i++)
			chess[i]=br.readLine().toCharArray();
		
		int min=2500;//최대값으로 설정 50*50
		int result;
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				result=Main.TestChess(i, j, chess);
				if(min>result)
					min=result;
			}
		}
		System.out.println(min);
	
	}

}
