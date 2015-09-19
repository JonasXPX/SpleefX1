package me.jonasxpx.spleefx1.region;

import me.jonasxpx.spleefx1.SpleefX1;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class RegionUtils {

	public static void fillBlocks(World world, Material block, String regionName){
		ProtectedRegion region = SpleefX1.getWorldGuard().getRegionManager(world).getRegion(regionName);
		BlockVector min = region.getMinimumPoint();
		BlockVector max = region.getMaximumPoint();
		int x,y,z;
		Location loc;
		while((x = min.getBlockX()) <= max.getBlockX()){
			while((y = min.getBlockY()) <= max.getBlockY()){
				while((z = min.getBlockZ()) <= max.getBlockZ()){
					loc = new Location(world, x, y, z);
					loc.getBlock().setType(block);
				}
			}
		}
	}
	
	public static void repleaceBlocks(World world, Material type, Material to, String regionName){
		ProtectedRegion region = SpleefX1.getWorldGuard().getRegionManager(world).getRegion(regionName);
		BlockVector min = region.getMinimumPoint();
		BlockVector max = region.getMaximumPoint();
		int x,y,z;
		Location loc;
		while((x = min.getBlockX()) <= max.getBlockX()){
			while((y = min.getBlockY()) <= max.getBlockY()){
				while((z = min.getBlockZ()) <= max.getBlockZ()){
					loc = new Location(world, x, y, z);
					if(loc.getBlock().getType() == type)
						loc.getBlock().setType(to);
				}
			}
		}
	}
	
	public static boolean checkFlag(World world, String regionName, StateFlag flag){
		ProtectedRegion region = SpleefX1.getWorldGuard().getRegionManager(world).getRegion(regionName);
		if(region.getFlag(flag) == StateFlag.State.ALLOW)
			return true;
		else
			return false;
	}
}
