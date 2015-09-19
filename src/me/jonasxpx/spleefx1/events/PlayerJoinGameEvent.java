package me.jonasxpx.spleefx1.events;

import me.jonasxpx.spleefx1.Game;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


public class PlayerJoinGameEvent extends Event{

	private static HandlerList hand = new HandlerList();
	private Player player;
	private Game game;
	
	public PlayerJoinGameEvent(Player player) {
		this.player = player;
	}
	public PlayerJoinGameEvent(Player player, Game game) {
		this.player = player;
		this.game = game;
	}
	
	public Player getPlayer(){
		return player;
	}
	
	public Game getGame(){
		return game;
	}
	
	
	@Override
	public HandlerList getHandlers() {
		return hand;
	}

}
