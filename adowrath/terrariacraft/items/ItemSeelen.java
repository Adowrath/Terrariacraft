package adowrath.terrariacraft.items;

import java.util.List;

import adowrath.terrariacraft.common.Terrariacraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSeelen extends Item{

	public ItemSeelen(int i) 
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
				j = 240;
				break;
			case 1:
				j = 241;
				break;
			case 2:
				j = 242;
				break;
			case 3:
				j = 243;
				break;
			case 4:
				j = 244;
				break;
			case 5:
				j = 245;
				break;
			
			default:
				j = Terrariacraft.ItemCheatTexture;
				break;
		}
		return j;
	}
	
	private static final String[] subNames = 
		{
		"Flight", 
		"Light",
		"Night", 
		"Might", 
		"Sight", 
		"Fright"
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
