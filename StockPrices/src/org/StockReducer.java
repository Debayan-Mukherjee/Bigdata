package org;


import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class StockReducer extends Reducer<Text,DoubleWritable,Text,Text>
{
	private Text outval=new Text();
	@Override
	protected void reduce(Text key, Iterable<DoubleWritable> values,
				Context context)
			throws IOException, InterruptedException {
		//int sum=0;
		StringBuilder sb=new StringBuilder();
		for(DoubleWritable v:values)
		{
			sb.append(v);
			sb.append(",");
			//sum=sum+val.get();
		}
		outval.set(sb.toString());
		context.write(key, outval);
	}

}
