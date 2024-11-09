package adowrath.terrariacraft.mechanismen;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemMechanismusPlatteErde extends ItemBlock
{

	public ItemMechanismusPlatteErde(int par1)
    {
        super(par1);
//        setMaxDamage(0);
    }

	private final static String[] subNames = {
		"Erddruckplatte"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	



}