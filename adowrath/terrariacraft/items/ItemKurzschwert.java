package adowrath.terrariacraft.items;

import java.util.List;

import adowrath.terrariacraft.common.Terrariacraft;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemKurzschwert extends Item {

	public ItemKurzschwert(int par1) {
		super(par1);
		setMaxStackSize(1);
		setHasSubtypes(true);
		setTextureFile("/adowrath/terrariacraft/texturen/items.png");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public int getIconFromDamage(int Meta)
	{
		int j;
		switch(Meta)
		{
		case 0:
			j = 64;
			break;
		case 1:
			j = 65;
			break;
		case 2:
			j = 66;
			break;
		case 3:
			j = 67;
			break;
		default:
			j = Terrariacraft.ItemCheatTexture;
			break;
		}
		return j;
	}
	
	public int[] damage = {5, 8, 9, 12};
	
    public int getDamageVsEntity(Entity par1Entity)
    {
    	int Meta = FMLClientHandler.instance().getClient().thePlayer.getCurrentEquippedItem().getItemDamage();
    	return damage[Meta];
    }
    
    private static final String[] subNames = 
	{
    	"KupferKurzschwert", 
    	"EisenKurzschwert",
		"SilberKurzschwert",
		"GoldKurzschwert"
	};
	
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 4; ix++)
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
