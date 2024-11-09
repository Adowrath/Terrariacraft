package adowrath.terrariacraft.items;

import java.util.List;
import adowrath.terrariacraft.blocks.*;
import adowrath.terrariacraft.common.Terrariacraft;
import adowrath.terrariacraft.waende.*;
import adowrath.terrariacraft.ziegel.*;
import adowrath.terrariacraft.mechanismen.*;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class ItemHammer extends Item{

	public ItemHammer(int i) {
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
				j = 26;
				break;
			case 1:
				j = 16;
				break;
			case 2:
				j = 17;
				break;	
			case 3:
				j = 18;
				break;	
			case 4:
				j = 19;
				break;
			case 5:
				j = 20;
				break;
			case 6:
				j = 27;
				break;
			default:
				j = 0;
				break;
		}
		
		
		return j;
	}
	
	public int[] damage = {2, 4, 7, 9, 9, 24, 26};
	
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
    	if(MetaData == 6)
    	{
    		MetaData = 8;
    	}
    	if(block instanceof BlockGlas)
    	{
    		return 4F + ((MetaData + 1) / 8);
    	}
    	
    	if(block instanceof MechanismusDruckplatte)
    	{
    		return 5F + ((MetaData + 1) / 8);
    	}
    	
//    	Class[] Wand = {WandBlock.class, WandZiegel.class};
//    	for(int i = 0; i < 2; i++){
//    		if(block instanceof Wand[i])
//    		{
//    			return 6F + ((MetaData + 1) / 5);
//    		}
//    	}
    	
    	
        return 0F;
    }
	
	private static final String[] subNames = 
		{
		"Holzhammer", 
		"Kupferhammer",
		"Eisenhammer",
		"Silberhammer",
		"Goldhammer",
		"Der Brecher",
		"Pwnhammer"
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