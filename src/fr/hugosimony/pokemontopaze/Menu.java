package fr.hugosimony.pokemontopaze;

import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
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
import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.files.FileReaderWriter;
import fr.hugosimony.pokemontopaze.files.adventure.FileAdventureReaderWriter;
import fr.hugosimony.pokemontopaze.sounds.Sounds;
import fr.hugosimony.pokemontopaze.timer.GlobalTimer;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;

	private Menu menu;
	private boolean disposed;
	private boolean gameSelectorMenu;
	private int selectedGame;
	
	private JPanel mainPanel;
	private JButton mainMenu;
	private JButton game1;
	private JButton game2;
	private JButton game3;
	
	private Settings settings;
	
	private final Font newGameFont = new Font("Comic Sans MS", Font.ITALIC, 60);
	private final Font loadGameFont = new Font("Comic Sans MS", Font.ITALIC, 20);
	
	private Clip clipMainMenuTheme;
	
	public Menu() {
		
		//****************************************************************************************************
		// Load Variables
		
		ArrayList<String> lines = FileReaderWriter.readFile(Const.settingsPath);
		Variables.VOLUME_Main = Float.parseFloat(lines.get(0));
		Variables.CONTROLS_UP = Integer.parseInt(lines.get(1));
		Variables.CONTROLS_DOWN = Integer.parseInt(lines.get(2));
		Variables.CONTROLS_LEFT = Integer.parseInt(lines.get(3));
		Variables.CONTROLS_RIGHT = Integer.parseInt(lines.get(4));
		Variables.CONTROLS_A = Integer.parseInt(lines.get(5));
		Variables.CONTROLS_B = Integer.parseInt(lines.get(6));
		Variables.CONTROLS_MenuX = Integer.parseInt(lines.get(7));
		Variables.CONTROLS_Favori = Integer.parseInt(lines.get(8));
		Variables.CONTROLS_Options = Integer.parseInt(lines.get(9));
		Variables.SPEED_TEXT = Integer.parseInt(lines.get(10));
		
		//****************************************************************************************************
		// Frame Settings
		
		menu = this;
		disposed = false;
		gameSelectorMenu = false;
		selectedGame = 1;
		
		setTitle("Pokémon Topaze");
		setSize(800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Const.mainIcon.getImage());
		setDefaultCloseOperation(2);
		addWindowListener(new WindowAdapter() {
	    	public void windowClosed(WindowEvent e) {
	    		if(!disposed) {
	    			System.exit(0);
	    		}
	    	}
		});
		
		//****************************************************************************************************
		// Music
		
		try {
			AudioInputStream audioInputMainMenuTheme = AudioSystem.getAudioInputStream(Const.themeMainMenu);
			clipMainMenuTheme = AudioSystem.getClip();
			clipMainMenuTheme.open(audioInputMainMenuTheme);
			Main.actualClip = clipMainMenuTheme;
			Main.setVolume((float) 0.5);
			Main.refreshVolume();
			clipMainMenuTheme.start();
			clipMainMenuTheme.loop(1000);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
		
		//****************************************************************************************************
		// BackGround
		
		mainMenu = new JButton("");
		mainMenu.setBorder(null);
		mainMenu.setIcon(Const.mainMenu);
		this.add(mainMenu);
		
		mainPanel = new JPanel();
		mainPanel.setFocusable(true);
		mainPanel.setBackground(Const.gameSelectorMenuColor);
		
		Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
    		int x = 0;
    	 	@Override
	        public void run() {
    		 	if(!gameSelectorMenu) {
    		 		if(x==1) {
    					mainMenu.setIcon(Const.mainMenuBis);
    	        		x--;
    	        	}
    	        	else {
    	        		mainMenu.setIcon(Const.mainMenu);
    	        		x++;
        		 	}
    		 	}
	        }
	    }, 0, 750);
	    
	    //****************************************************************************************************
	  	// GameSelectorMenu
	    
	    game1 = new JButton("");
	    game1.setBorderPainted(true);
	    if(!new File(Const.getSaveFolderPath(1)).exists()) {
	    	game1.setFont(newGameFont);
	    	game1.setText("Nouvelle Partie (1)");
	    }
	    else {
	    	game1.setFont(loadGameFont);
	    	game1.setText("Partie 1 : " + FileAdventureReaderWriter.getName(1) + " - " + "Temps : " + GlobalTimer.getGoodPrintedTimer(FileAdventureReaderWriter.getAdventureTime(1)) + " - Badge(s) : " + FileAdventureReaderWriter.getNumberOfBadges(1));
	    }
	    game1.setBackground(Const.gameSelectorMenuSelectedGameColor);
	    game1.setBounds(49, 22, 690, 170);
	    game1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!Main.settingsOn)
					startGame(!new File(Const.getSaveFolderPath(1)).exists(), 1);
			}
		});
	    
	    game2 = new JButton("");
	    game2.setBorderPainted(true);
	    if(!new File(Const.getSaveFolderPath(2)).exists()) {
	    	game2.setFont(newGameFont);
	    	game2.setText("Nouvelle Partie (2)");
	    }
	    else {
	    	game2.setFont(loadGameFont);
	    	game2.setText("Partie 2 : " + FileAdventureReaderWriter.getName(2) + " - " + "Temps : " + GlobalTimer.getGoodPrintedTimer(FileAdventureReaderWriter.getAdventureTime(2)) + " - Badge(s) : " + FileAdventureReaderWriter.getNumberOfBadges(2));
	    }
	    game2.setBackground(Const.gameSelectorMenuGameColor);
		game2.setBounds(49, 197, 690, 170);
		game2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!Main.settingsOn)
					startGame(!new File(Const.getSaveFolderPath(2)).exists(), 2);
			}
		});
	    
	    game3 = new JButton("");
	    game3.setBorderPainted(true);
	    if(!new File(Const.getSaveFolderPath(3)).exists()) {
	    	game3.setFont(newGameFont);
	    	game3.setText("Nouvelle Partie (3)");
	    }
	    else {
	    	game3.setFont(loadGameFont);
	    	game3.setText("Partie 3 : " + FileAdventureReaderWriter.getName(3) + " - " + "Temps : " + GlobalTimer.getGoodPrintedTimer(FileAdventureReaderWriter.getAdventureTime(3)) + " - Badge(s) : " + FileAdventureReaderWriter.getNumberOfBadges(3));
	    }
	    game3.setBackground(Const.gameSelectorMenuGameColor);
		game3.setBounds(49, 372, 690, 170);
		game3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!Main.settingsOn)
					startGame(!new File(Const.getSaveFolderPath(3)).exists(), 3);
			}
		});
		    
	    //****************************************************************************************************
	    // Listener
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
	}
	
	private void setGameSelectorMenu() {
		menu.gameSelectorMenu = true;
		menu.remove(mainMenu);
		
		menu.add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.add(game1);
		mainPanel.add(game2);
		mainPanel.add(game3);
		menu.validate();
	}
	
	private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
        	if(menu.isVisible() && !Main.settingsOn) {
        		if(event.getID() == KeyEvent.KEY_PRESSED) {
                	int keyCode = event.getKeyCode();
                	if(keyCode == KeyEvent.VK_ENTER || keyCode == Variables.CONTROLS_A) {
                		if(!gameSelectorMenu)
           				   setGameSelectorMenu();
                		else {
                			if(selectedGame == 1)
                				startGame(!new File(Const.getSaveFolderPath(1)).exists(), 1);
                			else if(selectedGame == 2)
                				startGame(!new File(Const.getSaveFolderPath(2)).exists(), 2);
                			else if(selectedGame == 3)
                				startGame(!new File(Const.getSaveFolderPath(3)).exists(), 3);
                		}
                			
                	}
                	else if((keyCode == Variables.CONTROLS_B && gameSelectorMenu) || (keyCode == KeyEvent.VK_BACK_SPACE && gameSelectorMenu)) {
                		clipMainMenuTheme.stop();
     			   		disposed = true;
     			   		menu.dispose();
     			   		Menu menu = new Menu();
     			   		menu.setVisible(true);
     			   	}
                	else if(keyCode == KeyEvent.VK_DOWN && gameSelectorMenu) {
                		Sounds.playSound(Const.soundSelectionMenu);
                		if(selectedGame == 1) {
                			game1.setBackground(Const.gameSelectorMenuGameColor);
                			game2.setBackground(Const.gameSelectorMenuSelectedGameColor);
                		}
                		else if(selectedGame == 2) {
                			game2.setBackground(Const.gameSelectorMenuGameColor);
                			game3.setBackground(Const.gameSelectorMenuSelectedGameColor);
                		}
                		else if(selectedGame == 3) {
                			game3.setBackground(Const.gameSelectorMenuGameColor);
                			game1.setBackground(Const.gameSelectorMenuSelectedGameColor);
                		}
                		selectedGame++;
                		if(selectedGame > 3)
                			selectedGame = 1;
                	}
                	else if(keyCode == KeyEvent.VK_UP && gameSelectorMenu) {
                		Sounds.playSound(Const.soundSelectionMenu);
                		if(selectedGame == 1) {
                			game1.setBackground(Const.gameSelectorMenuGameColor);
                			game3.setBackground(Const.gameSelectorMenuSelectedGameColor);
                		}
                		else if(selectedGame == 2) {
                			game2.setBackground(Const.gameSelectorMenuGameColor);
                			game1.setBackground(Const.gameSelectorMenuSelectedGameColor);
                		}
                		else if(selectedGame == 3) {
                			game3.setBackground(Const.gameSelectorMenuGameColor);
                			game2.setBackground(Const.gameSelectorMenuSelectedGameColor);
                		}
                		selectedGame--;
                		if(selectedGame < 1)
                			selectedGame = 3;
                	}
                	else if(!Main.settingsOn && (keyCode == KeyEvent.VK_ESCAPE || keyCode == Variables.CONTROLS_Options)) {
                		Main.settingsOn = true;
                		settings = new Settings();
                		settings.setVisible(true);
                		System.out.println("oucouc");
                	}
                }
        	}
        	else if(menu.isVisible() && Main.settingsOn && event.getID() == KeyEvent.KEY_PRESSED && 
        			(event.getKeyCode() == KeyEvent.VK_ESCAPE || event.getKeyCode() == Variables.CONTROLS_Options)) {
        		Main.settingsOn = false;
        		settings.dispose();
        	}
            return false;
        }
    }
	
	private void startGame(boolean newGame, int x) {
		clipMainMenuTheme.close();
   		disposed = true;
   		menu.dispose();
   		Game game = new Game(newGame, x);
   		game.setVisible(true);
	}
	
}
