package fcu.iecs.oop.pokemon;

public class GYM {
	public static Player fight(Player... players) {
		Player nowWinner = players[0];
		Pokemon[] pokeNowWinner = players[0].getPokemons();
		
		for(int i=1; i<players.length; i++) {
			Player temp = players[i];
			Pokemon[] pokeTemp = players[i].getPokemons();
			int[] count = {0, 0};
			for (int j=0; j<3; j++) {
				if (pokeNowWinner[j].getType() != pokeTemp[j].getType()) {
					if (pokeNowWinner[j].getType() == PokemonType.FIRE) {
						if (pokeTemp[j].getType() == PokemonType.GRASS) {
							count[0]++;
						} else if (pokeTemp[j].getType() == PokemonType.WATER) {
							count[1]++;
						}
					} else if (pokeNowWinner[j].getType() == PokemonType.GRASS) {
						if (pokeTemp[j].getType() == PokemonType.WATER) {
							count[0]++;
						} else if (pokeTemp[j].getType() == PokemonType.FIRE) {
							count[1]++;
						}
					} else if (pokeNowWinner[j].getType() == PokemonType.WATER) {
						if (pokeTemp[j].getType() == PokemonType.FIRE) {
							count[0]++;
						} else if (pokeTemp[j].getType() == PokemonType.GRASS) {
							count[1]++;
						}
					}
				} else if (pokeNowWinner[j].getType() == pokeTemp[j].getType() && pokeNowWinner[j].getCp() != pokeTemp[j].getCp()) {
					if (pokeNowWinner[j].getCp() > pokeTemp[j].getCp()) {
						count[0]++;
					} else {
						count[1]++;
					}
				} else {
					int ran = (int)(Math.random()*50);
					if (ran % 2 == 0) {
						count[0]++;
					} else {
						count[1]++;
					}
				}
			}
			if (count[1] >=2) {
				nowWinner = temp;
			}
		}
		
		nowWinner.setLevel(nowWinner.getLevel() + 1);
		System.out.println("Winner is " + nowWinner.getPlayerName() + ", and his/her level becomes " + nowWinner.getLevel() + ".");
		return nowWinner;
	}
}
