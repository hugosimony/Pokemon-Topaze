package fr.hugosimony.pokemontopaze;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import fr.hugosimony.pokemontopaze.files.FileCreator;
import fr.hugosimony.pokemontopaze.files.FileReaderWriter;
import fr.hugosimony.pokemontopaze.sounds.Sounds;

public class Settings extends JFrame {
	private static final long serialVersionUID = 1L;

	private final Font volumeControlLabelFont = new Font("Arial", Font.BOLD, 30);
	private final Font volumeSliderFont = new Font("ARIAL", Font.BOLD, 15);
	private final Font controlsFont = new Font("ARIAL", Font.BOLD, 20);
	private final Font resetFinishFont = new Font("ARIAL", Font.BOLD, 25);
	private final Color background = new Color(180,180,180);
	private final Color backgroundControlsButtons = new Color(160,160,160);
	
	private String selectedControl;
	
	private JSlider volumeSlider;
	private JSlider speedSlider;
	
	private JButton UPButton;
	private JButton DOWNButton;
	private JButton LEFTButton;
	private JButton RIGHTButton;
	
	private JButton AButton;
	private JButton BButton;
	private JButton MenuXButton;
	private JButton FavoriButton;
	private JButton OptionsButton;
	
	private int[] controls = new int[9];
	
	private JButton finish;
	
	private Settings settings;
	
