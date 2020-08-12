package programs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades ) {
        int ar[]=new int[grades.size()];
    for(int i=0;i<grades.size();i++){
        int g=grades.get(i);
         if(g<38){
            ar[i]=g;
            
        } 
       else{
        int b = g%5;
        if(b==0){

            ar[i]=g;
            
        }
        if(b!=0)
        { 
                int s= g/5;     
                s+=1;
                s= s*5; 
        

                int a = s-g;
       
                if(a==1 || a==2 ){
                    ar[i]=s;
                    
                }
                else{
                    ar[i]=g;
                    
                }
        }
        
    }
    }
    List<Integer> list = new ArrayList<>(); 
  
        // Iterate through the array 
        for (int t : ar) { 

            list.add(t); 
        } 
  
        
        return list; 
   

    }

}

public class sss {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
