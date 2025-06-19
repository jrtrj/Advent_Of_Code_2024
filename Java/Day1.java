import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileReader;

public class Day1 {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        String[] adjValues;
        try(var txtReader = new BufferedReader(new FileReader("../day1.txt"))) {
                String lines;
                while((lines = txtReader.readLine()) != null) {
                    adjValues = lines.split("\\s+");
                    list1.add(Integer.parseInt(adjValues[0]));
                    list2.add(Integer.parseInt(adjValues[1]));
                }
                list1.sort(null);
                list2.sort(null);
                //Total distance
                int sum = 0;
                for(int i = 0; i < list1.size(); i++) {
                   sum += Math.abs(list1.get(i) - list2.get(i)); 
                }
                System.out.println(sum);
                //Similarity score
                int sumCount = 0;
                for(int i = 0; i< list1.size();i++) {
                    int count = 0;
                    int element = list1.get(i); 
                    for(int j = 0; j< list2.size();j++) {
                        if(list2.get(j) == element)
                            count++;
                    }
                    sumCount += count*element;
                }
                System.out.println(sumCount);
            }
            catch(IOException e) {
                e.printStackTrace();
            }

    }
}
