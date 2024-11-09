package adowrath.terrariacraft.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;

public class Rezepte{

	
	public static void rezepte()
	{
		//Glas
		FurnaceRecipes.smelting().addSmelting(Terrariacraft.FallID, 1, new ItemStack(Terrariacraft.Glas, 1), 0.1F);
		
		//Barren
		for(int i = 0; i < 10; i++)
		{
			FurnaceRecipes.smelting().addSmelting(Terrariacraft.ErzeID, i, new ItemStack(Terrariacraft.Barren, 1, i), (0.2F * i) + 0.2F);
		}
		
		//Stoff
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Stoff, 1), new Object[] 
		{
			"YYY", 
			"YYY", 
			"YYY", 
			'Y', Terrariacraft.Spinnweben
		});
		
		torchRecipes();
		weaponRecipes();
		brickRecipes();
		toolsRecipes();
		tempRecipes();
	}
	
	private static void torchRecipes()
	{
//		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Fackel, 3, 0), new Object[]
//		{
//			"X",
//			"Y",
//			'X', new ItemStack(Terrariacraft.Gel),
//			'Y', new ItemStack(Terrariacraft.Materialien, 1, 8)
//		});
		for(int i = 0; i < 6; i++)
		{
			Block temp;
			switch(i)
			{
				case 0: temp = Terrariacraft.FackelWeiss; 	break;
				case 1: temp = Terrariacraft.FackelRot; 	break;
				case 2: temp = Terrariacraft.FackelGruen; 	break;
				case 3: temp = Terrariacraft.FackelBlau; 	break;
				case 4: temp = Terrariacraft.FackelGelb; 	break;
				case 5: temp = Terrariacraft.FackelViolett; break;
				default: temp = Terrariacraft.Stachel; 		break;
				
			}
			GameRegistry.addShapelessRecipe(new ItemStack(temp, 3), new Object[]
			{
				Terrariacraft.Fackel, 
				Terrariacraft.Fackel, 
				Terrariacraft.Fackel, 
				new ItemStack(Terrariacraft.Edelsteine, 1, i)
			});
		}
//		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Fackel, 33, 7), 
//			"XCX",
//			"XYX",
//			"XXX",
//			'X', new ItemStack(Terrariacraft.Fackel, 4, 0),
//			'C', new ItemStack(Terrariacraft.Fackel, 5, 0),
//			'Y', new ItemStack(Terrariacraft.VerfluchteFlamme)
//		);
	}

	private static void weaponRecipes()
	{
		//Kupferkurzschwert
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kurzschwert, 1, 0), new Object[] 
		{
			"YYZ", 
			"YZY", 
			"XYY", 
			'X', new ItemStack(Terrariacraft.Barren, 1, 0),
			'Z', new ItemStack(Terrariacraft.Barren, 3, 0)
		});
		//Eisenkurzschwert
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kurzschwert, 1, 1), new Object[] 
		{
			"YYZ", 
			"YZY", 
			"XYY", 
			'X', new ItemStack(Terrariacraft.Barren, 1, 1),
			'Z', new ItemStack(Terrariacraft.Barren, 3, 1)
		});
		//Silberkurzschwert
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kurzschwert, 1, 2), new Object[] 
		{
			"YYC", 
			"YZY", 
			"XYY", 
			'X', new ItemStack(Terrariacraft.Barren, 1, 2),
			'Z', new ItemStack(Terrariacraft.Barren, 3, 2),
			'C', new ItemStack(Terrariacraft.Barren, 2, 2)
		});
		//Goldkurzschwert
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kurzschwert, 1, 3), new Object[] 
		{
			"YYZ", 
			"YZY", 
			"XYY", 
			'X', new ItemStack(Terrariacraft.Barren, 1, 3),
			'Z', new ItemStack(Terrariacraft.Barren, 3, 3)
		});
	}
	
	private static void brickRecipes()
	{
		//Kupferziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 1, 0), new Object[]
		{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Erze, 1, 0)
		});
		//Silberziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 1, 1), new Object[]
		{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Erze, 1, 2)
		});
		//Goldziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 1, 2), new Object[]
		{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Erze, 1, 3)
		});
		//Daemonitziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 5, 3), new Object[]
		{
			Terrariacraft.Ebenstein, Terrariacraft.Ebenstein, Terrariacraft.Ebenstein, Terrariacraft.Ebenstein,	new ItemStack(Terrariacraft.Erze, 1, 4)
		});
		//Hoellensteinziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 1, 4), new Object[]
		{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Erze, 1, 6)
		});
		//Kobaltziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 1, 5), new Object[]
		{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Erze, 1, 7)
		});
		//Mithrilziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.Erzziegel, 1, 6), new Object[]
		{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Erze, 1, 8)
		});
		
		//Graue Ziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
			new ItemStack(Terrariacraft.Materialien, 1, 6), new ItemStack(Terrariacraft.Materialien, 1, 6)
		});
		//Rote Ziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
			new ItemStack(Terrariacraft.Materialien, 1, 3), new ItemStack(Terrariacraft.Materialien, 1, 3)
		});
		//Obsidianziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
			new ItemStack(Terrariacraft.Materialien, 1, 7), new ItemStack(Terrariacraft.Materialien, 1, 7)
		});
		//Drecksteinziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
			new ItemStack(Terrariacraft.Materialien, 1, 4), new ItemStack(Terrariacraft.Materialien, 1, 6)
		});
		//Schillernder Ziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
			new ItemStack(Terrariacraft.Materialien, 1, 5), new ItemStack(Terrariacraft.Materialien, 1, 6)
		});
