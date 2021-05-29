package fr.hugosimony.pokemontopaze.pokemon.battle;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.hugosimony.pokemontopaze.pokemon.Move;
import fr.hugosimony.pokemontopaze.pokemon.Moves;

public class BattleButtons {
	
	public static class Fight extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Fight(Battle battle) {
			setSize(190, 118);
			setBackground(Color.black);
			setIcon(BattleConst.fightButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					battle.fightButton.setVisible(false);
					battle.bagButton.setVisible(false);
					battle.pokemonButton.setVisible(false);
					battle.runButton.setVisible(false);
					battle.move1.setVisible(true);
					battle.move2.setVisible(true);
					battle.move3.setVisible(true);
					battle.move4.setVisible(true);
				}
			});
		}
		
	}
	
	public static class Bag extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Bag(Battle battle) {
			setSize(195, 118);
			setBackground(Color.black);
			setIcon(BattleConst.bagButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
		}
		
	}
	
	public static class Pokemon extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Pokemon(Battle battle) {
			setSize(195, 118);
			setBackground(Color.black);
			setIcon(BattleConst.pokemonButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
		}
		
	}
	
	public static class Run extends JButton {
		private static final long serialVersionUID = 1L;
		
		public Run(Battle battle) {
			setSize(190, 118);
			setBackground(Color.black);
			setIcon(BattleConst.runButton);
			setBorderPainted(false);
			setOpaque(false);
			setFocusable(false);
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO
					battle.endBattle(true, true);
				}
			});
		}
	}
	
	public static class MovePanel extends JPanel {
		private static final long serialVersionUID = 1L;

		private Font moveFont = new Font("Power Clear", Font.BOLD, 22);
		private Font ppFont = new Font("Power Clear", Font.BOLD, 18);
		
		private JLabel name;
		private JLabel PP;
		private Move move;
		
		public MovePanel(Battle battle, Move move, int place) {
			this.move = move;
			setSize(195, 200);
			setBackground(Color.black);
			setLayout(null);
			setOpaque(false);
			addMouseListener(new MouseListener() {
				@Override public void mouseReleased(MouseEvent e) { /* Do nothing */ }
				@Override public void mousePressed(MouseEvent e) { /* Do nothing */ }
				@Override public void mouseExited(MouseEvent e) { /* Do nothing */ }
				@Override public void mouseEntered(MouseEvent e) { /* Do nothing */ }
				@Override public void mouseClicked(MouseEvent e) {
					if(move.move != Moves.NULL)
						startMove(battle, move);
				}
			});
			
			name = new JLabel();
			PP = new JLabel();
			
			updateData();
			
			name.setLocation(0, 10);
			name.setSize(185, 75);
			name.setVerticalAlignment(JLabel.CENTER);
			name.setHorizontalAlignment(JLabel.CENTER);
			name.setFont(moveFont);

			PP.setLocation(73, 40);
			PP.setSize(100, 75);
			PP.setVerticalAlignment(JLabel.CENTER);
			PP.setHorizontalAlignment(JLabel.CENTER);
			PP.setFont(ppFont);
			
			add(name);
			add(PP);
			
			repaint();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(BattleConst.getMoveButton(move.type.name()).getImage(), 0, 0, null);
		}
		
		private void updateData() {
			if(move.move != Moves.NULL) {
				name.setText(move.name);
				PP.setText("PP " + move.pp + "/" + move.ppMax);
			}
		}
	}
	
	public static void startMove(Battle battle, Move move) {
		new BattleMove(battle, battle.battlePokemon2, battle.battlePokemon1, move, false, true);
	}
	
}
