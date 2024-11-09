package adowrath.terrariacraft.ziegel;

import net.minecraft.src.*;
import net.minecraft.item.*;

public class ItemZiegelNormal extends ItemBlock
{

	public ItemZiegelNormal(int par1)
    {
        super(par1);
        setHasSubtypes(true);
    }

	private final static String[] subNames = {
		"GraueZiegel", "RoteZiegel",  "Obsidianziegel", "DrecksteinZiegel", "SchillernderZiegel", "PerlensteinZiegel", "SchneeZiegel"
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