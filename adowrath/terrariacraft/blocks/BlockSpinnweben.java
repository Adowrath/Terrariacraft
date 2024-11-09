package adowrath.terrariacraft.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.src.*;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSpinnweben extends Block
{
    public BlockSpinnweben(int par1)
    {
        super(par1, Material.air);
        setCreativeTab(CreativeTabs.tabDecorations);
        setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
        setBlockBounds(0.05F, 0.05F, 0.05F, 0.95F, 0.95F, 0.95F);
    }

    
    @Override 
    public String getTextureFile()
    {
    	return "/adowrath/terrariacraft/texturen/terrain.png";
    }
    
    @Override
    public int getBlockTextureFromSide(int side)
    {
    	return 16;
    }
    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.setInWeb();
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
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

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
