import java.util.Scanner;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(sc.nextLine());
			String sentences = sc.nextLine();
			StringTokenizer st = new StringTokenizer(sentences);
			int[] nameCount = new int[N];
			int nameCountIdx = 0;
			boolean isEnd = false;

			while (st.hasMoreTokens()) {
				String tok = st.nextToken();
				
				if (tok.endsWith(".") || tok.endsWith("!") || tok.endsWith("?")) {
					tok = tok.substring(0, tok.length()-1);
					isEnd = true;
				}
				
				if (Character.isUpperCase(tok.charAt(0))) {
					tok = tok.substring(1);
					boolean isName = true;

					for (int i = 0; i < tok.length(); i++) {
						if (Character.isLowerCase(tok.charAt(i))) {
							continue;
						} else {
							isName = false;
							break;
						}
					}
					
					if (isName) {
						nameCount[nameCountIdx]++;
					}
				} 
				if (isEnd) {
					nameCountIdx++;
					isEnd = false;
				}
			}
			
			StringBuilder result = new StringBuilder("#"+test_case+" ");
			for (int i = 0; i < N; i++) {
				result.append(nameCount[i]+" ");
			}
			System.out.println(result.toString());
			
		}
	}
}