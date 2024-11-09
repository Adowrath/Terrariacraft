package adowrath.terrariacraft.items;

import java.util.List;

import adowrath.terrariacraft.common.Terrariacraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemEdelsteine extends Item{

	public ItemEdelsteine(int i) 
	{
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		setTextureFile("/adowrath/terrariacraft/texturen/items.png");
	}
	
	@Override
	public int getIconFromDamage(int i){
		int j;
		switch(i)
		{
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				j = (i * 16) + 15;
				break;
			default:
				j = Terrariacraft.ItemCheatTexture;
				break;
		}
		return j;
	}
	
	private static final String[] subNames = 
		{
		"Diamant", 
		"Rubin",
		"Smaragd", 
		"Saphir", 
		"Topas", 
		"Amethyst"
		};
	
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 6; ix++)
    	{
    		subItems.add(new ItemStack(this, 1, ix));
    	}
    }
	
	
	@Override
	public String getTextureFile()
	{
		return "/adowrath/terrariacraft/texturen/items.png";
	}

}
