package co.fadedgaming.lilfade.FGPerms;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;

public class FGSigns implements Listener {
	public static Economy economy = null;
	
	@EventHandler
	public void signDamage(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(e.getClickedBlock().getType() == Material.SIGN || e.getClickedBlock().getType() == Material.SIGN_POST || e.getClickedBlock().getType() == Material.WALL_SIGN) {
				Sign s = (Sign) e.getClickedBlock().getState();
				if(s.getLine(0).equalsIgnoreCase("[FGP]")) {
					
					//setup the vars were going to be using for this
					String s1 = s.getLine(1); //get whats on line 2
					String s2 = s.getLine(2); //get whats on line 3
					String s3 = s.getLine(3); //get whats on line 4
					//String fp = e.getPlayer().getName(); //get the players name and store it for now
					//Reference: 0= [FGP] 1= [t2_mines] 2= 15000 3= t1_mines
					
					//get the player object to use as p
					Player p = e.getPlayer();
					
					//check for the required player permission against what we have on line 4
					if(p.hasPermission(s3)){
						//	check money of the user now
						//EconomyResponse r = economy.bankBalance(s2);
						s.setLine(2, "no money");
						s.update();
					} else {
						//user don't have this permission node so tell them we can upgrade them
						s.setLine(2, "no perms");
						s.update();
						
					}
					
					
					//and finally if thats successful we simply add the required permissions to the user and bam were done
					
					
					
					
					//sign.setLine(2, fp);
					//sign.update();
					//do the permissions and money check against different lined eg 1= [t2_mines] 2= 15000 3= t1_mines 
				  
				  //sign.setLine(1, "hello " + e.getPlayer().getName());
				  // sign.setLine(2, s3);
				  // sign.update();
				} else {
				
				}
			} else {
			}
		} else {
		}  		//do nothing
	}
}
	/*@EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK )|| event.getAction().equals(Action.RIGHT_CLICK_AIR))
            if(event.getClickedBlock() != null)
        	event.getPlayer().sendMessage("Look! This is an event! :D");
        }*/
