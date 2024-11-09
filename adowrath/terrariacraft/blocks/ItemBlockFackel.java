package adowrath.terrariacraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemBlockFackel extends ItemBlock
{

	public ItemBlockFackel(int par1)
    {
        super(par1);
    }

	private final static String[] subNames = {
		"Fackel"
	};
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}


    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
	@Override
    public int getMetadata(int damageValue)
    {
        return damageValue;
    }

}