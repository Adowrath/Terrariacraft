package adowrath.terrariacraft.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Creativetab extends CreativeTabs{

	protected ItemStack DisplayStack;
	
	public Creativetab(String name, ItemStack DisplayStack){
		super(name);
		this.DisplayStack = DisplayStack;
	}
	
	@Override
	public ItemStack getIconItemStack()
	{
		return DisplayStack;
		
	}

}
