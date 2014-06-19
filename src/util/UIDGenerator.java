package util;

import java.io.Serializable;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.AbstractUUIDGenerator;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import java.util.Properties;
import org.hibernate.Hibernate;
import org.hibernate.dialect.Dialect;
import org.hibernate.type.Type;
import org.hibernate.util.PropertiesHelper;

/**
 * * <b>uuid</b><br>
 * * @author hwq
 */
public class UIDGenerator extends AbstractUUIDGenerator implements Configurable {
	private static long lastTime = System.currentTimeMillis();
	private static short lastCount = -32768;
	private static Object mutex = new Object();
	private static long ONE_SECOND = 1000L;
	private String sep = "";

	public Serializable generate(SessionImplementor session, Object obj) {
		long l = 0L;
		short word0 = 0;
		int i = 0;
		synchronized (mutex) {
			if (lastCount == 32767) {
				for (boolean flag = false; !flag;) {
					l = System.currentTimeMillis();
					if (l < lastTime + ONE_SECOND) {
						try {
							Thread.currentThread();
							Thread.sleep(ONE_SECOND);
						} catch (InterruptedException interruptedexception) {
						}
					} else {
						lastTime = l;
						lastCount = -32768;
						flag = true;
					}
				}
			} else {
				l = lastTime;
			}
			word0 = lastCount++;
			i = getHostUniqueNum();
		}
		String s = Integer.toString(i, 16) + sep + Long.toString(l, 16) + sep
				+ Integer.toString(word0, 16);
		if (s.length() > 24)
			s = s.substring(s.length() - 24);
		return s;
	}

	public Serializable generate_old(SessionImplementor session, Object obj) {
		String name = obj.getClass().getName();
		return new StringBuffer(64)
				.append(name.substring(name.lastIndexOf('.') + 1)).append(sep)
				.append((short) getIP()).append(sep)
				.append(Math.abs((short) getJVM())).append(sep)
				.append(getCount()).toString();
	}

	private static int getHostUniqueNum() {
		return (new Object()).hashCode();
	}

	public void configure(Type type, Properties params, Dialect d) {
		sep = PropertiesHelper.getString("separator", params, "");
	}

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.setProperty("separator", "");
		IdentifierGenerator gen = new UIDGenerator();
		((Configurable) gen).configure(Hibernate.STRING, props, null);
		IdentifierGenerator gen2 = new UIDGenerator();
		((Configurable) gen2).configure(Hibernate.STRING, props, null);
		for (int i = 0; i < 10; i++) {
			String id = (String) gen.generate(null, gen);
			System.out.println(id);
			String id2 = (String) gen2.generate(null, gen2);
			System.out.println(id2);
		}
	}
}