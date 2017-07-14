package hello;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
		AuthenticatorImpl auth = new AuthenticatorImpl();
        bind(auth).to(Authenticator.class);
    }
}