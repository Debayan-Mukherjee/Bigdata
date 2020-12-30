package org;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class StockDriver {
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws IOException,ClassNotFoundException,IOException, Exception
	{
		Configuration conf=new Configuration();
		Job job=Job.getInstance(conf); //will explain later
		job.setJarByClass(StockDriver.class);
		job.setMapperClass(StockMapper.class);
		job.setReducerClass(StockReducer.class);
		
		//job.setCombinerClass(StockReducer.class);
		// in map reducer
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(DoubleWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setNumReduceTasks(1);
		
		FileInputFormat.addInputPath(job, new Path("stockdir"));
		FileOutputFormat.setOutputPath(job, new Path ("stockoutput"));
		
		try{
		job.waitForCompletion(true);//starting processing
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}	
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
