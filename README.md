This is a custom simple plugin made for FG Asylum to manage permissions for the different tiers we have

Sign Ex.

Ln1= [FGP] <--- lets the plugin know its our sign
Ln2= group.t2_mines <--- the permission node we want to add
Ln3= 15000 <--- the price
Ln4= group.t1_mines <--- the permission node the use needs to have to use the sign

It will check in this order:
make sure you dont have the permission were trying to get in you dont have it
we check to see if you have the permission required to get the next tier Ln4 then
we make sure the user has this amount of money and if so
we give them the node on Ln2 and were done