//		//Perlsteinziegel
//		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
//			Terrariacraft.Perlenstein, Terrariacraft.FallHeilig
//		});
		//Schneeziegel
		GameRegistry.addShapelessRecipe(new ItemStack(Terrariacraft.NormaleZiegel, 1, 0), new Object[]{
			new ItemStack(Terrariacraft.Materialien, 1, 0), new ItemStack(Terrariacraft.Materialien, 1, 0)
		});
	}

	private static void toolsRecipes()
	{
		//Holzhammer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hammer, 1, 0), new Object[]
		{
			"VCV", 
			"XCX", 
			"OCO", 
			'X', new ItemStack(Block.planks, 2),
			'V', new ItemStack(Block.planks, 2),
			'C', new ItemStack(Terrariacraft.Materialien, 1, 8)
		});
		//Kupferhammer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hammer, 1, 1), new Object[]
		{
			"VCV", 
			"XCX", 
			"OCO", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 0),
			'V', new ItemStack(Terrariacraft.Barren, 2, 0),
			'C', new ItemStack(Terrariacraft.Materialien, 1, 8)
		});
		//Eisenhammer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hammer, 1, 2), new Object[]
		{
			"VCV", 
			"XCX", 
			"OCO", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 1),
			'V', new ItemStack(Terrariacraft.Barren, 2, 1),
			'C', new ItemStack(Terrariacraft.Materialien, 1, 8)
		});
		//Silberhammer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hammer, 1, 3), new Object[]
		{
			"VCV", 
			"XCX", 
			"OCO", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 2),
			'V', new ItemStack(Terrariacraft.Barren, 2, 2),
			'C', new ItemStack(Terrariacraft.Materialien, 1, 8)
		});
		//Goldhammer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hammer, 1, 4), new Object[]
		{
			"VCV", 
			"XCX", 
			"OCO", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 3),
			'V', new ItemStack(Terrariacraft.Barren, 2, 3),
			'C', new ItemStack(Terrariacraft.Materialien, 1, 8)
		});
		//Der Brecher
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hammer, 1, 5), new Object[]
		{
			"VYV", 
			"XCX", 
			"OCO", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 4),
			'V', new ItemStack(Terrariacraft.Barren, 2, 4),
			'C', new ItemStack(Terrariacraft.Schattenskala, 2),
			'Y', new ItemStack(Terrariacraft.Schattenskala, 1)
		});
		
		
		
		//Kobaltbohrer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Bohrer, 1, 0), new Object[]
		{
			"YXX", 
			"XYX", 
			"YXY", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 7)
		});
		//Mythrilbohrer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Bohrer, 1, 1), new Object[]
		{
			"YXX", 
			"XYX", 
			"YXY", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 8)
		});
		//Adamantitbohrer
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Bohrer, 1, 2), new Object[]
		{
			"YCC", 
			"XYC", 
			"YXY", 
			'X', new ItemStack(Terrariacraft.Barren, 3, 9),
			'C', new ItemStack(Terrariacraft.Barren, 4, 9)
		});
						
			
		//Kupferspitzhacke
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Spitzhacke, 1, 0), new Object[]
		{
			"XXX", 
			"YCY", 
			"YCY", 
			'X', new ItemStack(Terrariacraft.Barren, 4, 0),
			'C', new ItemStack(Terrariacraft.Materialien, 2, 8)
		});
		//Eisenspitzhacke
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Spitzhacke, 1, 1), new Object[]
		{
			"XXX", 
			"YCY", 
			"YCY", 
			'X', new ItemStack(Terrariacraft.Barren, 4, 1),
			'C', new ItemStack(Terrariacraft.Materialien, 2, 8)
		});
		//Silberspitzhacke
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Spitzhacke, 1, 2), new Object[]
		{
			"XXX", 
			"YCY", 
			"YCY", 
			'X', new ItemStack(Terrariacraft.Barren, 4, 2),
			'C', new ItemStack(Terrariacraft.Materialien, 2, 8)
		});
		//Goldspitzhacke
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Spitzhacke, 1, 3), new Object[]
		{
			"XXX", 
			"YCY", 
			"YCY", 
			'X', new ItemStack(Terrariacraft.Barren, 4, 3),
			'C', new ItemStack(Terrariacraft.Materialien, 2, 8)
		});
		//Alptraumspitzhacke
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Spitzhacke, 1, 4), new Object[]
		{
			"XXX", 
			"YCY", 
			"YCY", 
			'X', new ItemStack(Terrariacraft.Barren, 4, 4),
			'C', new ItemStack(Terrariacraft.Schattenskala, 3)
		});
		//Geschmolzene Spitzhacke
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Spitzhacke, 1, 5), new Object[]
		{
			"XXX", 
			"YCY", 
			"YCY", 
			'X', new ItemStack(Terrariacraft.Barren, 4, 6),
			'C', new ItemStack(Terrariacraft.Materialien, 2, 8)
		});
		
		//Kupferaxt
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Axt, 1, 0), new Object[]
		{
			"BSX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 5, 0),
			'S', new ItemStack(Terrariacraft.Materialien, 1, 8),
			'D', new ItemStack(Terrariacraft.Barren, 4, 0)
		});
		//Eisenaxt
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Axt, 1, 1), new Object[]
		{
			"BSX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 5, 1),
			'S', new ItemStack(Terrariacraft.Materialien, 1, 8),
			'D', new ItemStack(Terrariacraft.Barren, 4, 1)
		});
		//Silberaxt
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Axt, 1, 2), new Object[]
		{
			"BSX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 5, 2),
			'S', new ItemStack(Terrariacraft.Materialien, 1, 8),
			'D', new ItemStack(Terrariacraft.Barren, 4, 2)
		});
		//Goldaxt
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Axt, 1, 3), new Object[]
		{
			"BSX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 5, 3),
			'S', new ItemStack(Terrariacraft.Materialien, 1, 8),
			'D', new ItemStack(Terrariacraft.Barren, 4, 3)
		});
		//Kriegsaxt der Nacht
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Axt, 1, 4), new Object[]
		{
			"BSX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 4, 4),
			'S', new ItemStack(Terrariacraft.Barren, 1, 4),
			'D', new ItemStack(Terrariacraft.Barren, 3, 4)
		});
		
		//Meteorhamaxt
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hamaxt, 1, 0), new Object[]
		{
			"BBX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 9, 5),
			'S', new ItemStack(Terrariacraft.Barren, 5, 5),
			'D', new ItemStack(Terrariacraft.Barren, 7, 6)
		});
		//Geschmolzene Hamaxt
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Hamaxt, 1, 1), new Object[]
		{
			"BBX",
			"DSX",
			"XSX",
			'B', new ItemStack(Terrariacraft.Barren, 9, 6),
			'S', new ItemStack(Terrariacraft.Barren, 5, 6),
			'D', new ItemStack(Terrariacraft.Barren, 7, 6)
		});
		
		//Kobaltkettensaege
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kettensaege, 1, 0), new Object[]
		{
			"BCX",
			"BBC",
			"BCX",
			'B', new ItemStack(Terrariacraft.Barren, 1, 7),
			'C', new ItemStack(Terrariacraft.Barren, 2, 7)
		});
		//Kobaltkettensaege
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kettensaege, 1, 1), new Object[]
		{
			"BCX",
			"BBC",
			"BCX",
			'B', new ItemStack(Terrariacraft.Barren, 1, 8),
			'C', new ItemStack(Terrariacraft.Barren, 2, 8)
		});
		//Kobaltkettensaege
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Kettensaege, 1, 2), new Object[]
		{
			"BCX",
			"BCD",
			"BCX",
			'B', new ItemStack(Terrariacraft.Barren, 1, 9),
			'C', new ItemStack(Terrariacraft.Barren, 2, 9),
			'D', new ItemStack(Terrariacraft.Barren, 3, 9)
		});
	}
	
	private static void tempRecipes() {
		GameRegistry.addRecipe(new ItemStack(Terrariacraft.Materialien, 8, 8),
			"X",
			"X",
			'X', Block.wood
		);
	}
}
