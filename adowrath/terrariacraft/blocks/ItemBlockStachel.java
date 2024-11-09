package adowrath.terrariacraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemBlockStachel extends ItemBlock
{

	public ItemBlockStachel(int par1)
    {
        super(par1);
//        setMaxDamage(0);
        setHasSubtypes(true);
    }

	private final static String[] subNames = {
		"Stachel"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}

}
