import javax.swing.plaf.basic.BasicIconFactory;
import javax.swing.plaf.synth.SynthUI;

public class Main {

	public static void main(String[] args) {
		Secret s = new Secret();
		int[] pass = new int[16];
		int right = 0;
		while (true){
			int currVal = 0;
			if (right == 16){
				StringBuilder strTwo = new StringBuilder();
				for (int i : pass) {
					strTwo.append(i); //add all the ints to a string
				}
				System.out.println(strTwo);
				System.out.println(s.getSecret());
				break;
			}
			while(true){
				pass[right] = currVal;

				StringBuilder str = new StringBuilder();
				for (int i : pass) {
					 str.append(i);
				}

				long test = System.currentTimeMillis();
				s.verifyPassword(str.toString());
				long testTwo = System.currentTimeMillis();

				long timeDiff = testTwo-test;

				if (timeDiff <= (10*right)-6 || timeDiff >= (10*right)+6) {
					pass[right] = currVal;
					right++;
					currVal = 0;
					break;
				}else{
					currVal++;
				}
			}
		}
	}
}
