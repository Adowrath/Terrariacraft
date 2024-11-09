package adowrath.terrariacraft.generators;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;

public class WorldTerrariacraft extends WorldType
{      
    public WorldTerrariacraft(int par1, String par2Str)
    {
        super(par1, par2Str, 0);
        this.addNewBiome(BiomeGenBase.desert);
        this.removeBiome(BiomeGenBase.ocean);
        //You can either add or remove biomes here. This does not work well because biomes such as oceans and beaches are added in the genlayer classes and will need to be replaced through your chunk provider which is hard work.
    }

    //Sets up the biome and WorldChunkManager.
    @Override
    public WorldChunkManager getChunkManager(World world)
    {
        return new WorldChunkManager(world); //WorldChunkManager can be used but will
    }

    //Sets up the ChunkProvider. Use ChunkProviderHell for single biome worlds else use ChunkProviderGenerate or a custom provider.
    @Override
    public IChunkProvider getChunkGenerator(World world, String generatorOptions)
    {
        return new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled()); //
    }

    //Gets the spawn fuzz for players who join the world.
    @Override
    public int getSpawnFuzz()
    {
        return 100;
    }
}