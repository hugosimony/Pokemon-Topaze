package fr.hugosimony.pokemontopaze.timer;

import java.util.TimerTask;

import fr.hugosimony.pokemontopaze.Variables;

public class GlobalTimer extends TimerTask {
	@Override
	public void run() {
		Variables.TIMER_Global++;
	}
	
	public static String getGoodPrintedTimer() {
		int minutes_ = (int) (Variables.TIMER_Global % 60);
		int hours_ = (int) (Variables.TIMER_Global / 60);
		String minutes = minutes_ + "";
		String hours = hours_ + "";
		if(hours_ < 10)
			hours = "0" + hours;
		if(minutes_ < 10)
			minutes = "0" + minutes;
		return hours + ":" + minutes;
	}
	
	public static String getGoodPrintedTimer(long time) {
		int minutes_ = (int) (time % 60);
		int hours_ = (int) (time / 60);
		String minutes = minutes_ + "";
		String hours = hours_ + "";
		if(hours_ < 10)
			hours = "0" + hours;
		if(minutes_ < 10)
			minutes = "0" + minutes;
		return hours + ":" + minutes;
	}
}
