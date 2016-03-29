package lv.java2;

import lv.java2.user.UserPage;
import org.apache.wicket.protocol.http.WebApplication;

public class WicketApplication extends WebApplication {

	@Override
	public Class<UserPage> getHomePage() {

		return UserPage.class; // return default page
	}

}
