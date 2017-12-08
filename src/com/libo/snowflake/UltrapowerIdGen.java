package com.libo.snowflake;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * 神州泰岳id生成策略，模拟tiwer的snowFlake
 * 
 * long型id组成
 * startTime(39bit) + dataCenter(3bit) + machineNum(8bit) + businessID(5bit) + 预留(1bit) + sequenceBits(7bit)
 */
public class UltrapowerIdGen {

	/*
	 * 时间毫秒数(从2017-01-01 00:00:00.0000开始)设项目至少需要运行十年
	 * 10 * 365 * 24 * 60 * 60 * 1000 
	 * 大约2的39次方，因此39bit存放时间
	 */
	private long startTime = 1485878400241l ;
	
	//假设项目不会超过8个机房 因此机房数占3bit
	private long dataCenter = 1l;
	
	//假设每个机房不会超过200台机器,一次机器数占8bit
	private long machineNum ;
	
	//业务线小于30个，因此预留5bit作为业务线表示
	private long businessID ;
	
	//假设单机每秒不超过10w的并发量，既每毫秒的并发数不超过100，因此毫秒内的序列数占7bit
	private long sequence = 0l;
	
	// 上次生成id的时间截
	private long lastTimestamp ;
	
	
	
	public UltrapowerIdGen(long businessID) {
		this.businessID = businessID;
	}

	public synchronized long nextId(){
		long timestamp = timeGen();
		if(timestamp < lastTimestamp){
			throw new RuntimeException(String.format("服务器时间异常.  新产生的毫秒数比上一次的毫秒数小了%d 毫秒",timestamp));
		}
		
		// 表示是同一时间截内生成的id
		if(timestamp == lastTimestamp){
			sequence = (sequence + 1) & (-1L ^ (-1L << 7)); //7是sequenceBits占的位数
			// 说明当前时间生成的序列数已达到最大
			if (sequence == 0) {
				// 生成下一个毫秒级的序列
				timestamp = tilNextMillis();
				// 序列从0开始
				sequence = 0L;
			}
		}else {
			// 新的时间截，则序列从0开始
			sequence = 0L;
		}
		
		lastTimestamp = timestamp;
		System.out.println(Long.toBinaryString(timestamp - startTime)+"");
		System.out.println(Long.toBinaryString((timestamp - startTime) << 24)+"");
		System.out.println(Long.toBinaryString(dataCenter << 22)+"");
		System.out.println(Long.toBinaryString(machineNum << 14)+"");
		System.out.println(Long.toBinaryString(businessID << 9)+"");
		System.out.println(Long.toBinaryString(sequence)+"");
		
		return ((timestamp - startTime) << 24) //第一位是符号位
			   | (dataCenter <<  22)
			   | (machineNum << 14)
			   | (businessID << 9)
			   | sequence;
	}
	
	protected long tilNextMillis() {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}
	
	public long timeGen(){
		return System.currentTimeMillis();
	}
	
	public static void main(String[] args) {
		UltrapowerIdGen idWorker = new UltrapowerIdGen(1);
		long temp = idWorker.nextId();
		System.out.println(Long.toBinaryString(temp)+"");
		System.out.println(temp);
//		for (int i = 0; i < 1000; i++) {
//			System.out.println(idWorker.nextId());
//		}
	}
}
