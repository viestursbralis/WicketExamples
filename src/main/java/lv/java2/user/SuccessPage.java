package lv.java2.user;

import lv.java2.XMLSigning.PrettyFormat;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.basic.MultiLineLabel;

import java.io.File;

public class SuccessPage extends WebPage {

	public SuccessPage(final PageParameters parameters) {

		String firstName = "empty";
		if (parameters.containsKey("firstName")) {
			firstName = parameters.getString("firstName");
		}

		String lastName = "empty";
		if (parameters.containsKey("lastName")) {
			lastName = parameters.getString("lastName");
		}

		int age = 0;
		if (parameters.containsKey("age")) {
			age = Integer.valueOf(parameters.getString("age"));
		}

		String nickName = "";
		if (parameters.containsKey("nickName")) {
			nickName = parameters.getString("nickName");
		}


		File output1 = new File("output1.xml");
		ReadFile readFile = new ReadFile();
		try{
			String unSignedXML = readFile.readFile("output.xml");
			PrettyFormat prettyFormat = new PrettyFormat();
			final MultiLineLabel unSigned = new MultiLineLabel("unSigned", prettyFormat.formatXML(unSignedXML));
			add(unSigned);
			String signedXML = readFile.readFile("signed_file.xml");

			final MultiLineLabel signed = new MultiLineLabel("signed", prettyFormat.formatXML(signedXML) );

			add(signed);
}

		catch (Exception e){System.out.println("Exception while reading output.xml file!"); }



		final Label result = new Label("result", " First name : " + firstName
				+ " Last name :"+lastName+" Age : " + age + " Nickname : " + nickName);


		add(result);



	}
}