	public Settings() {
		
		settings = this;
		
		selectedControl = "";
		controls[0] = Variables.CONTROLS_UP;
		controls[1] = Variables.CONTROLS_DOWN;
		controls[2] = Variables.CONTROLS_LEFT;
		controls[3] = Variables.CONTROLS_RIGHT;
		controls[4] = Variables.CONTROLS_A;
		controls[5] = Variables.CONTROLS_B;
		controls[6] = Variables.CONTROLS_MenuX;
		controls[7] = Variables.CONTROLS_Favori;
		controls[8] = Variables.CONTROLS_Options;
		
		setTitle("Pokémon Topaze Settings");
		setSize(450, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Const.mainIcon.getImage());
		setDefaultCloseOperation(2);
		addWindowListener(new WindowAdapter() {
	    	public void windowClosed(WindowEvent e) {
	    		Sounds.playSound(Const.soundOpenMenu);
	    		Main.settingsOn = false;
	    	}
		});
		
		Sounds.playSound(Const.soundOpenMenu);
		
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
		
		JPanel panel = new JPanel();
		add(panel);
		
		panel.setLayout(new GridLayout(17,1));
		panel.setBackground(background);
		
		// Volume
		
		JLabel volumeLabel = new JLabel("Volume");
		volumeLabel.setFont(volumeControlLabelFont);
		volumeLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(volumeLabel);
		
		volumeSlider = new JSlider(0,10);
		volumeSlider.setBackground(background);
		volumeSlider.setFont(volumeSliderFont);
		volumeSlider.setMinorTickSpacing(1);
		volumeSlider.setMajorTickSpacing(1);
		volumeSlider.setPaintTicks(true);
		volumeSlider.setPaintLabels(false);
		volumeSlider.setValue((int) (Variables.VOLUME_Main*10));
		volumeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				Variables.VOLUME_Main = (float) ((double)volumeSlider.getValue()/(double)10);
				Main.refreshVolume();
			}
		});
		panel.add(volumeSlider);
		
		// Separator
		
		JSeparator sep = new JSeparator();
		panel.add(sep);
		
		// Text Speed
		
		JLabel speedLabel = new JLabel("Vitesse du Texte");
		speedLabel.setFont(volumeControlLabelFont);
		speedLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(speedLabel);
		
		speedSlider = new JSlider(0,80);
		speedSlider.setBackground(background);
		speedSlider.setFont(volumeSliderFont);
		speedSlider.setMinorTickSpacing(1);
		speedSlider.setMajorTickSpacing(1);
		speedSlider.setPaintTicks(true);
		speedSlider.setPaintLabels(false);
		speedSlider.setValue(80 - (int) (Variables.SPEED_TEXT) + 1);
		panel.add(speedSlider);
		
		// Separator
		
		JSeparator sep2 = new JSeparator();
		panel.add(sep2);
		
		// Controls
		
		JLabel controlsLabel = new JLabel("Contrôles");
		controlsLabel.setBackground(background);
		controlsLabel.setFont(volumeControlLabelFont);
		controlsLabel.setHorizontalAlignment(JLabel.CENTER);
		panel.add(controlsLabel);
		
		JPanel UPPanel = new JPanel();
		UPPanel.setLayout(new GridLayout(1,2));
		JLabel UP = new JLabel("UP");
		UPPanel.setBackground(background);
		UP.setFont(controlsFont);
		UP.setHorizontalAlignment(JLabel.CENTER);
		UPPanel.add(UP);
		UPButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_UP));
		UPButton.setFont(controlsFont);
		UPButton.setBackground(backgroundControlsButtons);
		UPButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "UP";
				UPButton.setText("...");
			}
		});
		UPPanel.add(UPButton);
		panel.add(UPPanel);
		
		JPanel DOWNPanel = new JPanel();
		DOWNPanel.setLayout(new GridLayout(1,2));
		JLabel DOWN = new JLabel("DOWN");
		DOWNPanel.setBackground(background);
		DOWN.setFont(controlsFont);
		DOWN.setHorizontalAlignment(JLabel.CENTER);
		DOWNPanel.add(DOWN);
		DOWNButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_DOWN));
		DOWNButton.setFont(controlsFont);
		DOWNButton.setBackground(backgroundControlsButtons);
		DOWNButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "DOWN";
				DOWNButton.setText("...");
			}
		});
		DOWNPanel.add(DOWNButton);
		panel.add(DOWNPanel);
		
		JPanel LEFTPanel = new JPanel();
		LEFTPanel.setLayout(new GridLayout(1,2));
		JLabel LEFT = new JLabel("LEFT");
		LEFTPanel.setBackground(background);
		LEFT.setFont(controlsFont);
		LEFT.setHorizontalAlignment(JLabel.CENTER);
		LEFTPanel.add(LEFT);
		LEFTButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_LEFT));
		LEFTButton.setFont(controlsFont);
		LEFTButton.setBackground(backgroundControlsButtons);
		LEFTButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "LEFT";
				LEFTButton.setText("...");
			}
		});
		LEFTPanel.add(LEFTButton);
		panel.add(LEFTPanel);
		
		JPanel RIGHTPanel = new JPanel();
		RIGHTPanel.setLayout(new GridLayout(1,2));
		JLabel RIGHT = new JLabel("RIGHT");
		RIGHTPanel.setBackground(background);
		RIGHT.setFont(controlsFont);
		RIGHT.setHorizontalAlignment(JLabel.CENTER);
		RIGHTPanel.add(RIGHT);
		RIGHTButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_RIGHT));
		RIGHTButton.setFont(controlsFont);
		RIGHTButton.setBackground(backgroundControlsButtons);
		RIGHTButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "RIGHT";
				RIGHTButton.setText("...");
			}
		});
		RIGHTPanel.add(RIGHTButton);
		panel.add(RIGHTPanel);
		
		JPanel APanel = new JPanel();
		APanel.setLayout(new GridLayout(1,2));
		JLabel A = new JLabel("A");
		APanel.setBackground(background);
		A.setFont(controlsFont);
		A.setHorizontalAlignment(JLabel.CENTER);
		APanel.add(A);
		AButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_A));
		AButton.setFont(controlsFont);
		AButton.setBackground(backgroundControlsButtons);
		AButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "A";
				AButton.setText("...");
			}
		});
		APanel.add(AButton);
		panel.add(APanel);
		
		JPanel BPanel = new JPanel();
		BPanel.setLayout(new GridLayout(1,2));
		JLabel B = new JLabel("B");
		BPanel.setBackground(background);
		B.setFont(controlsFont);
		B.setHorizontalAlignment(JLabel.CENTER);
		BPanel.add(B);
		BButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_B));
		BButton.setFont(controlsFont);
		BButton.setBackground(backgroundControlsButtons);
		BButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "B";
				BButton.setText("...");
			}
		});
		BPanel.add(BButton);
		panel.add(BPanel);
	
		JPanel MenuXPanel = new JPanel();
		MenuXPanel.setLayout(new GridLayout(1,2));
		JLabel MenuX = new JLabel("Menu X");
		MenuXPanel.setBackground(background);
		MenuX.setFont(controlsFont);
		MenuX.setHorizontalAlignment(JLabel.CENTER);
		MenuXPanel.add(MenuX);
		MenuXButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_MenuX));
		MenuXButton.setFont(controlsFont);
		MenuXButton.setBackground(backgroundControlsButtons);
		MenuXButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "MenuX";
				MenuXButton.setText("...");
			}
		});
		MenuXPanel.add(MenuXButton);
		panel.add(MenuXPanel);
		
		JPanel FavoriPanel = new JPanel();
		FavoriPanel.setLayout(new GridLayout(1,2));
		JLabel Favori = new JLabel("Favori");
		FavoriPanel.setBackground(background);
		Favori.setFont(controlsFont);
		Favori.setHorizontalAlignment(JLabel.CENTER);
		FavoriPanel.add(Favori);
		FavoriButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_Favori));
		FavoriButton.setFont(controlsFont);
		FavoriButton.setBackground(backgroundControlsButtons);
		FavoriButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "Favori";
				FavoriButton.setText("...");
			}
		});
		FavoriPanel.add(FavoriButton);
		panel.add(FavoriPanel);
		
		JPanel OptionsPanel = new JPanel();
		OptionsPanel.setLayout(new GridLayout(1,2));
		JLabel Options = new JLabel("Options");
		OptionsPanel.setBackground(background);
		Options.setFont(controlsFont);
		Options.setHorizontalAlignment(JLabel.CENTER);
		OptionsPanel.add(Options);
		OptionsButton = new JButton(KeyEvent.getKeyText(Variables.CONTROLS_Options));
		OptionsButton.setFont(controlsFont);
		OptionsButton.setBackground(backgroundControlsButtons);
		OptionsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedControl = "Options";
				OptionsButton.setText("...");
			}
		});
		OptionsPanel.add(OptionsButton);
		panel.add(OptionsPanel);
		
		JPanel resetFinishPanel = new JPanel();
		resetFinishPanel.setLayout(new GridLayout(1,2));
		JButton reset = new JButton("Reset");
		reset.setFont(resetFinishFont);
		reset.setBackground(new Color(255, 0, 0));
		reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				volumeSlider.setValue(5);
				speedSlider.setValue(40);
				controls[0] = 38;
				UPButton.setText(KeyEvent.getKeyText(38));
				controls[1] = 40;
				DOWNButton.setText(KeyEvent.getKeyText(40));
				controls[2] = 37;
				LEFTButton.setText(KeyEvent.getKeyText(37));
				controls[3] = 39;
				RIGHTButton.setText(KeyEvent.getKeyText(39));
				controls[4] = 65;
				AButton.setText(KeyEvent.getKeyText(65));
				controls[5] = 66;
				BButton.setText(KeyEvent.getKeyText(66));
				controls[6] = 88;
				MenuXButton.setText(KeyEvent.getKeyText(88));
				controls[7] = 89;
				FavoriButton.setText(KeyEvent.getKeyText(89));
				controls[8] = 79;
				OptionsButton.setText(KeyEvent.getKeyText(79));
			}
		});
		resetFinishPanel.add(reset);
		finish = new JButton("Terminé");
		finish.setFont(resetFinishFont);
		finish.setBackground(new Color(0,255,0));
		resetFinishPanel.add(finish);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setValues();
				Main.settingsOn = false;
				settings.dispose();
			}
		});
		
		panel.add(resetFinishPanel);
	}
	
	public void setValues() {
		ArrayList<String> lines = new ArrayList<String>();
		lines.add(Variables.VOLUME_Main + "");
		Variables.CONTROLS_UP = controls[0];
		lines.add(controls[0] + "");
		Variables.CONTROLS_DOWN = controls[1];
		lines.add(controls[1] + "");
		Variables.CONTROLS_LEFT = controls[2];
		lines.add(controls[2] + "");
		Variables.CONTROLS_RIGHT = controls[3];
		lines.add(controls[3] + "");
		Variables.CONTROLS_A = controls[4];
		lines.add(controls[4] + "");
		Variables.CONTROLS_B = controls[5];
		lines.add(controls[5] + "");
		Variables.CONTROLS_MenuX = controls[6];
		lines.add(controls[6] + "");
		Variables.CONTROLS_Favori = controls[7];
		lines.add(controls[7] + "");
		Variables.CONTROLS_Options = controls[8];
		lines.add(controls[8] + "");
		Variables.SPEED_TEXT = 80 - speedSlider.getValue() + 1;
		lines.add((int) Variables.SPEED_TEXT + "");
		FileCreator.createSettingsFile(false);
		FileReaderWriter.writeAllLine(lines, Const.settingsPath);
	}
	
	public boolean isThatKeyAlreadyUsed(int x) {
		int i = 0;
		boolean yes = false;
		while(!yes && i < controls.length) {
			yes = x == controls[i];
			i++;
		}
		return yes;
	}
	
	private class MyDispatcher implements KeyEventDispatcher {
        @Override
        public boolean dispatchKeyEvent(KeyEvent event) {
        	if(event.getID() == KeyEvent.KEY_PRESSED && !selectedControl.equals("")) {
        		int keyCode = event.getKeyCode();
        		if(keyCode != 524 && keyCode != 10 && keyCode != 27 && keyCode != 8 && keyCode != 32 && !isThatKeyAlreadyUsed(keyCode)) {
        			String key = KeyEvent.getKeyText(keyCode);
        			if(selectedControl.equals("UP") || selectedControl.equals("DOWN") || selectedControl.equals("LEFT") || selectedControl.equals("RIGHT")) {
        				if(selectedControl.equals("UP")) {
        					UPButton.setText(key);
        					controls[0] = keyCode;
        				}
        				else if(selectedControl.equals("DOWN")) {
        					DOWNButton.setText(key);
        					controls[1] = keyCode;
        				}
        				else if(selectedControl.equals("LEFT")) {
        					LEFTButton.setText(key);
        					controls[2] = keyCode;
        				}
        				else if(selectedControl.equals("RIGHT")) {
        					RIGHTButton.setText(key);
        					controls[3] = keyCode;
        				}
        			}
        			else {
        				if(selectedControl.equals("A")) {
        					AButton.setText(key);
        					controls[4] = keyCode;
        				}
        				else if(selectedControl.equals("B")) {
        					BButton.setText(key);
        					controls[5] = keyCode;
        				}
        				else if(selectedControl.equals("MenuX")) {
        					MenuXButton.setText(key);
        					controls[6] = keyCode;
        				}
        				else if(selectedControl.equals("Favori")) {
        					FavoriButton.setText(key);
        					controls[7] = keyCode;
        				}
        				else if(selectedControl.equals("Options")) {
        					OptionsButton.setText(key);
        					controls[8] = keyCode;
        				}
        			}
        		}
        		selectedControl = "";
        	}
			return false;
        }
	}
	
}
