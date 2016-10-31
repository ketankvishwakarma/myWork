package test;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WordMapper extends MapReduceBase implements 
Mapper<LongWritable, Text, Text, IntWritable>{

	@Override
	public void map(LongWritable key, Text value,OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		//convert into text
		String s = value.toString();
		for(String token : s.split(" "))
			if(token.length() > 0)
				output.collect(new Text(token), new IntWritable(1));
		
	}
}
