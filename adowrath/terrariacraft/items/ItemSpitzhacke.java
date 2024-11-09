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

public class ItemSpitzhacke extends Item{
	
	public ItemSpitzhacke(int i) {
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
				j = 32;
				break;
			case 1:
				j = 33;
				break;
			case 2:
				j = 34;
				break;
			case 3:
				j = 35;
				break;
			case 4:
				j = 36;
				break;
			case 5:
				j = 38;
				break;
				
			default:
				j = Terrariacraft.ItemCheatTexture;
				break;
		}
		
		
		return j;
	}
	
	public int[] damage = {4, 5, 6, 6, 10, 14};
	
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
    	if(block instanceof BlockErze)
    	{
    		return 2F + (((MetaData + 1) / 3) - ((meta + 1) / 4));
    	}
    	if(block instanceof BlockEdelsteine)
    	{
    		return 3.7F + ((MetaData + 1) / 3);
    	}
    	if(block instanceof BlockMaterialien)
    	{
    		return 3F + ((MetaData + 1) / 5);
    	}
    	if(block instanceof BlockFall)
    	{
    		return 2.6F + ((MetaData + 1) / 5);
    	}
//    	if(block instanceof BlockFallKorrupt)
//    	{
//    		return 2.4F + ((MetaData + 1) / 5);
//    	}
//    	if(block instanceof BlockFallHeilig)
//    	{
//    		return 2.4F + ((MetaData + 1) / 5);
//    	}
    	if(block instanceof BlockEbenstein)
    	{
    		return 1.5F + ((MetaData + 1) / 3F);
    	}
//    	if(block instanceof BlockPerlenstein)
//    	{
//    		return 1.3F + ((MetaData + 1) / 3);
//    	}
//    	if(block instanceof BlockGras || block instanceof BlockErde)
//    	{
//    		return 3F + ((MetaData + 1) / 5);
//    	}
    	if(block instanceof ZiegelNormal)
    	{
      		return 1.9F + ((MetaData + 1) / 8);
    	}
    	if(block instanceof ZiegelErze)
    	{
    		return 1.9F + ((MetaData + 1) / 8);
    	}
    	if(block instanceof ZiegelDungeon)
      	{
    		return 1.9F + ((MetaData + 1) / 8);
      	}
    	else{
    		return 0F;
    	}
    }
	
	private static final String[] subNames = 
		{
		"Kupferspitzhacke", "Eisenspitzhacke",
		"Silberspitzhacke", "Goldspitzhacke", 
		"Alptraumspitzhacke", "Geschmolzene Spitzhacke"
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