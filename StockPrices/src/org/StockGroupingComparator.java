package org;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class StockGroupingComparator extends WritableComparator
{

	public StockGroupingComparator()
	{
		super(SPKey.class,true); 
	}

	// this method will called on reducer
	// SPkey sp1=
	// SPKey sp2=
	// int c=compare(sp1,sp2)
	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		// TODO Auto-generated method stub
		SPKey key1=(SPKey)a;
		SPKey key2=(SPKey)b;
		String s1=key1.getStock();
		String s2=key2.getStock();
		int c=s1.compareTo(s2);
		return c;
	}
	
}
