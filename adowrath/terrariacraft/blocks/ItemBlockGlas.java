package adowrath.terrariacraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemBlockGlas extends ItemBlock
{

	public ItemBlockGlas(int par1)
    {
        super(par1);
//        setMaxDamage(0);
    }

	private final static String[] subNames = {
		"Glas"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	



}