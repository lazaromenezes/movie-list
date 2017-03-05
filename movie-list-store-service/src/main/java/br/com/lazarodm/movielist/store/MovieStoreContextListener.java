package br.com.lazarodm.movielist.store;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.servlet.GuiceServletContextListener;
import com.squarespace.jersey2.guice.JerseyGuiceModule;
import com.squarespace.jersey2.guice.JerseyGuiceUtils;

public class MovieStoreContextListener extends GuiceServletContextListener{
	@Override
	protected Injector getInjector() {
		List<Module> modules = new ArrayList<Module>();
		modules.add(new JerseyGuiceModule("__HK2_Generated_0"));
		modules.add(new MovieStoreModule());
		Injector injector = Guice.createInjector(modules);
		JerseyGuiceUtils.install(injector);
		return injector;
	}
}
