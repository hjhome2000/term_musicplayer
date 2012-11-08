package heejin.client.scene;

import heejin.client.Application;
import heejin.server.model.User;

public class ChargeScene extends AbstractScene {

	private User user;
	
	public ChargeScene(User user) {
		this.user = user;
	}
	
	@Override
	public void start() {
		System.out.println("- 충전");
		System.out.println(user.getUserName() + " - 현재 캐쉬 : " + user.getCash());
	}

	@Override
	public void resume() {
		System.out.println(">> 얼마 충전?");
		
		int cashAmount = Application.getScanner().nextInt();
		getServer().getUserController().chargeCash(user, cashAmount);
		
		System.out.println(">> " + cashAmount + " 충전 완료. 총 " + user.getCash());
		
		close();
	}

}
