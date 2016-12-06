package com.wy.server;

import com.wy.server.tomcat.TomcatBootstrapHelper;


/**
 * @author jlcon
 * @version $Id: GztpayJettyBootStrap.java,v 2.0 2015-6-23 下午6:12:16 JLCON Exp $
 */
public class TomcatBootStrap {
 
	public static void main(String[] args) throws Exception {
		new TomcatBootstrapHelper(80,false, "dev").start();
	}
}
