package fr.hugosimony.pokemoncancer.intro;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.hugosimony.pokemoncancer.Const;
import fr.hugosimony.pokemoncancer.Game;
import fr.hugosimony.pokemoncancer.Main;
import fr.hugosimony.pokemoncancer.Settings;
import fr.hugosimony.pokemoncancer.Variables;
import fr.hugosimony.pokemoncancer.maps.Direction;
import fr.hugosimony.pokemoncancer.maps.houses.selenia.MyHouse;
import fr.hugosimony.pokemoncancer.sounds.Sounds;

public class PresentationProf extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Game game;
	
	private Font speachFont = new Font("Comic Sans MS", Font.ITALIC, 20);
	private Font nameFont = new Font("Comic Sans MS", Font.BOLD, 25);
	
	private ArrayList<JLabel> speachs = new ArrayList<JLabel>();

	private String speach = "Bonjour ! Mon nom est Chen, Eliot Chen.=\n"
			+ 	"Bienvenue dans le monde des pokémons !=\n"
			+ 	"Tu ne sais surement pas pourquoi tu es ici.=\n"
			+ 	"En réalité, moi non plus...= Mais ta mère\n"
			+ 	"veut absolument que tu te lances dans une\n"
			+ 	"aventure.= Peut être qu'elle ne peut plus\n"
			+ 	"supporter ta présence.= Mais bon...= j'aime\n"
			+ 	"quand même bien ta mère si tu vois ce que\n"
			+ 	"je veux dire...= Hum hum,= mais je divague.=\n"
			+ 	"Avant que je t'introduise au monde dans\n"
			+ 	"lequel tu t'apprêtes à entrer, j'aimerais\n"
			+ 	"un peu plus te connaître != Premièrement,\n"
			+ 	"quel est ton prénom ?\n";
	
	private String speach2 = "Parfait changenamehere.= Tu es donc fin\n"
			+ 	"prêtreplacelangfemininhere pour commencer ton aventure != Dans\n"
			+ 	"celle-ci, tu va découvrir des pokémons, des\n"
			+ 	"gens et faire des rencontres uniques !=\n"
			+ 	"Tout d'abord, tu vas enfin sortir un peu\n"
			+ 	"de ta chambre et marcher jusqu'à mon\n"
			+ 	"laboratoire.= Tes copains t'ont surement\n"
			+ 	"spoil ce qu'il y aura...= Bref, il est enfin\n"
			+ 	"temps que je te laisse retourner dans ta\n"
			+ 	"chambre.= Par contre, ne glande pas trop.=\n"
			+ 	"Je veux pas t'attendre un an non plus.=\n"
			+ 	"Prépare toi à entrer dans le monde des\n"
			+ 	"Pokémons !\n";
	
	private String[] speachLines = speach.split("\n");
	
	private JLabel presentationLabel1;
	private JLabel presentationLabel2;
	private JLabel presentationLabel3;
	private JLabel presentationLabel4;
	private JLabel presentationLabel5;
	private JLabel presentationLabel6;
	private JLabel presentationLabel7;
	private JLabel presentationLabel8;
	private JLabel presentationLabel9;
	private JLabel presentationLabel10;
	private JLabel presentationLabel11;
	private JLabel presentationLabel12;
	private JLabel presentationLabel13;

	private boolean introProf;
	private boolean introProfWaiting;
	private boolean introProfDone;
	private boolean nameQuestion;
	private boolean nameDone;
	private boolean sexQuestion;
	private boolean sexDone;
	private boolean lastSpech;
	private int introLabelIndex;
	private int introLabelIndex2;
	
	private JTextField nameArea;
	private JButton validateName;
	private String waitingName;

	private Boy boy;
	private Girl girl;
	private JButton boyButton;
	private JButton girlButton;
	private String waitingSex;
	private BoyGirl boyGirl;
	
	private JButton Yes;
	private JButton No;
	
	private Clip clipStartingTheme;
	
	public PresentationProf(Game game) {
		
		this.game = game;
		
		introProf = true;
		introProfWaiting = false;
		introProfDone = false;
		introLabelIndex = 0;
		introLabelIndex2 = 0;
		nameQuestion = false;
		nameDone = false;
		sexQuestion = false;
		lastSpech = false;
		
		//****************************************************************************************************
	    // Components
		
		setBackground(Const.gameSelectorMenuColor);
		setLayout(null);
		
		//****************************************************************************************************
	    // Speach
		
		presentationLabel1 = new JLabel("");
		presentationLabel1.setLocation(325, 60);
		presentationLabel1.setSize(410,30);
		presentationLabel1.setFont(speachFont); 
		add(presentationLabel1);
		//************************************************
		speachs.add(presentationLabel1);
		presentationLabel2 = new JLabel("");
		presentationLabel2.setLocation(325, 90);
		presentationLabel2.setSize(400,30);
		presentationLabel2.setFont(speachFont); 
		add(presentationLabel2);
		//************************************************
		speachs.add(presentationLabel2);
		presentationLabel3 = new JLabel("");
		presentationLabel3.setLocation(325, 120);
		presentationLabel3.setSize(400,30);
		presentationLabel3.setFont(speachFont); 
		add(presentationLabel3);
		//************************************************
		speachs.add(presentationLabel3);
		presentationLabel4 = new JLabel("");
		presentationLabel4.setLocation(325, 150);
		presentationLabel4.setSize(400,30);
		presentationLabel4.setFont(speachFont); 
		add(presentationLabel4);
		//************************************************
		speachs.add(presentationLabel4);
		presentationLabel5 = new JLabel("");
		presentationLabel5.setLocation(325, 180);
		presentationLabel5.setSize(400,30);
		presentationLabel5.setFont(speachFont); 
		add(presentationLabel5);
		//************************************************
		speachs.add(presentationLabel5);
		presentationLabel6 = new JLabel("");
		presentationLabel6.setLocation(325, 210);
		presentationLabel6.setSize(400,30);
		presentationLabel6.setFont(speachFont); 
		add(presentationLabel6);
		//************************************************
		speachs.add(presentationLabel6);
		presentationLabel7 = new JLabel("");
		presentationLabel7.setLocation(325, 240);
		presentationLabel7.setSize(400,30);
		presentationLabel7.setFont(speachFont); 
		add(presentationLabel7);
		//************************************************
		speachs.add(presentationLabel7);
		presentationLabel8 = new JLabel("");
		presentationLabel8.setLocation(325, 270);
		presentationLabel8.setSize(400,30);
		presentationLabel8.setFont(speachFont); 
		add(presentationLabel8);
		//************************************************
		speachs.add(presentationLabel8);
		presentationLabel9 = new JLabel("");
		presentationLabel9.setLocation(325, 300);
		presentationLabel9.setSize(400,30);
		presentationLabel9.setFont(speachFont); 
		add(presentationLabel9);
		//************************************************
		speachs.add(presentationLabel9);
		presentationLabel10 = new JLabel("");
		presentationLabel10.setLocation(325, 330);
		presentationLabel10.setSize(400,30);
		presentationLabel10.setFont(speachFont); 
		add(presentationLabel10);
		//************************************************
		speachs.add(presentationLabel10);
		presentationLabel11 = new JLabel("");
		presentationLabel11.setLocation(325, 360);
		presentationLabel11.setSize(400,30);
		presentationLabel11.setFont(speachFont); 
		add(presentationLabel11);
		//************************************************
		speachs.add(presentationLabel11);
		presentationLabel12 = new JLabel("");
		presentationLabel12.setLocation(325, 390);
		presentationLabel12.setSize(400,30);
		presentationLabel12.setFont(speachFont); 
		add(presentationLabel12);
		speachs.add(presentationLabel12);
		//************************************************
		presentationLabel13 = new JLabel("");
		presentationLabel13.setLocation(325, 420);
		presentationLabel13.setSize(400,30);
		presentationLabel13.setFont(speachFont); 
		add(presentationLabel13);
		speachs.add(presentationLabel13);
		
		//****************************************************************************************************
	    // Name
		
		nameArea = new JTextField();
		nameArea.setVisible(false);
		nameArea.setBackground(Const.gameSelectorMenuSelectedGameColor);
		nameArea.setFont(nameFont);
		nameArea.setLocation(50, 480);
		nameArea.setSize(300,50);
		nameArea.setHorizontalAlignment(JTextField.CENTER);
		nameArea.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(nameArea.getText().length() > 10) {
					e.consume();
				}
				else if(isNameValid(nameArea.getText())) {
					validateName.setText("Valider");
				}
				else {
					validateName.setText("Trop Court");
				}
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//Do Nothing
			}
			@Override
			public void keyPressed(KeyEvent e) {
				//Do Nothing
			}
		});
		add(nameArea);
		
		validateName = new JButton("Trop Court");
		validateName.setVisible(false);
		validateName.setBackground(Const.gameSelectorMenuSelectedGameColor);
		validateName.setFont(nameFont);
		validateName.setLocation(400, 480);
		validateName.setSize(300,50);
		validateName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!validateName.getText().equals("Trop Court")) {
					String name = nameArea.getText();
					while((name.charAt(0)+"").equals(" "))
						name = name.replaceFirst(" ", "");
					while((name.charAt(name.length()-1)+"").equals(" "))
						name = name.substring(0, name.length()-2);
					resetSpeachsLabel(1);
					waitingName = name;
					speach = "Tu t'appelles donc bien " + name + " ?";
					speachLines = speach.split("\n");
					Timer timer = new Timer();
				    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
				    nameArea.setVisible(false);
				    validateName.setVisible(false);
				    Yes.setVisible(true);
				    No.setVisible(true);
				}
			}
		});
		add(validateName);
		
		//****************************************************************************************************
	    // Yes/No
		
		Yes = new JButton("Oui");
		Yes.setVisible(false);
		Yes.setBackground(Const.gameSelectorMenuSelectedGameColor);
		Yes.setFont(nameFont);
		Yes.setLocation(50, 480);
		Yes.setSize(300,50);
		Yes.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Yes.setVisible(false);
			    No.setVisible(false);
			    if(nameQuestion) {
			    	nameQuestion = false;
				    nameDone = true;
				    resetSpeachsLabel(3);
					Variables.PERSO_Name = waitingName;
					speach = "Parfait " + waitingName + ".= Désormais dis moi :=\n"
						+	 "Es tu un garçon ou une fille ? \n"
						+	 "*Bien que j'ai une petite préférence...*";
					speachLines = speach.split("\n");
					Timer timer = new Timer();
				    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
			    }
			    else if(sexQuestion) {
			    	sexQuestion = false;
				    sexDone = true;
				    boyGirl.setVisible(false);
					Variables.PERSO_Sex = waitingSex;
					resetSpeachsLabel(13);
					presentationLabel13.setHorizontalAlignment(JLabel.CENTER);
					speach = speach2.replace("changenamehere", Variables.PERSO_Name);
					if(Variables.PERSO_Sex.equals("boy")) Variables.LANG_Feminin = ""; else Variables.LANG_Feminin = "e";
    				speach = speach.replace("replacelangfemininhere", Variables.LANG_Feminin);
					speachLines = speach.split("\n");
					lastSpech = true;
					Timer timer = new Timer();
				    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
			    }
			   
			}
		});
		add(Yes);
		
		No = new JButton("Non");
		No.setVisible(false);
		No.setBackground(Const.gameSelectorMenuSelectedGameColor);
		No.setFont(nameFont);
		No.setLocation(400, 480);
		No.setSize(300,50);
		No.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(nameQuestion) {
				 	Yes.setVisible(false);
				 	No.setVisible(false);
				 	boyGirl.setVisible(false);
				 	resetSpeachsLabel(1);
					speach = "Comment t'appelles-tu ?";
					speachLines = speach.split("\n");
					nameQuestion = false;
					Timer timer = new Timer();
				    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
				}
				else if(sexQuestion) {
					Yes.setVisible(false);
				 	No.setVisible(false);
				 	boyGirl.setVisible(false);
				 	resetSpeachsLabel(1);
					speach = "Es tu un garçon ou une fille ?";
					speachLines = speach.split("\n");
					sexQuestion = false;
					Timer timer = new Timer();
				    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
				}
			   
			}
		});
		add(No);
		
		//****************************************************************************************************
	    // Boy/Girl Choice
		
		boy = new Boy();
		boy.setLocation(340, 170);
		boy.setSize(155,305);
		add(boy);
		
		girl = new Girl();
		girl.setLocation(530, 170);
		girl.setSize(155,305);
		add(girl);
		
		boyButton = new JButton("Un garçon");
		boyButton.setVisible(false);
		boyButton.setBackground(Const.gameSelectorMenuSelectedGameColor);
		boyButton.setFont(speachFont);
		boyButton.setLocation(340, 510);
		boyButton.setSize(165,30);
		boyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetSpeachsLabel(1);
				waitingSex = "boy";
				speach = "Tu es donc bien un garçon ?";
				speachLines = speach.split("\n");
				Timer timer = new Timer();
			    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
			    boy.setVisible(false);
			    girl.setVisible(false);
			    boyButton.setVisible(false);
			    girlButton.setVisible(false);
			    boyGirl.setVisible(true);
			    Yes.setVisible(true);
			    No.setVisible(true);
			}
		});
		add(boyButton);
		
		girlButton = new JButton("Une fille");
		girlButton.setVisible(false);
		girlButton.setBackground(Const.gameSelectorMenuSelectedGameColor);
		girlButton.setFont(speachFont);
		girlButton.setLocation(530, 510);
		girlButton.setSize(165,30);
		girlButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetSpeachsLabel(1);
				waitingSex = "girl";
				speach = "Tu es donc bien une fille ?";
				speachLines = speach.split("\n");
				Timer timer = new Timer();
			    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
			    boy.setVisible(false);
			    girl.setVisible(false);
			    boyButton.setVisible(false);
			    girlButton.setVisible(false);
			    boyGirl.setVisible(true);
			    Yes.setVisible(true);
			    No.setVisible(true);
			}
		});
		add(girlButton);
		
		boyGirl = new BoyGirl();
		boyGirl.setLocation(435, 150);
		boyGirl.setSize(155,305);
		add(boyGirl);
		
		
		//****************************************************************************************************
		// Music
		
		try {
			AudioInputStream audioInput = AudioSystem.getAudioInputStream(Const.themeStarting);
			clipStartingTheme = AudioSystem.getClip();
			clipStartingTheme.open(audioInput);
			Main.actualClip = clipStartingTheme;
			Main.refreshVolume();
			clipStartingTheme.start();
			clipStartingTheme.loop(1000);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
		
		//****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        
        //****************************************************************************************************
	    // Timer
        
        Timer timer = new Timer();
	    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(Const.profChenIntro.getImage(), 30, 20, null);
	}
	
	//****************************************************************************************************
    // Fonctions
	
	private boolean isNameValid(String name) {
		boolean valid = true;
		valid = name.length() >= 1 && name.length() <= 10;
		boolean no = true;
		int i = 0;
		while(no && i < name.length()) {
			no = (name.charAt(i) + "").equals(" ");
			i++;
		}
		return !no && valid;
	}
	
	//****************************************************************************************************
    // Boy/Girl Choice
	
	private class Boy extends JPanel {
		private static final long serialVersionUID = 1L;

		public Boy() {
			setBackground(Const.gameSelectorMenuColor);
			setLayout(null);
			setVisible(false);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(Const.boyChoice.getImage(), 0, 0, null);
		}
	}
	
	private class Girl extends JPanel {
		private static final long serialVersionUID = 1L;
		
		public Girl() {
			setBackground(Const.gameSelectorMenuColor);
			setLayout(null);
			setVisible(false);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(Const.girlChoice.getImage(), 0, 0, null);
		}
	}
	
	private class BoyGirl extends JPanel {
		private static final long serialVersionUID = 1L;

		public BoyGirl() {
			setBackground(Const.gameSelectorMenuColor);
			setLayout(null);
			setVisible(false);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(waitingSex.equals("boy"))
				g.drawImage(Const.boyChoice.getImage(), 0, 0, null);
			else
				g.drawImage(Const.girlChoice.getImage(), 0, 0, null);
		}
	}
	
	//****************************************************************************************************
    // Timer
	
	private class SpeechProf extends TimerTask {
		
		private boolean sound;
		
		public SpeechProf() {
			sound = false;
		}
		
		@Override
        public void run() {
			if(!sound) {
				sound = true;
				Sounds.playSound(Const.soundSelectionMenu);
			}
	 		if(introLabelIndex < speachs.size()) {
	 			if(introLabelIndex2 < speachLines[introLabelIndex].length() && (""+speachLines[introLabelIndex].charAt(introLabelIndex2)).equals("=")){
	 				introLabelIndex2++;
	 				introProfWaiting = true;
	 				this.cancel();
	 			}
	 			else {
	 				if(introLabelIndex2 < speachLines[introLabelIndex].length()) {
	 					speachs.get(introLabelIndex).setText(speachs.get(introLabelIndex).getText() + speachLines[introLabelIndex].charAt(introLabelIndex2));
	 					introLabelIndex2++;
	    	 		}
	    	 		else {
	    	 			introLabelIndex++;
	    	 			introLabelIndex2 = 0;
	    	 		}
	 			}
	 		}
	 		else {
	 			this.cancel();
	 			if(!nameQuestion && !nameDone) {
	 				nameArea.setVisible(true);
	 				nameArea.requestFocus();
		 			validateName.setVisible(true);
	 				nameQuestion = true;
	 			}
	 			else if(nameDone && !sexQuestion && !sexDone) {
	 				boy.setVisible(true);
	 				girl.setVisible(true);
	 				boyButton.setVisible(true);
	 				girlButton.setVisible(true);
	 				sexQuestion = true;
	 			}
	 			else if(lastSpech) {
	 				introProfDone = true;
	 			}
	 		}
        }
		
	}
	
	//****************************************************************************************************
    // Listener
	
	private class MyDispatcher implements KeyEventDispatcher {
		
		private boolean cancel = false;
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
        	if(game.isVisible() && !Main.settingsOn) {
        		if(event.getID() == KeyEvent.KEY_PRESSED && !cancel) {
        			int keyCode = event.getKeyCode();
        			if(keyCode == KeyEvent.VK_ENTER) {
        				if(nameArea.isVisible() && !validateName.getText().equals("Trop Court")) {
        					String name = nameArea.getText();
        					while((name.charAt(0)+"").equals(" "))
        						name = name.replaceFirst(" ", "");
        					while((name.charAt(name.length()-1)+"").equals(" "))
        						name = name.substring(0, name.length()-2);
        					resetSpeachsLabel(1);
        					waitingName = name;
        					speach = "Tu t'appelles donc bien " + name + " ?";
        					speachLines = speach.split("\n");
        					Timer timer = new Timer();
        				    timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
        				    nameArea.setVisible(false);
        				    validateName.setVisible(false);
        				    Yes.setVisible(true);
        				    No.setVisible(true);
        				}
        			}
        			if(!nameQuestion) {
                    	if(keyCode == KeyEvent.VK_ENTER || keyCode == Variables.CONTROLS_A) {
                			if(introProfDone) {
                				cancel = true;
                				clipStartingTheme.close();
                				game.speachPanel.setVisible(false);
                				game.myHouse = new MyHouse(game, true, 1024, 3050, Direction.DOWN, -654, -2788);
                		        game.add(game.myHouse);
                			}
                			else if(introProf && introProfWaiting) {
                				introProfWaiting = false;
                				Timer timer = new Timer();
                				timer.schedule(new SpeechProf(), 0, (long) Variables.SPEED_TEXT);
                			}
                    	}
                    	else if(keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_Options) {
                    		Main.settingsOn = true;
                    		Settings settings = new Settings();
                    		settings.setVisible(true);
                    	}
        			}
        		}
        	}
        	return false;
        }
	}
	
	private void resetSpeachsLabel(int x) {
		introLabelIndex = 0;
		introLabelIndex2 = 0;
		for(JLabel label : speachs)
			label.setText("");
		speachs.clear();
		speachs.add(presentationLabel1);
		if(x > 1)
			speachs.add(presentationLabel2);
		if(x > 2)
			speachs.add(presentationLabel3);
		if(x > 3)
			speachs.add(presentationLabel4);
		if(x > 4)
			speachs.add(presentationLabel5);
		if(x > 5)
			speachs.add(presentationLabel6);
		if(x > 6)
			speachs.add(presentationLabel7);
		if(x > 7)
			speachs.add(presentationLabel8);
		if(x > 8)
			speachs.add(presentationLabel9);
		if(x > 9)
			speachs.add(presentationLabel10);
		if(x > 10)
			speachs.add(presentationLabel11);
		if(x > 11)
			speachs.add(presentationLabel12);
		if(x > 12)
			speachs.add(presentationLabel13);
	}
}
