package org;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Partitioner;


public class StockPartitioner extends Partitioner<SPKey,DoubleWritable>
{

	public int getPartition(SPKey key, DoubleWritable value, int no_of_partitioner) 
	{
		// TODO Auto-generated method stub
		int rem=key.getStock().hashCode() % no_of_partitioner;
		return rem;
	}

	
}
