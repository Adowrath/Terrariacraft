package adowrath.terrariacraft.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;

public class ItemBlockEdelsteine extends ItemBlock
{

	public ItemBlockEdelsteine(int par1)
    {
        super(par1);
//        setMaxDamage(0);
        setHasSubtypes(true);
    }

	private final static String[] subNames = {
		"Diamanterz", "Rubinerz",  "Smaragderz", "Saphirerz", "Topaserz", "Amethysterz"
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