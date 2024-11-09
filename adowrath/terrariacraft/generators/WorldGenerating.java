package adowrath.terrariacraft.generators;

import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import adowrath.terrariacraft.common.Terrariacraft;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGenerating implements IWorldGenerator 
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
			
			switch(world.provider.dimensionId)
			{
				case -1:
					generateNether(world, random, chunkX*16, chunkZ*16);
					break;
				case 0:
					generateSurface(world, random, chunkX*16, chunkZ*16);
					break;
				case 1:
					generateEnd();
					break;
			}
	}

	public void generateNether(World world, Random rand, int chunkX, int chunkZ)
	{
		//Hellstone
		if(rand.nextInt(5) >= 3){
			int randPosX = chunkX + rand.nextInt(6);
			int randPosY = rand.nextInt(128);
			int randPosZ = chunkZ + rand.nextInt(6);
			(new WorldGenMinableHell(Terrariacraft.Erze.blockID, 6, 19)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		//Kupfer
		if(rand.nextInt(5) <= 3) {
			int randPosX = chunkX + rand.nextInt(13);
			int randPosY = rand.nextInt(64);
			int randPosZ = chunkZ + rand.nextInt(13);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 0, 26)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Eisen
		if(rand.nextInt(7) <= 4) {
			int randPosX = chunkX + rand.nextInt(6);
			int randPosY = rand.nextInt(50);
			int randPosZ = chunkZ + rand.nextInt(9);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 1, 22)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Silber
		if(rand.nextInt(8) <= 4) {
			int randPosX = chunkX + rand.nextInt(7);
			int randPosY = rand.nextInt(40);
			int randPosZ = chunkZ + rand.nextInt(8);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 2, 19)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Gold
		if(rand.nextInt(10) <= 2) {
			int randPosX = chunkX + rand.nextInt(4);
			int randPosY = rand.nextInt(37);
			int randPosZ = chunkZ + rand.nextInt(6);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 3, 14)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Daemonit
		if(rand.nextInt(20) <= 2) {
			int randPosX = chunkX + rand.nextInt(3);
			int randPosY = rand.nextInt(29);
			int randPosZ = chunkZ + rand.nextInt(3);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 4, 4)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		
		//Meteorit
		if(rand.nextInt(17) == 0){
			int randPosX = chunkX + rand.nextInt(13);
			int randPosY = 50 + rand.nextInt(20);
			int randPosZ = chunkZ + rand.nextInt(15);
			(new WorldGenMinableSurfaceMeteorit(Terrariacraft.Erze.blockID, 5, 29)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Kobalt
		if(rand.nextFloat() < 0.2F){
			int randPosX = chunkX + rand.nextInt(7);
			int randPosY = rand.nextInt(26);
			int randPosZ = chunkZ + rand.nextInt(7);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 7, 17)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Mithril
		if(rand.nextFloat() < 0.15F) {
			int randPosX = chunkX + rand.nextInt(7);
			int randPosY = rand.nextInt(18);
			int randPosZ = chunkZ + rand.nextInt(7);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 8, 14)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
		//Adamantit
		if(rand.nextFloat() < 0.075F) {
			int randPosX = chunkX + rand.nextInt(7);
			int randPosY = rand.nextInt(11);
			int randPosZ = chunkZ + rand.nextInt(7);
			(new WorldGenMinableSurface(Terrariacraft.Erze.blockID, 9, 10)).generate(world, rand, randPosX, randPosY, randPosZ);
			
		}
	}

	public void generateEnd() 
	{
		
	}


}