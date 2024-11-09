package adowrath.terrariacraft.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import adowrath.terrariacraft.common.Terrariacraft;
import adowrath.terrariacraft.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockErze extends Block {

	public BlockErze(int i)
	{
		super(i, Material.ground);
		setStepSound(Block.soundStoneFootstep);
		setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
		setHardness(3F);
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@Override
	public String getTextureFile()
	{
		return "/adowrath/terrariacraft/texturen/terrain.png";
	}
	
	 /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
	@Override
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par2;
    }
	
	@Override
	public int idPicked (World world, int x, int y, int z) {
	    return this.blockID;
	}
	
	 /**
     * Called when a user uses the creative pick block button on this block
     * 
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
     */
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
        int id = idPicked(world, x, y, z);
        
        if (id == 0)
        {
            return null;
        }

        Item item = Item.itemsList[id];
        if (item == null)
        {
            return null;
        }

        return new ItemStack(id, 1, world.getBlockMetadata(x, y, z));
    }
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 10; ix++)
    	{
    		subItems.add(new ItemStack(this, 1, ix));
    	}
    }
    
    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int MetaData)
    {
    	if(player.getCurrentEquippedItem() != null)
    	{
    		Item temp = player.getCurrentEquippedItem().getItem();
    		int itemDamage = player.getCurrentEquippedItem().getItemDamage();
    		if(temp instanceof ItemSpitzhacke || temp instanceof ItemBohrer)
    		{
    			if(MetaData < 4)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				addAchievement(player);
    	            return;
    			}
    			
    			else if(((MetaData == 4 || MetaData == 5) && itemDamage > 2 && temp instanceof ItemSpitzhacke) || temp instanceof ItemBohrer)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				addAchievement(player);
    				return;
    			}
    			
    			else if((MetaData == 6 && itemDamage > 4 && temp instanceof ItemSpitzhacke) || temp instanceof ItemBohrer)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				addAchievement(player);
    				return;
    			}
    			
    			else if((MetaData == 7 && itemDamage  == 5 && temp instanceof ItemSpitzhacke) || temp instanceof ItemBohrer)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				addAchievement(player);
    				return;
    			}
    			
    			else if(MetaData == 8 && temp instanceof ItemBohrer)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				addAchievement(player);
    				return;
    			}
    			
    			else if(MetaData == 9 && temp instanceof ItemBohrer && itemDamage != 0)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				addAchievement(player);
    				return;
    			}
    		}
    	}
    	
    	world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, MetaData);
    	return;
    }
      
	
    public void addAchievement(EntityPlayer player)
    {
    	boolean untaken = !FMLClientHandler.instance().getClient().statFileWriter.hasAchievementUnlocked(Terrariacraft.OresOresAndOres);
        
        if(untaken){
        	player.addStat(Terrariacraft.OresOresAndOres, 1);
        }
    }
}
