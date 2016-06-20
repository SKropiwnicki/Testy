package com.example.webguidemo;

import com.example.webguidemo.pages.SetupProjectLink;
import org.jbehave.web.selenium.WebDriverProvider;

import com.example.webguidemo.pages.SetupProjectLink;
import com.example.webguidemo.pages.Home;

public class Pages {

	private WebDriverProvider driverProvider;

	//Pages
	private Home home;
	private SetupProjectLink setupProjectLink;
	// ...

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Home home() {
		if (home == null) {
			home = new Home(driverProvider);
		}
		return home;
	}

	public SetupProjectLink setupProjectLink(){
		if (setupProjectLink == null) {
			setupProjectLink = new SetupProjectLink(driverProvider);
		}
		return setupProjectLink;
	}
}
