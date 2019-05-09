package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: 杨欢
 * @created: 2019-05-09 01:14
 * @description:
 */
public class ProxyTest {
	public static void main(String[] args) {
		Lenovo lenovo = new Lenovo();
		SaleComputer proxyLenovo = (SaleComputer)Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
			// 代理逻辑
			// 代理对象调用的所有方法都会触发该方法执行

			/**
			 *
			 * @param proxy     代理对象
			 * @param method    代理对象调用的方法 被封装为的对象
			 * @param args      代理对象调用的方法时 传递的实际参数
			 * @return
			 * @throws Throwable
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

				if (method.getName().equals("sale")){
					double money = (double) args[0];
					money = money * 20;
					String invoke = (String) method.invoke(lenovo, money);
					return invoke + "_鼠标";
				} else {
					Object invoke = method.invoke(lenovo, args);
					return invoke ;
				}

			}
		});

		// 动态代理
		lenovo.sale(8000);

	}
}
