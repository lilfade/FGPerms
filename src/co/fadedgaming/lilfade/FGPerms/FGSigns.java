package co.fadedgaming.lilfade.FGPerms;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

public class FGSigns implements Listener {
	
	@EventHandler
	public void signDamage(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
				//get the location of the sign to see if its authorized
				//include basic checks to make sure users arn't making free signs
				Sign s = (Sign) e.getClickedBlock().getState();
				if(s.getLine(0).equalsIgnoreCase("[FGP]")) {
					
					//setup the vars were going to be using for this
					String s1 = s.getLine(1); //get whats on line 2
					//String s2 = s.getLine(2); //get whats on line 3
					double s2 = Double.parseDouble(s.getLine(2));
					String s3 = s.getLine(3); //get whats on line 4
					//String fp = e.getPlayer().getName(); //get the players name and store it for now
					//Reference: 0= [FGP] 1= [t2_mines] 2= 15000 3= t1_mines
					
					//get the player object to use as p
					Player p = e.getPlayer();
					Economy c = FGPerms.econ;
					Permission ps = FGPerms.permission;
					//check for the required player permission against what we have on line 4
					if(!p.hasPermission(s1)) {
						if(!p.hasPermission(s3)) {
							//s.setLine(2, "no perms");
							//s.update();
							p.sendMessage("You don't have enough permissions for that!");
						} else {
						
							if(c.has(p.getName(), s2)) {
								//we has the money
								//s.setLine(2, "money");
								//s.update();
								c.withdrawPlayer(p.getName(), s2);
								ps.playerAdd("world", p.getName(), s1);
								p.sendMessage("Your money has been taken, you got perms");
							} else {
								//no money
								//s.setLine(2, "not enough");
								//s.update();
								p.sendMessage("Sorry you dont seem to have enough money for that!");
							}
						}
				} else {
					//user already has these permissions
					p.sendMessage("It seems you already have this permission!");
				}
				
				}
			} else {
				
			}
		} else {
			
		}  		//do nothing
	}
}
