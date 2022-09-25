import java.util.ArrayList;

public class Game {

    ArrayList<Player> playerList = new ArrayList<>();

    public void register(Player player){
        playerList.add(player);
    }

    public int round(String playerName1, String playerName2){
        Player player1 = findById(playerName1);
        Player player2 = findById(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not found");
        } else if (player2 == null) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not found");
        }
        if (player1.strength > player2.strength) {
            return 1;
        } else if (player1.strength < player2.strength) {
            return 2;
        }
        return 0;
    }

    public Player findById(String playerName) {
        for (Player player : playerList) {
            if (player.name == playerName) {
                return player;
            }
        }
        return null;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
