package adowrath.terrariacraft.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlockStachel extends Block {

	public BlockStachel(int ID) {
		super(ID, Material.rock);
//		super(ID, MaterialTerraria.furniture);
		setCreativeTab(CreativeTabs.tabDecorations);
		setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
		setBlockBounds(0.05F, 0.05F, 0.05F, 0.95F, 0.95F, 0.95F);
	}
	
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
		if(entity instanceof EntityItemFrame || entity instanceof EntityItem){

		}
		else
		{
			entity.attackEntityFrom(DamageSource.generic, 4);
		}
    }
	
	@Override
	public String getTextureFile()
	{
		return "/adowrath/terrariacraft/texturen/terrain.png";
	}
	
	@Override
	public int getBlockTextureFromSide(int side)
	{
		return 17;
	}
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 1; ix++)
    	{
    		subItems.add(new ItemStack(this, 1, ix));
    	}
    }
	
	 /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
//    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
//    {
//        return null;
//    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
