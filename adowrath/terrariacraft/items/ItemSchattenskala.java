package adowrath.terrariacraft.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSchattenskala extends Item{

	public ItemSchattenskala(int i) 
	{
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(99);
		setCreativeTab(CreativeTabs.tabMaterials);
		setTextureFile("/adowrath/terrariacraft/texturen/items.png");
	}
	
	private static final String[] subNames = 
	{
		"Schattenskala"
	};
	
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 1; ix++)
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
