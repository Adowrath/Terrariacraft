package adowrath.terrariacraft.ziegel;

import java.util.List;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import adowrath.terrariacraft.items.*;

import net.minecraft.src.*;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ZiegelErze extends Block {

	public ZiegelErze(int i, Material mat)
	{
		super(i, mat);
		setStepSound(Block.soundStoneFootstep);
		setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
		setHardness(3F);
	}
	
	@Override
	public String getTextureFile()
	{
		return "/adowrath/terrariacraft/texturen/terrain.png";
	}
	
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	 /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
	@Override
    public int getBlockTextureFromSideAndMetadata(int par1, int Meta)
    {
        int j;
        switch(Meta)
        {
        	case 0:
        		j = 32;
        		break;
        	case 1:
        		j = 34;
        		break;
        		
        	case 2:
        		j = 35;
        		break;
        		
    	   case 3:
    		   j = 36;
    		   break;
    		   
    	   case 4:
    		   j = 38;
    		   break;
    		   
    	   case 5:
    	    	j = 39;
    	    	break;
    	    	
    	   case 6:
    		   j = 40;
    		   	break;
    		   	
    	   default:
    		   j = 0;
    		   break;
        }
        return j;
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
    	for (int ix = 0; ix < 7; ix++)
    	{
    		subItems.add(new ItemStack(this, 1, ix));
    	}
    }
    
    /**
     * Nur voruebergehend laesst
     * diese Funktion
     * normale Spitzhacken zu.
     */
    @Override
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int MetaData)
    {
    	if(player.getCurrentEquippedItem() != null)
    	{
    		Item temp = player.getCurrentEquippedItem().getItem();
    		int itemDamage = player.getCurrentEquippedItem().getItemDamage();
    		if(temp instanceof ItemSpitzhacke || temp instanceof ItemBohrer)
    		{
    			super.harvestBlock(world, player, x, y, z, MetaData);
    			return;
    		}
    	}
    		world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, MetaData);
    		return;
    }
      
	

}
