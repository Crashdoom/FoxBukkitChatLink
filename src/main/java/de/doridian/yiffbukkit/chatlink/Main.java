package de.doridian.yiffbukkit.chatlink;

import de.doridian.dependencies.config.Configuration;
import de.doridian.dependencies.redis.RedisManager;

import java.io.File;

public class Main {
    public static Configuration configuration;

	public static void main(String[] args) {
        configuration = new Configuration(getDataFolder());
		RedisManager.initialize(configuration);

		new RedisHandler();
        new XmlRedisHandler();

		while(true) {
			try {
				if(new File("YiffBukkitChatLink.jar.deploy").exists()) {
					System.exit(0);
					return;
				}
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

    public static File getDataFolder() {
        return new File(".");
    }
}
