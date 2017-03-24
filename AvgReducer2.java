import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class AvgReducer2
  extends Reducer<Text, IntWritable, Text, IntWritable> {
	String temp = null;
private double calculateAverage(List <Integer> list) {
		  Integer sum = 0;
		  if(!list.isEmpty()) {
		    for (Integer i : list) {
		        sum += i;
		    }
		    return sum.doubleValue() / list.size();
		  }
		  return sum;
		}	
public void reduce(Text key, Iterable<IntWritable> values,
		      Context context)
		      throws IOException, InterruptedException {
		double avg;
		List<Integer> tempdata = new ArrayList<Integer>();
		 for (IntWritable value : values) {
		      tempdata.add(value.get());
		    }

		        avg=calculateAverage(tempdata);

		    context.write(key, new IntWritable((int)avg));
		  }




}
