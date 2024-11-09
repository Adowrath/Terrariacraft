package adowrath.terrariacraft.blocks;

import java.util.List;
import java.util.Random;
import adowrath.terrariacraft.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.src.*;
import net.minecraft.world.World;

public class BlockEbenstein extends Block {

	public BlockEbenstein(int i, Material mat)
	{
		super(i, mat);
		setStepSound(Block.soundStoneFootstep);
		setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
		setHardness(3F);
		blockIndexInTexture = 28;
	}
	
	@Override
	public String getTextureFile()
	{
		return "/adowrath/terrariacraft/texturen/terrain.png";
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
    			if(itemDamage > 4 && temp instanceof ItemSpitzhacke)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				return;
    			}
    			if(temp instanceof ItemBohrer)
    			{
    				super.harvestBlock(world, player, x, y, z, MetaData);
    				return;
    			}
    			
    		}
    	}
    		world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, MetaData);
    		return;
    }
      
	

}
