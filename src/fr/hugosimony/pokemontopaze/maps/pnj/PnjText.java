package fr.hugosimony.pokemontopaze.maps.pnj;

import fr.hugosimony.pokemontopaze.Game;
import fr.hugosimony.pokemontopaze.Variables;
import fr.hugosimony.pokemontopaze.pokemon.PKM;

public class PnjText {

	public static String getText(String perso) {
		
		//***********************************************************************************************
		
		if(perso.equals("mom")) {
			if(Variables.ADVENTURE_Step == 0)
				return "Ah t'es enfin réveillé" + Variables.LANG_Feminin + "...= Bon, t'as pas un truc à faire là ¤\n="
						+ "Le Prof Chen t'attend à Villaube, au nord.";
			if(Variables.ADVENTURE_Step == 1)
				return "Bon, t'as pas un truc à faire là ¤= Le Prof Chen t'attend\n"
						+ "à Villaube, au nord.";
			if(Variables.ADVENTURE_Step > 1)
				return "Ah t'as eu ton Pokémon...= Tant mieux,= tu vas pouvoir partir\n"
						+ "explorer la région.= Repose toi quand même.";
		}
		
		//***********************************************************************************************
		
		else if(perso.equals("brownboy001")) {
			return "Tu connais le Prof Chen ¤= C'est un vieux monsieur qui aime bien\n"
					+ "les femmes.= J'ai entendu dire qu'il avait des Pokémons rares !";
		}
	
		//***********************************************************************************************
		
		else if(perso.equals("browngirl001")) {
			if(Variables.ADVENTURE_Step < 2)
				return "Coucou " + Variables.PERSO_Name + ",= tu vas enfin choper ton premier Pokémon !=\n"
						+ "T'en as de la chance...\n";
			return "Coucou " + Variables.PERSO_Name + ",= il est cool ton Pokémon !=\n"
			+ "T'en as de la chance...\n";
		}
		
		//***********************************************************************************************
		
		else if(perso.equals("police001")) {
			return "Désolé,= la forêt est encore trop dangereuse pour toi.";
		}
		
		//***********************************************************************************************
		
		else if(perso.equals("profChen")) {
			if(Variables.ADVENTURE_Step == 1)
				return "Bonjour " + Variables.PERSO_Name + " != J'ai failli oublier que tu ne pouvais\n"
						+ "pas venir à mon labo sans Pokémon.=\n"
						+ "Mais cela va vite changer.= Tu es sur le point d'obtenir\n"
						+ "ton premier Pokémon !=+";
			if(Variables.ADVENTURE_Step >= 2 && Variables.ADVENTURE_Step <=4)
				return "+";
			if(Variables.ADVENTURE_Step == 5)
				return "Dans chacune de ces Poké Balls se trouve un Pokémon.\n="
						+ "Ils sont encore jeunes.=\n"
						+ "Le Pokémon que tu choisiras explorera la région avec toi.\n="
						+ "Tu t'amélioreras avec lui.=+";
			if(Variables.ADVENTURE_Step == 6 || Variables.ADVENTURE_Step == 7)
				return "C'est le moment.= Choisis bien,= tu ne pourras pas revenir\n"
						+ "en arrière.";
			if(Variables.ADVENTURE_Step == 8)
				return "Tu as donc choisi " + PKM.getStarterName(Variables.STARTER) + " != Très bon choix.\n="
						+ "Prends en grand soin.=+";
			if(Variables.ADVENTURE_Step == 11)
				return "Prof. Chen := Eh bah " + Variables.RIVAL_Name + ",= toujours aussi poli" + Variables.RIVAL_Feminin + "...=\n"
						+ "Hum hum bon,= je vais récupérer le petit dernier.=+";
			if(Variables.ADVENTURE_Step == 12)
				return "+";
			if(Variables.ADVENTURE_Step == 13)
				return "Prof. Chen := Bon sur ce les enfants,= j'ai d'autres choses à faire...=\n"
				+ "Faites attention avec ces Pokémons !=\n"
				+ "Passez me voir à mon labo au nord,= j'ai un autre truc pour vous.=\n"
				+ "Bougez vous,= j'ai pas de temps à perdre.=+";
			if(Variables.ADVENTURE_Step == 14)
				return "[]+";
		}
		
		//***********************************************************************************************
		
		else if(perso.equals("rival")) {
			if(Variables.ADVENTURE_Step == 9)
				return "Coucou " + Variables.PERSO_Name + " != Coucou Eliot != Je vois que vous m'avez pas attendu" + 
						(Variables.LANG_Feminin.equals("") ? "e" : "") + "\n"
						+ "pour le don de Pokémon...= Je vais choisir le mien=, c'est parti !=+";
			if(Variables.ADVENTURE_Step == 10)
				return "Je te choisis toi,= " + PKM.getStarterName(PKM.getOppositeStarter(Variables.STARTER)) + " !=+";
			if(Variables.ADVENTURE_Step == 15) {
				Game.waitingBattle = "rival01";
				Game.waitingBattlefield = "Champion";
				Game.waitingWeather = "Good";
				return Variables.RIVAL_Name + " := Bon " + Variables.PERSO_Name + ",= c'est le moment non ¤= On va enfin\n"
						+ "pouvoir faire un combat de Pokémon !=\n"
						+ "Je vais te mettre une raclée != T'es prêt" + Variables.LANG_Feminin + " ¤= C'est parti !=^";
			}
			if(Variables.ADVENTURE_Step == 16)
				return "J'ai soigné ton Pokémon.= Tu peux aller le montrer à ta mère si tu\n"
						+ "veux.= Bon je vais voir le vieux.= Il nous attend à Villaube.= A plus !=+";
			if(Variables.ADVENTURE_Step == 17)
				return "[]";
		}
		return "";
	}
	
}
