package adowrath.terrariacraft.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import adowrath.terrariacraft.items.*;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.world.World;

public class BlockGlas extends BlockGlass {

	public BlockGlas(int par1, int par2, boolean par4) {
		super(par1, par2, Material.glass, par4);
		setTextureFile("/adowrath/terrariacraft/texturen/terrain.png");
	}
	
	@Override
	public String getTextureFile()
	{
		return "/adowrath/terrariacraft/texturen/terrain.png";
	}
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int unknown, CreativeTabs tab, List subItems)
    {
    	for (int ix = 0; ix < 1; ix++)
    	{
    		subItems.add(new ItemStack(this, 1, ix));
    	}
    }
	
	
	@Override
	public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta)
	{
		if(player.getCurrentEquippedItem() != null)
		{
			Item temp = player.getCurrentEquippedItem().getItem();
			if(temp instanceof ItemHammer)
			{
				super.harvestBlock(world, player, x, y, z, meta);
				return;
			}
		}
		
		world.setBlockAndMetadataWithNotify(x, y, z, this.blockID, meta);
	}
	
	

}
