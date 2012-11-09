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
		System.out.println("- Charge");
		System.out.println(user.getUserName() + " - Current Cash : " + user.getCash());
	}

	@Override
	public void resume() {
		System.out.println(">> How much you want to charge now?");
		
		int cashAmount = Application.getScanner().nextInt();
		getServer().getUserController().chargeCash(user, cashAmount);
		
		System.out.println(">> " + cashAmount + " Charged. Now Total Cash is " + user.getCash());
		
		close();
	}

}
