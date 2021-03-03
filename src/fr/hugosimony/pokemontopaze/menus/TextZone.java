package fr.hugosimony.pokemontopaze.menus;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.Const;
import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.sounds.Sounds;

public class TextZone extends JPanel {
	private static final long serialVersionUID = 1L;

	public static Game game;
	public static TextZone textZone;
	
	private Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
	
	private int labelIndex;
	private int labelIndex2;
	private JLabel label1;
	private JLabel label2;
	
	private ArrayList<JLabel> texts;
	private String[] textLines;
	private String waitingText;
	
	public TextZone(JPanel panel, String text) {
		
		setOpaque(true);
		setLayout(null);
		setVisible(true);
		game.repaint();
		labelIndex = 0;
		labelIndex2 = 0;
		texts = new ArrayList<JLabel>();
		label1 = new JLabel("");
		label1.setLocation(35, 30);
		label1.setSize(700,30);
		label1.setFont(textFont); 
		add(label1);
		texts.add(label1);
		//************************************************
		
		label2 = new JLabel("");
		label2.setLocation(35, 60);
		label2.setSize(700,30);
		label2.setFont(textFont); 
		add(label2);
		texts.add(label2);
		textLines = text.split("\n");
		waitingText = "";
		if(textLines.length > 2)
			waitingText = text.replaceFirst(getTwoFirstLines(textLines), "");
		resetSpeachsLabel(textLines.length);
		Timer timer = new Timer();
		timer.schedule(new PrintText(panel), 0, (long) Variables.SPEED_TEXT);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Const.textZone.getImage(), 0, 0, null);
	}
	
	public static void printTextZone(TextZone textZone, Game game) {
		TextZone.textZone = textZone;
		game.inTextMenu = true;
		textZone.setVisible(false);
		textZone.setLocation(45, 420);
		textZone.setSize(700,122);
		textZone.setVisible(true);
		game.gamePanel.add(textZone);
		textZone.setVisible(false);
		textZone.setLocation(45, 420);
		textZone.setSize(700,122);
		textZone.setVisible(true);
		game.gamePanel.add(textZone);
	}
	
	public static void unprintTextZone() {
		textZone.setVisible(false);
		game.inTextMenu = false;
		game.textWaiting = false;
		game.textDone = false;
	}

	public class PrintText extends TimerTask {
		
		private JPanel panel;
		private boolean sound;
		
		public PrintText(JPanel panel) {
			this.panel = panel;
			sound = false;
		}
		
		@Override
        public void run() {
			if(!sound) {
				sound = true;
				Sounds.playSound(Const.soundSelectionMenu);
			}
	 		if(labelIndex < texts.size()) {
	 			if(labelIndex2 < textLines[labelIndex].length() && (""+textLines[labelIndex].charAt(labelIndex2)).equals("=")){
	 				labelIndex2++;
	 				game.textWaiting = true;
	 				this.cancel();
	 			}
	 			else if(labelIndex2 < textLines[labelIndex].length() && (""+textLines[labelIndex].charAt(labelIndex2)).equals("£")){
	 				game.textWaiting = true;
	 				game.textDone = true;
	 				YesNo.yesNo = new YesNo(true);
    				YesNo.printYesNoMenu();
	 				this.cancel();
	 			}
	 			else {
	 				if(labelIndex2 < textLines[labelIndex].length()) {
	 					texts.get(labelIndex).setText(texts.get(labelIndex).getText() + textLines[labelIndex].charAt(labelIndex2));
	 					labelIndex2++;
	    	 		}
	    	 		else {
	    	 			labelIndex++;
	    	 			labelIndex2 = 0;
	    	 		}
	 			}
	 		}
	 		else {
	 			if(!game.textDone) {
	 				if(game.waitingSave) {
	 					if(game.waitingSaveDone) {
		 					Sounds.playSound(Const.soundSave);
	 						game.textWaiting = true;
		 					game.textDone = true;
		 					game.waitingSave = false;
		 					textZone.setText(SaveMenu.savedText);
							TextZone.printTextZone(textZone, game);
	 					}
	 					else
	 						new Timer().schedule(new PrintText(panel), 1000, (long) Variables.SPEED_TEXT);
	 				}
	 				else {
	 					if(waitingText.equals("")){
		 					game.textWaiting = true;
		 					game.textDone = true;
	 					}
	 					else {
		 					textZone.setText(waitingText);
							TextZone.printTextZone(textZone, game);
	 					}
	 				}
	 			}
	 			else {
	 				game.inTextMenu = false;
	 				game.textWaiting = false;
	 				game.textDone = false;
	 				textZone.setVisible(false);
	 				if(game.waitingSaveDone) {
	 					game.waitingSaveDone = false;
	 					SaveMenu.unprintSaveMenu();
	 				}
	 			}
	 			this.cancel();
	 		}
        }
	}
	
	public void resetSpeachsLabel(int x) {
		labelIndex = 0;
		labelIndex2 = 0;
		for(JLabel label : texts)
			label.setText("");
		texts.clear();
		texts.add(label1);
		if(x > 1)
			texts.add(label2);
	}
	
	public void setText(String text) {
		game.inTextMenu = true;
		game.textWaiting = false;
		game.textDone = false;
		textLines = text.split("\n");
		waitingText = "";
		if(textLines.length > 2)
			waitingText = text.replaceFirst(getTwoFirstLines(textLines), "");
		resetSpeachsLabel(textLines.length);
		Timer timer = new Timer();
		timer.schedule(new PrintText(game.gamePanel), 0, (long) Variables.SPEED_TEXT);
	}
	
	public String getTwoFirstLines(String[] textLines) {
		return textLines[0] + "\n" + textLines[1] + "\n";
	}
	
}
