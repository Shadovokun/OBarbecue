package fr.iutinfo.skeleton.auth;

import fr.iutinfo.skeleton.api.MonUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.SecurityContext;
import java.security.Principal;

public class AppSecurityContext implements SecurityContext {
	final static Logger logger = LoggerFactory.getLogger(AppSecurityContext.class);
	private MonUser user;
	private String scheme;

	public AppSecurityContext(MonUser user, String scheme) {
		this.user = user;
		this.scheme = scheme;
	}

	@Override
	public Principal getUserPrincipal() {
		return this.user;
	}

	@Override
	public boolean isUserInRole(String s) {
		logger.debug("isUserInRole called for : " + s);
		return true;

	}

	@Override
	public boolean isSecure() {
		return "https".equals(this.scheme);
	}

	@Override
	public String getAuthenticationScheme() {
		return SecurityContext.BASIC_AUTH;
	}
}
