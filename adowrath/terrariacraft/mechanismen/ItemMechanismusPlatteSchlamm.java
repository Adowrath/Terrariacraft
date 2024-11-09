package adowrath.terrariacraft.mechanismen;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemMechanismusPlatteSchlamm extends ItemBlock
{

	public ItemMechanismusPlatteSchlamm(int par1)
    {
        super(par1);
//        setMaxDamage(0);
    }

	private final static String[] subNames = {
		"Schlammdruckplatte"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	



}