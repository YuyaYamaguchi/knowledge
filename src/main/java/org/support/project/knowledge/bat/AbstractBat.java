package org.support.project.knowledge.bat;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.support.project.common.log.Log;
import org.support.project.common.log.LogFactory;
import org.support.project.common.util.PropertyUtil;
import org.support.project.knowledge.config.AppConfig;
import org.support.project.knowledge.config.SystemConfig;
import org.support.project.web.logic.DBConnenctionLogic;

public abstract class AbstractBat {
	/** ログ */
	private static Log LOG = LogFactory.getLog(AbstractBat.class);

	public static void initLogName(String logname) {
		Logger log = Logger.getRootLogger();
		FileAppender appendar= (FileAppender) log.getAppender("APP_FILEOUT");
		appendar.setFile(logname);
		appendar.activateOptions();//変更の反映
	}
	
	protected static void configInit(String batName) {
		AppConfig.initEnvKey(SystemConfig.KNOWLEDGE_ENV_KEY);
		String envValue = System.getenv(SystemConfig.KNOWLEDGE_ENV_KEY);
		LOG.info(batName + " is start.");
		if (LOG.isDebugEnabled()) {
			LOG.debug("Env [" + SystemConfig.KNOWLEDGE_ENV_KEY + "] is [" + envValue + "].");
			LOG.debug("Config :" + PropertyUtil.reflectionToString(AppConfig.get()));
		}
	}
	
	/**
	 * コネクションの接続先がカスタマイズされていたら、バッチでもカスタマイズ先を参照する
	 */
	public void dbInit() {
		DBConnenctionLogic.get().connectCustomConnection();
	}
	
	protected void send(String msg) {
		System.out.println("[SEND]" + msg);
	}

}
