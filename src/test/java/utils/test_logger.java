package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class test_logger 
{
private static String logFileName;
public test_logger() 
{
	create_log_dir();
	// Only set logFileName once during construction
	if (logFileName == null) 
	{
	    String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
	    logFileName = "Logs/log_" + timestamp + ".txt";
	}
}
public void create_log_dir()
{
    File dir = new File("Logs");
    if (dir.exists() == false) 
    {
    dir.mkdir();
    }
}
public void log(String s) throws IOException, InterruptedException
{
	FileWriter log_writer = new FileWriter(logFileName, true);
	String logTimestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	String log_print = "["+logTimestamp+"] "+s+"\n";
	System.out.println(log_print);
	log_writer.append(log_print);
	log_writer.close();
}
}
