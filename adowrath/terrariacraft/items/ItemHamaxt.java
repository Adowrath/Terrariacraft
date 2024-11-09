package adowrath.terrariacraft.items;

import java.util.List;
import adowrath.terrariacraft.blocks.*;
import adowrath.terrariacraft.common.Terrariacraft;
import adowrath.terrariacraft.mechanismen.MechanismusDruckplatte;
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

public class ItemHamaxt extends Item{

	public ItemHamaxt(int i) {
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
				j = 53;
				break;
			case 1:
				j = 54;
				break;
			default:
				j = Terrariacraft.ItemCheatTexture;
				break;
		}
		
		
		return j;
	}
	
	public int[] damage = {20, 20};
	
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
//    		return 3.3F + ((MetaData + 6) / 6);
//    	}
    	if(meta == 8 && block instanceof BlockMaterialien)
    	{
    		return 3.5F + ((MetaData + 6) / 5);
    	}
    	if(block instanceof BlockGlas)
    	{
    		return 4F + ((MetaData + 7) / 8);
    	}
    	
    	if(block instanceof MechanismusDruckplatte)
    	{
    		return 5F + ((MetaData +7) / 8);
    	}
//    	Class[] Wand = {WandBlock.class, WandZiegel.class};
//    	for(int i = 0; i < 2; i++){
//    		if(block instanceof Wand[i])
//    		{
//    			return 6F + ((MetaData + 7) / 5);
//    		}
//    	}
        return 0F;
    }
	
	private static final String[] subNames = 
		{
		"Meteorhamaxt", 
		"Geschmolzene Hamaxt"
		};
	
	
	@Override
	public String getItemNameIS(ItemStack itemstack) {
		return getItemName() + "." + subNames[itemstack.getItemDamage()];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void getSubItems(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 2; ix++)
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