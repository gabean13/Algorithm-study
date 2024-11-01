import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("-");
		
		List<Integer> list = new ArrayList<>();
		for(String str : input) {
			String[] nums = str.split("\\+");
			int temp = 0;
			for(String num : nums) {
				temp += Integer.parseInt(num);
			}
			list.add(temp);
		}
	
		int result = list.get(0);
		for(int i =1; i < list.size(); i++) {
			result -= list.get(i);
		}
		
		System.out.println(result);
	}
}