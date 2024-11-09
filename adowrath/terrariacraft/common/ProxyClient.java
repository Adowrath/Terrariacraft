package adowrath.terrariacraft.common;

import net.minecraftforge.client.MinecraftForgeClient;

public class ProxyClient extends ProxyServer{

		@Override
        public void registerRenderInformation()
        {
			 MinecraftForgeClient.preloadTexture("/adowrath/terrariacraft/texturen/terrain.png");
             MinecraftForgeClient.preloadTexture("/adowrath/terrariacraft/texturen/items.png");
        }

}