package heejin.client.scene;

import heejin.client.Application;
import heejin.server.ServerConnector;

public abstract class AbstractScene {
	
	protected ServerConnector getServer() {
		return Application.getServer();
	}
	
	public abstract void start();
	public abstract void resume();
	
	public void close() {
		Application.closeScene(this);
	}
}
