package adowrath.terrariacraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemBlockSpinnweben extends ItemBlock
{

	public ItemBlockSpinnweben(int par1)
    {
        super(par1);
//        setMaxDamage(0);
    }

	private final static String[] subNames = {
		"Spinnweben"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	



}