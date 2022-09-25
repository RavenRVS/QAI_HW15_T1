import java.util.HashMap;

public class Game {

    HashMap<String, Player> playerList = new HashMap<>();

    public void register(Player player){
        playerList.put(player.name, player);
    }

    public int round(String playerName1, String playerName2){
        if (!playerList.containsKey(playerName1)) {
            throw new NotRegisteredException("Element with name: " + playerName1 + " not found");
        } else if (!playerList.containsKey(playerName2)) {
            throw new NotRegisteredException("Element with name: " + playerName2 + " not found");
        }
        if (playerList.get(playerName1).strength > playerList.get(playerName2).strength) {
            return 1;
        } else if (playerList.get(playerName1).strength < playerList.get(playerName2).strength) {
            return 2;
        }
        return 0;
    }

    public HashMap<String, Player> getPlayerList() {
        return playerList;
    }
}
