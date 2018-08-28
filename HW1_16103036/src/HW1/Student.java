package HW1;

public class Student {
     
	int getTotal(String[] arr, int n) {
		
		int total = 0;
		for(int i=2; i<12; i++) {
			total += Integer.parseInt(arr[i]);
		}
		return total;
	}
	
	int getPercentage(int n){
		return Math.round( (n * 100) / 420 );
	}
	
	char getGrade(int percentage) {
	
         if(percentage >= 90) return 'A';
         else if(percentage >= 78 && percentage <= 89) return 'B';
         else if(percentage >= 62 && percentage <= 77) return 'C';
         else if(percentage >= 46 && percentage <= 61) return 'D';
         else return 'E';
	}
}
