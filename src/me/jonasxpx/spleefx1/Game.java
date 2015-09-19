package me.jonasxpx.spleefx1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import me.jonasxpx.spleefx1.events.PlayerJoinGameEvent;
import me.jonasxpx.spleefx1.events.PlayerLeaveGameEvent;

import org.bukkit.entity.Player;

public class Game implements Serializable{
	
	private static final long serialVersionUID = -258761276335202208L;
	private final int MAXPLAYERS;
	private List<String> players = new ArrayList<String>();
	private GameStatus status;
	
	public Game(int MaxPlayers){
		this.MAXPLAYERS = MaxPlayers;
	}
	
	public int getMaxPlayers(){
		return MAXPLAYERS;
	}
	
	public void addPlayer(Player player){
		if(!players.contains(player)){
			SpleefX1.pluginManager.callEvent(new PlayerJoinGameEvent(player, this));
			players.add(player.getName());
		}else
			throw new IllegalArgumentException("O jogador já esta no evento");
	}
	
	public void removePlayer(Player player){
		if(players.contains(player)){
			SpleefX1.pluginManager.callEvent(new PlayerLeaveGameEvent(player, this));
			players.remove(player);
		}
	}
	
	public void setGameStatus(GameStatus status){
		this.status = status;
	}
	
	public GameStatus getGameStatus(){
		return this.status;
	}
	
}
