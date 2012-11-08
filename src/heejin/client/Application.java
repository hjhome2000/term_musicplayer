package heejin.client;

import heejin.client.scene.AbstractScene;
import heejin.client.scene.LoginScene;
import heejin.server.ServerConnector;

import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Stack;

public class Application {

	private static ServerConnector server = ServerConnector.getInstance();
	private static Stack<AbstractScene> scenes;
	private static AbstractScene topScene;
	
	private static Scanner scanner = new Scanner(new BufferedInputStream(System.in));
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 초기화
		scenes = new Stack<AbstractScene>();
		
		LoginScene loginScene = new LoginScene();
		pushScene(loginScene);
		
		scanner.close();
		getServer().closeServer();
	}
	
	public static Scanner getScanner() {
		return scanner;
	}
	
	public static ServerConnector getServer() {
		return server;
	}

	public static void closeApplication() {
		scenes.clear();
	}
	
	// 씬 관리
	public static void pushScene(AbstractScene scene) {
		System.out.println("");
		
		scenes.push(scene);
		scene.start();
		
		showTopScene();
	}
	
	public static void closeScene(AbstractScene scene) {
		scenes.remove(scene);
		
		showTopScene();
	}
	
	private static void showTopScene() {
		boolean noScene = scenes.size() == 0;
		
		if(noScene) {
			closeApplication();
			return;
		}
		
		AbstractScene scene = scenes.lastElement();
		
		if(scene != topScene) {
			scene.resume();
			topScene = scene;
		}
	}

	public static void replaceTopScene(AbstractScene scene) {
		scenes.pop();
		scenes.push(scene);
		
		showTopScene();
	}

}
