package HW1;
import java.io.*;

public class CSX_358_HW1_16103036 {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Input File object
		FileReader input = new FileReader("src//HW1-data.txt");
		BufferedReader br = new BufferedReader(input);
		
		// Output file object
		File output = new File("src//HW1-output-16103036.txt");
		String headings;
		Writer writer;
		BufferedWriter bw = null;
		
		// Try Catch used to handle case of failure while opening file
		try {
			
			writer = new FileWriter(output);
			bw = new BufferedWriter(writer);
			headings = "Stdnt Id Ex ------- Assignments --------- Tot Mi Fin CL Pts Pct Gr";
			bw.write(headings + System.lineSeparator());
			headings = "-------- -- ----------------------------- --- -- --- -- --- --- --";
			bw.write(headings + System.lineSeparator());
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
     
		String line = "", outputline;
		Student st = new Student();
		
		// to store frquency of different gardes
		int numA = 0 ,numB = 0 ,numC = 0, numD = 0, numE = 0;
		int AveragePercentage = 0, students = 0;
		int MaxPoints = 0;
		int total = 0, points = 0, percentage = 0;
		char grade = '\0';
		
        try {
			while((line = br.readLine()) != null) {
				
				// Split string at spaces
				String[] arr = line.split(" ");
				
				// Different utility functions
				total = st.getTotal(arr, arr.length);
				points = total + Integer.parseInt(arr[1]) + Integer.parseInt(arr[12]) + Integer.parseInt(arr[13]) + Integer.parseInt(arr[14]);
			    percentage = st.getPercentage(points);
			    grade = st.getGrade(percentage);
			    
			    // Counting individual Gardes
			    if(grade == 'A') numA++;
			    else if(grade == 'B') numB++;
			    else if(grade == 'C') numC++;
			    else if(grade == 'D') numD++;
			    else numE++;
			    
			    // Calculating AveragePercentage and MaxPoints
			    AveragePercentage += percentage;
			    students++;
			    MaxPoints = Math.max(MaxPoints, points);
			    
			    outputline = "";
			    
			    // Part 1 : Preparing Report
			    for(int i=0; i<15; i++) {
			    	
			    	//  For alignment
			    	if((i >=2 && i <= 11) || i == 14) {
			    		if( arr[i].length() < 2 ) arr[i] = " " + arr[i];
			    	}else if(i == 13) {
			    		if( arr[i].length() < 3 )arr[i] = " " + arr[i];
			    	}
			    	
			    	outputline += arr[i] + " ";
			    	
			    	if(i == 11) {
			    		String tot = Integer.toString(total);
			    		if(tot.length() < 3) {
			    			tot = " " + tot;
			    		}
			    		outputline += tot + " ";
			    	}
			    }
			    
			    String pts = Integer.toString(points) , pct = Integer.toString(points);
			    if(pct.length() < 3) {
			    	pct = " " + pct;
			    }
			    outputline +=  pts + " " + pct + "  " + grade;
			    bw.write(outputline + System.lineSeparator());
			}
		
			// Part 2 : Summary 
			bw.write(System.lineSeparator() + "Average total point percent of all students = " + Math.round(AveragePercentage / students) + System.lineSeparator());
			bw.write("Number of A's = " + numA + System.lineSeparator() + "Number of B's = " + numB + System.lineSeparator() + "Number of C's = " + numC + System.lineSeparator() + "Number of D's = " + numD + System.lineSeparator() + "Number of E's = " + numE + System.lineSeparator());
			bw.write("Maximum points = " + MaxPoints);
			
			// Close
			bw.close();
			br.close();
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
     
	}

}
