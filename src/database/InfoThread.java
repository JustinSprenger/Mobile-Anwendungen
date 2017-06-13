package database;

import javafx.scene.control.ProgressBar;

public class InfoThread implements Runnable {

	private long filesize;
	private int wait;
	private boolean run;
	
	InfoThread(int waitInMs)
	{
		this.filesize =0;
		this.wait = waitInMs;
		this.run = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(run)
		{
			System.out.println("status : " + this.filesize + " Byte");
			
			try{
				Thread.sleep(this.wait);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void stop()
	{
		this.run = false;
	}
	
	public void setFilesize(long fs)
	{
		this.filesize = fs;
	}

}
