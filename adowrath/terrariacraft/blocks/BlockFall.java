package adowrath.terrariacraft.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import adowrath.terrariacraft.entities.EntityFall;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import adowrath.terrariacraft.items.*;

public class BlockFall extends BlockSand{

	public BlockFall(int i, int par2) 
	{
		super(i, par2, Material.sand);
		setStepSound(Block.soundSandFootstep);
		setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
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
	    return par2 + 14;
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta)
	{
		if(player.getCurrentEquippedItem() != null)
		{
			Item temp = player.getCurrentEquippedItem().getItem();
			if(temp instanceof ItemSpitzhacke || temp instanceof ItemBohrer)
			{
				super.harvestBlock(world, player, x, y, z, meta);
				return;
			}
		}
		
		world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, meta);
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
		for (int ix = 0; ix < 2; ix++)
		{
			subItems.add(new ItemStack(this, 1, ix));
	  	}
	}
	
	/**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            this.tryToFall(par1World, par2, par3, par4);
        }
    }

    /**
     * If there is space to fall below will start this block falling
     */
    private void tryToFall(World par1World, int par2, int par3, int par4)
    {
        if (canFallBelow(par1World, par2, par3 - 1, par4) && par3 >= 0)
        {
            byte var8 = 32;

            if (!fallInstantly && par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
            {
                if (!par1World.isRemote)
                {
                    EntityFall var9 = new EntityFall(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), this.blockID, par1World.getBlockMetadata(par2, par3, par4));
                    this.onStartFalling(var9);
                    par1World.spawnEntityInWorld(var9);
                }
            }
            else
            {
                par1World.setBlockWithNotify(par2, par3, par4, 0);

                while (canFallBelow(par1World, par2, par3 - 1, par4) && par3 > 0)
                {
                    --par3;
                }

                if (par3 > 0)
                {
                    par1World.setBlockWithNotify(par2, par3, par4, this.blockID);
                }
            }
        }
    }

    /**
     * Called when the falling block entity for this block is created
     */
    protected void onStartFalling(EntityFall var9) {}

    /**
     * How many world ticks before ticking
     */
    public int tickRate()
    {
        return 5;
    }

    /**
     * Checks to see if the sand can fall into the block below it
     */
    public static boolean canFallBelow(World par0World, int par1, int par2, int par3)
    {
        int var4 = par0World.getBlockId(par1, par2, par3);

        if (var4 == 0)
        {
            return true;
        }
        else if (var4 == Block.fire.blockID)
        {
            return true;
        }
        else
        {
            Material var5 = Block.blocksList[var4].blockMaterial;
            return var5 == Material.water ? true : var5 == Material.lava;
        }
    }

    /**
     * Called when the falling block entity for this block hits the ground and turns back into a block
     */
    public void onFinishFalling(World par1World, int par2, int par3, int par4, int par5) {}
}
