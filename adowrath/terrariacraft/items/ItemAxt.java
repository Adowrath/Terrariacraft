package adowrath.terrariacraft.items;

import java.util.List;
import adowrath.terrariacraft.blocks.*;
import adowrath.terrariacraft.common.Terrariacraft;
import adowrath.terrariacraft.ziegel.*;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class ItemAxt extends Item{

	public ItemAxt(int i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		setMaxStackSize(1);
		setTextureFile("/adowrath/terrariacraft/texturen/items.png");
	}
	
	@Override
	public int getIconFromDamage(int i){
		int j;
		switch(i)
		{
			case 0:
				j = 48;
				break;
			case 1:
				j = 49;
				break;
			case 2:
				j = 50;
				break;
			case 3:
				j = 51;
				break;
			case 4:
				j = 52;
				break;
			default:
				j = Terrariacraft.ItemCheatTexture;
				break;
		}
				
		
		return j;
	}
	
	public int[] damage = {10, 15, 20};
	
    public int getDamageVsEntity(Entity par1Entity)
    {
    	int Meta = FMLClientHandler.instance().getClient().thePlayer.getCurrentEquippedItem().getItemDamage();
    	return damage[Meta];
    }
    
    /** FORGE: Overridden to allow custom tool effectiveness */
    @Override
    public float getStrVsBlock(ItemStack stack, Block block, int meta) 
    {
    	int MetaData = stack.getItemDamage();
//    	if(block instanceof BlockHolz)
//    	{
//    		return 3.3F + ((MetaData + 1) / 6);
//    	}
    	if(block instanceof BlockMaterialien && meta == 8)
    	{
    		return 3.5F + ((MetaData + 1) / 5);
    	}
        return 0F;
    }
	
	private static final String[] subNames = 
		{
		"Kupferaxt", 
		"Eisenaxt",
		"Silberaxt",
		"Goldaxt",
		"Kriegsaxt der Nacht"
		};
	
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 5; ix++)
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