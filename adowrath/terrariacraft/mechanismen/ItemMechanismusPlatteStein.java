package adowrath.terrariacraft.mechanismen;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemMechanismusPlatteStein extends ItemBlock
{

	public ItemMechanismusPlatteStein(int par1)
    {
        super(par1);
//        setMaxDamage(0);
    }

	private final static String[] subNames = {
		"Steindruckplatte"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	



}