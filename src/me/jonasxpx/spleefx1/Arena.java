package me.jonasxpx.spleefx1;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

import me.jonasxpx.spleefx1.region.RegionUtils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class Arena {
	
	private final World world;
	private final Material material;
	private final String arenaName;
	private final String regionName;
	private Random rm = new Random();
	
	private List<Location> spawnLoc;
	
	
	public Arena(String id, List<Location> spawnLocations, String regionName, World world, Material materialOnGround){
		this.arenaName = id;
		this.regionName = regionName;
		this.spawnLoc = spawnLocations;
		this.world = world;
		this.material = materialOnGround;
	}

	public void fillGroundRegion(){
		new BukkitRunnable() {
			@Override
			public void run() {
				RegionUtils.fillBlocks(world, material, regionName);
			}
		}.runTaskAsynchronously(SpleefX1.getInstance());
	}
	
	public Location getRandomLocation(){
		return spawnLoc.get(rm.nextInt(spawnLoc.size()));
	}
	
}
