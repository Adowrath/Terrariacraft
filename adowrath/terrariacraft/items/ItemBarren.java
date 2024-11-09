package adowrath.terrariacraft.items;

import java.util.List;

import adowrath.terrariacraft.common.Terrariacraft;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemBarren extends Item{

	public ItemBarren(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		setTextureFile("/adowrath/terrariacraft/texturen/items.png");
	}
	
	@Override
	public int getIconFromDamage(int Meta){
		if(Meta > 9)
		{
			return Terrariacraft.ItemCheatTexture;
		}
		return Meta;
	}
	
	private static final String[] subNames = 
		{
		"Kupferbarren", "Eisenbarren",
		"Silberbarren", "Goldbarren", 
		"Daemonitbarren", "Meteoritbarren", "Hoellensteinbarren", 
		"Kobaltbarren", "Mithrilbarren", "Aamantitbarren"
		};
	
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 10; ix++)
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
