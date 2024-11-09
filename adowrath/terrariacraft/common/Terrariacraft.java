package adowrath.terrariacraft.common;

import java.io.File;
import adowrath.terrariacraft.blocks.*;
import adowrath.terrariacraft.generators.*;
import adowrath.terrariacraft.items.*;
import adowrath.terrariacraft.mechanismen.*;
import adowrath.terrariacraft.entities.*;
import adowrath.terrariacraft.common.*;
import adowrath.terrariacraft.waende.*;
import adowrath.terrariacraft.ziegel.*;
import net.minecraft.block.Block;
import net.minecraft.block.EnumMobType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.src.*;
import net.minecraft.stats.Achievement;
import net.minecraft.world.WorldType;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="Terrariacraft", name="Terrariacraft", version="0.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Terrariacraft
{
	public static int ItemCheatTexture = 111;
	
	public static int 
	ErzeID, 
	FallID, 
	SpinnID, 
	PlatteGrauID, 
	PlatteBraunID, 
	PlatteGruenID, 
	PlatteRotID, 
	GlasID, 
	StachelID, 
	MaterialienID, 
	EdelsteinerzeID,
	ErzziegelID,
	EbensteinID,
	NormaleZiegelID,
	DungeonZiegelID,
	FackelID,
	FackelWeissID,
	FackelRotID,
	FackelGruenID,
	FackelBlauID,
	FackelGelbID,
	FackelViolettID,
	FackelVerfluchtID,
	FackelDemonID;
	
	public static Block 
	Erze, 
	Fall, 
	Spinnweben, 
	DruckPlatteGrau, 
	DruckPlatteBraun, 
	DruckPlatteGruen, 
	DruckPlatteRot, 
	Stachel, 
	Glas, 
	Materialien, 
	Edelsteinerze,
	Erzziegel,
	Ebenstein,
	NormaleZiegel,
	DungeonZiegel,
	Fackel,
	FackelWeiss,
	FackelRot,
	FackelGruen,
	FackelBlau,
	FackelGelb,
	FackelViolett,
	FackelVerflucht,
	FackelDemon;
	
	private static String[] ErzeDE = {"Kupfererz", "Eisenerz", "Silbererz", "Golderz", "D\u00E4moniterz", "Meteorit", "H\u00F6llenstein", "Kobalterz", "Mithrilerz", "Adamantiterz"};
	private static String[] ErzeEN = {"Copper Ore", "Iron Ore", "Silver Ore", "Gold Ore", "Demonite Ore", "Meteorite", "Hellstone", "Cobalt Ore", "Mythril Ore", "Adamantite Ore"};
	
	private static String[] FallDE = {"Schwemmsand", "Sand"};
	private static String[] FallEN = {"Silt", "Sand"};
	
	private static String[] SpinnwebenDE = {"Spinnweben"};
	private static String[] SpinnwebenEN = {"Cobweb"};

	private static String[] DruckPlatteGrauDE = {"Graue Druckplatte"};
	private static String[] DruckPlatteGrauEN = {"Grey Pressure Plate"};

	private static String[] DruckPlatteBraunDE = {"Braune Druckplatte"};
	private static String[] DruckPlatteBraunEN = {"Brown Pressure Plate"};

	private static String[] DruckPlatteGruenDE = {"Gr\u00FCne Druckplatte"};
	private static String[] DruckPlatteGruenEN = {"Green Pressure Plate"};

	private static String[] DruckPlatteRotDE = {"Rote Druckplatte"};
	private static String[] DruckPlatteRotEN = {"Red Pressure Plate"};

	private static String[] StachelDE = {"Stachel"};
	private static String[] StachelEN = {"Spike"};

	private static String[] GlasDE = {"Glas"};
	private static String[] GlasEN = {"Glass"};
	
	private static String[] MaterialienDE = {"Schnee", "Zuckerstange", "Gr\u00FCne Zuckerstange", "Lehm", "Schlamm", "Asche", "Stein", "Obsidian", "Holz"};
	private static String[] MaterialienEN = {"Snow", "Candy Cane", "Green Candy Cane", "Clay", "Mud", "Ash", "Stone", "Obsidian", "Wood"};
	
	private static String[] EdelsteinerzeDE = {"Diamanterz", "Rubinerz", "Smaragderz", "Saphirerz", "Topaserz", "Amethysterz"};
	private static String[] EdelsteinerzeEN = {"Diamond Ore", "Ruby Ore", "Emerald Ore", "Sapphire Ore", "Topaz Ore", "Amethyst Ore"};
	
	private static String[] ErzziegelDE = {"Kupferziegel", "Silberziegel", "Goldziegel", "D\u00E4monitziegel", "H\u00F6llensteinziegel", "Kobaltziegel", "Mithrilziegel"};
	private static String[] ErzziegelEN = {"Copper Brick", "Silver Brick", "Gold Brick", "Demonite Brick", "Hellstone Brick", "Cobalt Brick", "Mythril Brick"};
	
	private static String[] EbensteinDE = {"Ebenstein"};
	private static String[] EbensteinEN = {"Ebonstone"};
	
	private static String[] NormaleZiegelDE = {"Graue Ziegel", "Rote Ziegel", "Obsidianziegel", "Drecksteinziegel", "Schillernder Ziegel", "Perlsteinziegel", "Schneeziegel"};
	private static String[] NormaleZiegelEN = {"Grey Brick", "Red Brick", "Obsidian Brick", "Mudstone Brick", "Iridescent Brick", "Pearlstone Brick", "Snow Brick"};
	
	private static String[] DungeonZiegelDE = {"Blaue Ziegel", "Gr\u00FCne Ziegel", "Pinke Ziegel"};
	private static String[] DungeonZiegelEN = {"Blue Brick", "Green Brick", "Pink Brick"};

	private static String[] FackelDE = {"Fackel"};
	private static String[] FackelEN = {"Torch"};

	private static String[] FackelWeissDE = {"Weisse Fackel"};
	private static String[] FackelWeissEN = {"White Torch"};

	private static String[] FackelRotDE = {"Rote Fackel"};
	private static String[] FackelRotEN = {"Red Torch"};

	private static String[] FackelGruenDE = {"Gr\u00FCne Fackel"};
	private static String[] FackelGruenEN = {"Green Torch"};

	private static String[] FackelBlauDE = {"Blaue Fackel"};
	private static String[] FackelBlauEN = {"Blue Torch"};

	private static String[] FackelGelbDE = {"Gelbe Fackel"};
	private static String[] FackelGelbEN = {"Yellow Torch"};

	private static String[] FackelViolettDE = {"Violette Fackel"};
	private static String[] FackelViolettEN = {"Purple Torch"};

	private static String[] FackelVerfluchtDE = {"Verfluchte Fackel"};
	private static String[] FackelVerfluchtEN = {"Cursed Torch"};

	private static String[] FackelDemonDE = {"D\u00E4monenfackel"};
	private static String[] FackelDemonEN = {"Demon Torch"};
	
	
	
	
	public static int 
	BarrenID, 
	SpitzhackenID, 
	BohrerID, 
	HammerID, 
	EdelsteineID,
	StoffID,
	SchattenskalaID,
	AxtID,
	HamaxtID,
	KettensaegeID,
	KurzschwertID,
	SeelenID;
	
	public static Item 
	Barren, 
	Spitzhacke, 
	Bohrer,
	Hammer,
	Edelsteine,
	Stoff,
	Schattenskala,
	Axt,
	Hamaxt,
	Kettensaege,
	Kurzschwert,
	Seelen;
	
	private static String[] BarrenDE = {"Kupferbarren", "Eisenbarren", "Silberbarren", "Goldbarren", "D\u00E4monitbarren", "Meteoritbarren", "H\u00F6llensteinbarren", "Kobaltbarren", "Mithrilbarren", "Adamantitbarren"};
	private static String[] BarrenEN = {"Copper Bar", "Iron Bar", "Silver Bar", "Gold Bar", "Demonite Bar", "Meteorite Bar", "Hellstone Bar", "Cobalt Bar", "Mythril Bar", "Adamantite Bar"};
	
	private static String[] SpitzhackeDE = {"Kupferspitzhacke", "Eisenspitzhacke", "Silberspitzhacke", "Goldspitzhacke", "Alptraumspitzhacke", "Geschmolzene Spitzhacke"};
	private static String[] SpitzhackeEN = {"Copper Pickaxe", "Iron Pickaxe", "Silver Pickaxe", "Gold Pickaxe", "Nightmare Pickaxe", "Molten Pickaxe"};
	
	private static String[] BohrerDE = {"Kobaltbohrer", "Mithrilbohrer", "Adamantitbohrer"};
	private static String[] BohrerEN = {"Cobalt Drill", "Mythril Drill", "Adamantite Drill"};
	
	private static String[] HammerDE = {"Holzhammer", "Kupferhammer", "Eisenhammer", "Silberhammer", "Goldhammer", "Der Brecher", "Pwnhammer"};
	private static String[] HammerEN = {"Wooden Hammer", "Copper Hammer", "Iron Hammer", "Silver Hammer", "Gold Hammer", "The Breaker", "Pwnhammer"};

	private static String[] EdelsteineDE = {"Diamant", "Rubin", "Smaragd", "Saphir", "Topas", "Amethyst"};
	private static String[] EdelsteineEN = {"Diamond", "Ruby", "Emerald", "Sapphire", "Topaz", "Amethyst"};
	
	private static String[] StoffDE = {"Stoff"};
	private static String[] StoffEN = {"Silk"};
	
	private static String[] SchattenskalaDE = {"Schattenskala"};
	private static String[] SchattenskalaEN = {"Shadow Scale"};
	
	private static String[] AxtDE = {"Kupferaxt", "Eisenaxt", "Silberaxt", "Goldaxt", "Kriegsaxt der Nacht"};
	private static String[] AxtEN = {"Copper Axe", "Iron Axe", "Silver Axe", "Gold Axe", "War Axe of the Night"};

	private static String[] HamaxtDE = {"Meteorhamaxt", "Geschmolzene Hamaxt"};
	private static String[] HamaxtEN = {"Meteor Hamaxe", "Molten Hamaxe"};

	private static String[] KettensaegeDE = {"Kobaltkettens\u00E4ge", "Mithrilkettens\u00E4ge", "Adamantitkettens\u00E4ge"};
	private static String[] KettensaegeEN = {"Cobalt Chainsaw", "Mythril Chainsaw", "Adamantite Chainsaw"};

	private static String[] KurzschwertDE = {"Kupferkurzschwert", "Eisenkurzschwert", "Silberkurzschwert", "Goldkurzschwert"};
	private static String[] KurzschwertEN = {"Copper Shortsword", "Iron Shortsword", "Silver Shortsword", "Golden Shortsword"};

	private static String[] SeelenDE = {"Flugseele", "Lichterseele", "Nachtseele", "Seele der Macht", "Seele der Sicht", "Seele des Schreckens"};
	private static String[] SeelenEN = {"Soul of Flight", "Soul of Light", "Soul of Night", "Soul of Might", "Soul of Sight", "Soul of Fright"};
	
	
	
	
	public static Achievement
	HelpIsAlwaysGood,
	OresOresAndOres,
	ToolsPlease;
	
	public static AchievementPage TerrariacraftAchievements;
	
	
	public static CreativeTabs
	TabAxes,
	TabHamaxes,
	TabHammers,
	TabDrills,
	TabPickaxes,
	TabChainsaw,
	TabSwords,
	TabBars,
	TabGems,
	TabMaterials,
	TabOres,
	TabBricks,
	TabWalls,
	TabCommonBlocks;
	
	public static WorldType WorldTerrariacraft;
	
	
	String blockIDs = "BlockIDs";
	String ItemIDs = "ItemIDs";
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile(), true);
		config.load();
		config.addCustomCategoryComment(blockIDs, "Die IDs f\u00FCr die Bl\u00F6cke/The IDs for the Blocks");
		config.addCustomCategoryComment(ItemIDs, "Die IDs f\u00FCr die Items/The IDs for the Items");
		ErzeID 				= config.getBlock(blockIDs, "Erze/Normal Ores", 2700)							.getInt();
		FallID 				= config.getBlock(blockIDs, "Schwemm- + Sand/Sand + Silt", 2701)				.getInt();
		SpinnID 			= config.getBlock(blockIDs, "Spinnweben/Cobweb", 2702)							.getInt();
		PlatteGrauID 		= config.getBlock(blockIDs, "Graue Druckplatte/Grey Pressure Plate", 2703)		.getInt();
		PlatteBraunID 		= config.getBlock(blockIDs, "Braune Druckplatte/Brown Pressure Plate", 2704)	.getInt();
		PlatteGruenID 		= config.getBlock(blockIDs, "Gr\u00FCne Druckplatte/Green Pressure Plate", 2705).getInt();
		PlatteRotID 		= config.getBlock(blockIDs, "Rote Druckplatte/Red Pressure Plate", 2706)		.getInt();
		StachelID 			= config.getBlock(blockIDs, "Stachel/Spike", 2707)								.getInt();
		GlasID 				= config.getBlock(blockIDs, "Glas/Glass", 2708)									.getInt();
		MaterialienID 		= config.getBlock(blockIDs, "Materialien/Materials", 2709)						.getInt();
		EdelsteinerzeID		= config.getBlock(blockIDs, "Edelsteinerz/Gem Ore", 2710)						.getInt();
		ErzziegelID			= config.getBlock(blockIDs, "Erzziegel/Ore Bricks", 2011)						.getInt();
		EbensteinID			= config.getBlock(blockIDs, "Ebenstein/Ebonstone", 2712) 						.getInt();
		NormaleZiegelID		= config.getBlock(blockIDs, "Normale Ziegel/Normal Bricks", 2713)				.getInt();
		DungeonZiegelID		= config.getBlock(blockIDs, "Dungeonziegel/Dungeon Bricks", 2714)				.getInt();
		FackelID			= config.getBlock(blockIDs, "Fackel/Torch", 2715)								.getInt();
		FackelWeissID		= config.getBlock(blockIDs, "Weisse Fackel/White Torch", 2716)					.getInt();
		FackelRotID			= config.getBlock(blockIDs, "Rote Fackel/Red Torch", 2717)						.getInt();
		FackelGruenID		= config.getBlock(blockIDs, "Gr\u00FCne Fackel/Green Torch", 2718)				.getInt();
		FackelBlauID		= config.getBlock(blockIDs, "Blaue Fackel/Blue Torch", 2719)					.getInt();
		FackelGelbID		= config.getBlock(blockIDs, "Gelbe Fackel/Yellow Torch", 2720)					.getInt();
		FackelViolettID		= config.getBlock(blockIDs, "Violette Fackel/Violet Torch", 2721)				.getInt();
		FackelVerfluchtID	= config.getBlock(blockIDs, "Verfluchte Fackel/Cursed Torch", 2722)				.getInt();
		FackelDemonID		= config.getBlock(blockIDs, "D\u00E4monenfackel/Demon Torch", 2723)				.getInt();
		
		BarrenID 			= config.getItem(ItemIDs, "Barren/Bar", 5001)									.getInt();
		SpitzhackenID 		= config.getItem(ItemIDs, "Spitzhacke/Pickaxe", 5002)							.getInt();
		BohrerID 			= config.getItem(ItemIDs, "Bohrer/Drill", 5003)									.getInt();
		HammerID			= config.getItem(ItemIDs, "Hammer/Hammer", 5004)								.getInt();
		EdelsteineID 		= config.getItem(ItemIDs, "Edelstein/Gem", 5005)								.getInt();
		StoffID 			= config.getItem(ItemIDs, "Stoff/Silk", 5006)									.getInt();
		SchattenskalaID		= config.getItem(ItemIDs, "Schattenskala/Shadow Scale", 5007)					.getInt();
		AxtID				= config.getItem(ItemIDs, "Axt/Axe", 5008)										.getInt();
		HamaxtID  			= config.getItem(ItemIDs, "Hamaxt/Hamaxe", 5009)								.getInt();
		KettensaegeID		= config.getItem(ItemIDs, "Kettens\u00E4ge/Chainsaw", 5010)						.getInt();
		KurzschwertID		= config.getItem(ItemIDs, "Kurzschwerter/Shortswords", 5011)					.getInt();
		SeelenID			= config.getItem(ItemIDs, "Seelen/Souls", 5012)									.getInt();
		config.save();
	}
	
	@Instance("Terrariacraft")
	public static Terrariacraft instance;
	
	public static Terrariacraft instance(){
		return instance;
	}
	
	
	
	@Init
	public void load(FMLInitializationEvent event) {
		blocks();
		items();
		CreativeTabs();
		Achievements();

		WorldTerrariacraft = new WorldTerrariacraft(15, "Terrariacraft");
		LanguageRegistry.instance().addStringLocalization("generator.Terrariacraft", "Terrariacraft");
		
		proxy.registerRenderInformation();
		MinecraftForgeClient.preloadTexture("/adowrath/terrariacraft/texturen/terrain.png");
		MinecraftForgeClient.preloadTexture("/adowraht/terrariacraft/texturen/items.png");
		GameRegistry.registerWorldGenerator(new WorldGenerating());
		Rezepte.rezepte();
	}
	
	static String einfuegen = "Terrariacraft";
	static String de_DE = "de_DE";
	static String en_US = "en_US";
	static String en_AU = "en_AU";
	static String en_GB = "en_GB";
	
	public static void blocks()
	{
		Erze = new BlockErze(ErzeID);
		einfuegen(10, Erze, ErzeDE, ErzeEN, ItemBlockErze.class, "Erze");
				
		Fall = new BlockFall(FallID, 0).setCreativeTab(CreativeTabs.tabBlock);
		einfuegen(2, Fall, FallDE, FallEN, ItemBlockFall.class, "Fall");
		
		DruckPlatteGrau = new MechanismusDruckplatte(PlatteGrauID, 47, EnumMobType.everything, Material.ground);
		einfuegen(1, DruckPlatteGrau, DruckPlatteGrauDE, DruckPlatteGrauEN, ItemMechanismusPlatteStein.class, "Steindruckplatte");
		
		DruckPlatteBraun = new MechanismusDruckplatte(PlatteBraunID, 31, EnumMobType.everything, Material.ground);
		einfuegen(1, DruckPlatteBraun, DruckPlatteBraunDE, DruckPlatteBraunEN, ItemMechanismusPlatteErde.class, "Erddruckplatte");
		
		DruckPlatteGruen = new MechanismusDruckplatte(PlatteGruenID, 79, EnumMobType.everything, Material.ground);
		einfuegen(1, DruckPlatteGruen, DruckPlatteGruenDE, DruckPlatteGruenEN, ItemMechanismusPlatteGras.class, "Grasdruckplatte");
		
		DruckPlatteRot = new MechanismusDruckplatte(PlatteRotID, 63, EnumMobType.everything, Material.ground);
		einfuegen(1, DruckPlatteRot, DruckPlatteRotDE, DruckPlatteRotEN, ItemMechanismusPlatteSchlamm.class, "Schlammdruckplatte");
		
		Spinnweben = new BlockSpinnweben(SpinnID).setHardness(0.0F);
		einfuegen(1, Spinnweben, SpinnwebenDE, SpinnwebenEN, ItemBlockSpinnweben.class, "Spinnweben");
		
		Stachel = new BlockStachel(StachelID);
		einfuegen(1, Stachel, StachelDE, StachelEN, ItemBlockStachel.class, "Stachel");
		
		Glas = new BlockGlas(GlasID, 18, false);
		einfuegen(1, Glas, GlasDE, GlasEN, ItemBlockGlas.class, "Glas");
		
		Materialien = new BlockMaterialien(MaterialienID);
		einfuegen(9, Materialien, MaterialienDE, MaterialienEN, ItemBlockMaterialien.class, "Materialien");
		
		Edelsteinerze = new BlockEdelsteine(EdelsteinerzeID);
		einfuegen(6, Edelsteinerze, EdelsteinerzeDE, EdelsteinerzeEN, ItemBlockEdelsteine.class, "Edelsteinerze");
		
		Erzziegel = new ZiegelErze(ErzziegelID, Material.ground);
		einfuegen(7, Erzziegel, ErzziegelDE, ErzziegelEN, ItemZiegelErze.class, "Erzziegel");
		
		Ebenstein = new BlockEbenstein(EbensteinID, Material.ground);
		einfuegen(1, Ebenstein, EbensteinDE, EbensteinEN, ItemBlockEbenstein.class, "Ebenstein");
		
		NormaleZiegel = new ZiegelNormal(NormaleZiegelID, Material.ground);
		einfuegen(7, NormaleZiegel, NormaleZiegelDE, NormaleZiegelEN, ItemZiegelNormal.class, "NormaleZiegel");
		
		DungeonZiegel = new ZiegelDungeon(DungeonZiegelID, Material.ground);
		einfuegen(3, DungeonZiegel, DungeonZiegelDE, DungeonZiegelEN, ItemZiegelDungeon.class, "DungeonZiegel");
		
		Fackel = new BlockFackel(FackelID, 240).setHardness(0.0F).setLightValue(0.666666F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, Fackel, FackelDE, FackelEN, ItemBlockFackel.class, "Fackel");

		FackelWeiss = new BlockFackel(FackelWeissID, 241).setHardness(0.0F).setLightValue(1F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelWeiss, FackelWeissDE, FackelWeissEN, ItemBlockFackelWeiss.class, "FackelWeiss");
		
		FackelRot = new BlockFackel(FackelRotID, 242).setHardness(0.0F).setLightValue(0.666666F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelRot, FackelRotDE, FackelRotEN, ItemBlockFackelRot.class, "FackelRot");
		
		FackelGruen = new BlockFackel(FackelGruenID, 243).setHardness(0.0F).setLightValue(0.6F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelGruen, FackelGruenDE, FackelGruenEN, ItemBlockFackelGruen.class, "FackelGruen");
		
		FackelBlau = new BlockFackel(FackelBlauID, 244).setHardness(0.0F).setLightValue(0.6F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelBlau, FackelBlauDE, FackelBlauEN, ItemBlockFackelBlau.class, "FackelBlau");
		
		FackelGelb = new BlockFackel(FackelGelbID, 245).setHardness(0.0F).setLightValue(0.2F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelGelb, FackelGelbDE, FackelGelbEN, ItemBlockFackelGelb.class, "FackelGelb");
		
		FackelViolett = new BlockFackel(FackelViolettID, 246).setHardness(0.0F).setLightValue(0.133333F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelViolett, FackelViolettDE, FackelViolettEN, ItemBlockFackelViolett.class, "FackelViolett");
		
		FackelVerflucht = new BlockFackel(FackelVerfluchtID, 247).setHardness(0.0F).setLightValue(0.533333F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelVerflucht, FackelVerfluchtDE, FackelVerfluchtEN, ItemBlockFackelVerflucht.class, "FackelVerflucht");
		
		FackelDemon = new BlockFackel(FackelDemonID, 248).setHardness(0.0F).setLightValue(0.4666666F).setStepSound(Block.soundWoodFootstep).setRequiresSelfNotify();
		einfuegen(1, FackelDemon, FackelDemonDE, FackelDemonEN, ItemBlockFackelDemon.class, "FackelDemon");
	}
	
	public void items()
	{
		Barren = new ItemBarren(BarrenID).setCreativeTab(TabBars);
		einfuegen(10, Barren, BarrenDE, BarrenEN);
			
		Spitzhacke = new ItemSpitzhacke(SpitzhackenID);
		einfuegen(6, Spitzhacke, SpitzhackeDE, SpitzhackeEN);
		
		Bohrer = new ItemBohrer(BohrerID);
		einfuegen(3, Bohrer, BohrerDE, BohrerEN);
		
		Hammer = new ItemHammer(HammerID);
		einfuegen(7, Hammer, HammerDE, HammerEN);
		
		Edelsteine = new ItemEdelsteine(EdelsteineID);
		einfuegen(6, Edelsteine, EdelsteineDE, EdelsteineEN);
		
		Stoff = new ItemStoff(StoffID).setIconIndex(254);
		einfuegen(1, Stoff, StoffDE, StoffEN);
		
		Schattenskala = new ItemSchattenskala(SchattenskalaID).setIconIndex(255);
		einfuegen(1, Schattenskala, SchattenskalaDE, SchattenskalaEN);
		
		Axt = new ItemAxt(AxtID);
		einfuegen(5, Axt, AxtDE, AxtEN);
		
		Hamaxt = new ItemHamaxt(HamaxtID);
		einfuegen(2, Hamaxt, HamaxtDE, HamaxtEN);

		Kettensaege = new ItemKettensaege(KettensaegeID);
		einfuegen(3, Kettensaege, KettensaegeDE, KettensaegeEN);
		
		Kurzschwert = new ItemKurzschwert(KurzschwertID);
		einfuegen(4, Kurzschwert, KurzschwertDE, KurzschwertEN);
		
		Seelen = new ItemSeelen(SeelenID);
		einfuegen(6, Seelen, SeelenDE, SeelenEN);
	}
	
	public void CreativeTabs()
	{
		TabAxes = new Creativetab("TabAxes", new ItemStack(Axt, 1, 0));
		AddCreativeTabs("TabAxes", "\u00C4xte", "Axes");
		Axt.setCreativeTab(TabAxes);
		
		TabHamaxes = new Creativetab("TabHamaxes", new ItemStack(Hamaxt, 1, 0));
		AddCreativeTabs("TabHamaxes", "Ham\u00E4xte", "Hamaxes");
		Hamaxt.setCreativeTab(TabHamaxes);
		
		TabHammers = new Creativetab("TabHammers", new ItemStack(Hammer, 1, 0));
		AddCreativeTabs("TabHammers", "H\u00E4mmer", "Hammers");
		Hammer.setCreativeTab(TabHammers);
		
		TabPickaxes = new Creativetab("TabPickaxes", new ItemStack(Spitzhacke, 1, 0));
		AddCreativeTabs("TabPickaxes", "Spitzhacken", "Pickaxes");
		Spitzhacke.setCreativeTab(TabPickaxes);
		
		TabDrills = new Creativetab("TabDrills", new ItemStack(Bohrer, 1, 0));
		AddCreativeTabs("TabDrills", "Bohrer", "Drills");
		Bohrer.setCreativeTab(TabDrills);
		
		TabChainsaw = new Creativetab("TabChainsaws", new ItemStack(Kettensaege, 1, 0));
		AddCreativeTabs("TabChainsaws", "Kettens\u00E4gen", "Chainsaws");
		Kettensaege.setCreativeTab(TabChainsaw);
		
		TabSwords = new Creativetab("TabSwords", new ItemStack(Kurzschwert, 1, 1));
		AddCreativeTabs("TabSwords", "Schwerter", "Swords");
		Kurzschwert.setCreativeTab(TabSwords);
		
		TabBars = new Creativetab("TabBars", new ItemStack(Barren, 1, 1));
		AddCreativeTabs("TabBars", "Barren", "Bars");
		Barren.setCreativeTab(TabBars);
		
		TabGems = new Creativetab("TabGems", new ItemStack(Edelsteine, 1, 1));
		AddCreativeTabs("TabGems", "Edelsteine", "Gems");
		Edelsteine.setCreativeTab(TabGems);
		
		TabMaterials = new Creativetab("TabMaterials", new ItemStack(Seelen, 1, 1));
		AddCreativeTabs("TabMaterials", "Materialien", "Materials");
		Schattenskala.setCreativeTab(TabMaterials);
		Stoff.setCreativeTab(TabMaterials);
		Seelen.setCreativeTab(TabMaterials);
		
		TabOres = new Creativetab("TabOres", new ItemStack(Erze, 1, 4));
		AddCreativeTabs("TabOres", "Erze", "Ores");
		Erze.setCreativeTab(TabOres);
		Edelsteinerze.setCreativeTab(TabOres);
		
		TabBricks = new Creativetab("TabBricks", new ItemStack(Erzziegel, 1, 3));
		AddCreativeTabs("TabBricks", "Ziegel", "Bricks");
		Erzziegel.setCreativeTab(TabBricks);
		NormaleZiegel.setCreativeTab(TabBricks);
		DungeonZiegel.setCreativeTab(TabBricks);
		
//		TabWalls = new Creativetab("TabWalls", new ItemStack(DungeonWand, 1, 0));
//		AddCreativeTabs("TabWalls", "W\u00E4nde", "Walls");
//		DungeonWand.setCreativeTab(TabWalls);
		
		TabCommonBlocks = new Creativetab("TabCommonBlocks", new ItemStack(Ebenstein));
		AddCreativeTabs("TabCommonBlocks", "Bl\u00F6cke", "Blocks");
		Materialien.setCreativeTab(TabCommonBlocks);
		Glas.setCreativeTab(TabCommonBlocks);
		Stachel.setCreativeTab(TabCommonBlocks);
		Fall.setCreativeTab(TabCommonBlocks);
		Spinnweben.setCreativeTab(TabCommonBlocks);
		Ebenstein.setCreativeTab(TabCommonBlocks);
		DruckPlatteBraun.setCreativeTab(TabCommonBlocks);
		DruckPlatteGrau.setCreativeTab(TabCommonBlocks);
		DruckPlatteRot.setCreativeTab(TabCommonBlocks);
		DruckPlatteGruen.setCreativeTab(TabCommonBlocks);
	}
	
	public void Achievements()
	{
		HelpIsAlwaysGood  = (new Achievement(100, "HelpIsAlwaysGood", -5, -5, Item.book, (Achievement)null)).registerAchievement();
		this.AchievementNameAndDescreption("HelpIsAlwaysGood", "Hilfe? Aber immer!", "Frage den Guide etwas", "Help? Yes, please!", "Ask the Guide something");
		
		OresOresAndOres  = (new Achievement(101, "OresOresAndOres", 0, 0, new ItemStack(Erze, 1, 0), (Achievement)null)).registerAchievement();
		this.AchievementNameAndDescreption("OresOresAndOres", "Erze, Erze und... achja, Erze!", "Mal was neues gef\u00E4llig?", "Ores, Ores and... Oh yes, Ores!", "Would ya like something new?");
		
		ToolsPlease  = (new Achievement(102, "ToolsPlease", 1, 1, new ItemStack(Spitzhacke, 1, 1), OresOresAndOres)).registerAchievement();
		this.AchievementNameAndDescreption("ToolsPlease", "Werkzeuge, bitte!", "Kupfer? Ist das nicht lahm?", "Tools, please!", "Copper? Isn't that lame?");
		
		TerrariacraftAchievements = new AchievementPage("Terrariacraft", HelpIsAlwaysGood, OresOresAndOres, ToolsPlease);
		AchievementPage.registerAchievementPage(TerrariacraftAchievements);
	}
	
	
	public static void einfuegen(int anzahl, Block block, String[] deutsch, String[] englisch, Class<? extends ItemBlock> itemclass, String name)
	{
		GameRegistry.registerBlock(block, itemclass, name, einfuegen);
		for(int i = 0; i < anzahl; i++)
		{
			ItemStack TempStack = new ItemStack(block, 1, i);
			LanguageRegistry.instance().addNameForObject(TempStack, de_DE, deutsch[TempStack.getItemDamage()]);
			LanguageRegistry.instance().addNameForObject(TempStack, en_US, englisch[TempStack.getItemDamage()]);
			LanguageRegistry.instance().addNameForObject(TempStack, en_AU, englisch[TempStack.getItemDamage()]);
			LanguageRegistry.instance().addNameForObject(TempStack, en_GB, englisch[TempStack.getItemDamage()]);
		}
	}
	
	public static void einfuegen(int anzahl, Item item, String[] deutsch, String[] englisch)
	{
		for(int i = 0; i < anzahl; i++)
		{
			ItemStack TempStack = new ItemStack(item, 1, i);
			LanguageRegistry.instance().addNameForObject(TempStack, de_DE, deutsch[TempStack.getItemDamage()]);
			LanguageRegistry.instance().addNameForObject(TempStack, en_US, englisch[TempStack.getItemDamage()]);
			LanguageRegistry.instance().addNameForObject(TempStack, en_AU, englisch[TempStack.getItemDamage()]);
			LanguageRegistry.instance().addNameForObject(TempStack, en_GB, englisch[TempStack.getItemDamage()]);
		}
	}
	
	@SidedProxy(clientSide="adowrath.terrariacraft.common.ProxyClient",
				serverSide="adowrath.terrariacraft.common.ProxyServer")
	public static ProxyServer proxy;

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
	
	public void AchievementNameAndDescreption(String achievement, String nameDE, String descDE, String nameEN, String descEN)
	{
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement, de_DE, nameDE);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement, en_US, nameEN);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement, en_AU, nameEN);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement, en_GB, nameEN);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement + ".desc", de_DE, descDE);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement + ".desc", en_US, descEN);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement + ".desc", en_AU, descEN);
		LanguageRegistry.instance().addStringLocalization("achievement." + achievement + ".desc", en_GB, descEN);
	}
	
	public void AddCreativeTabs(String creativetab, String nameDE, String nameEN)
	{
		LanguageRegistry.instance().addStringLocalization("itemGroup." + creativetab, de_DE, nameDE);
		LanguageRegistry.instance().addStringLocalization("itemGroup." + creativetab, en_US, nameEN);
		LanguageRegistry.instance().addStringLocalization("itemGroup." + creativetab, en_AU, nameEN);
		LanguageRegistry.instance().addStringLocalization("itemGroup." + creativetab, en_GB, nameEN);
	}

}