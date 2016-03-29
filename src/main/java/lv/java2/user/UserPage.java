package lv.java2.user;

import lv.java2.XMLSigning.GenEnveloped;
import lv.java2.XMLSigning.Validate;
import lv.java2.databse.jdbc.DBException;
import lv.java2.databse.jdbc.UserDAO;
import lv.java2.databse.jdbc.UserDAOImpl;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;

public class UserPage extends WebPage {

	private User user = new User();
	private String nickname;



	public UserPage(final PageParameters parameters) {

		add(new FeedbackPanel("feedback"));

		final TextField<String> tFirstName = new TextField<String>("firstName",
				new PropertyModel<String>(user, "firstName"));
		final TextField<String> tLastName = new TextField<String>("lastName",
				new PropertyModel<String>(user, "lastName"));
		final TextField<Integer> tAge = new TextField<Integer>("age",
				new PropertyModel<Integer>(user, "age"));
		final TextField<String> tNickname = new TextField<String>("nickName",
				new PropertyModel<String>(user, "nickName"));

		Form<?> form = new Form<Void>("userForm") {

			@Override
			protected void onSubmit() {

				PageParameters pageParameters = new PageParameters();
				pageParameters.add("firstName", user.getFirstName());
				pageParameters.add("lastName", user.getLastName());
				pageParameters.add("age", Integer.toString(user.getAge()));
				pageParameters.add("nickName", user.getNickName());


				UserDAO userDAO = new UserDAOImpl();
				try {

					JAXBContext context = JAXBContext.newInstance(User.class);

					Marshaller m = context.createMarshaller();
					m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
					File output = new File("output.xml");
					//System.out.println(user);
					m.marshal(user,  output);

					GenEnveloped genEnveloped = new GenEnveloped();
					File signedFile = genEnveloped.crypto(output);
					Validate validation = new Validate();
					validation.validate(signedFile);

					userDAO.createNewUserInDatabase(user);
				}

				catch(DBException e){System.out.println("Database saving goes wrong!");}
				catch (Exception e){
					System.out.println("Something goes wrong with marshaling!");
				}



				setResponsePage(SuccessPage.class, pageParameters);

			}

		};

		add(form);
		form.add(tFirstName);
		form.add(tLastName);
		form.add(tAge);
		form.add(tNickname);

	}
}
