package proxy;

/**
 * @author: 杨欢
 * @created: 2019-05-09 01:12
 * @description: 真实对象
 */
public class Lenovo implements SaleComputer{
	@Override
	public String sale(double money) {
		System.out.println("花了" + money + "元");
		return "联想";
	}

	@Override
	public void show() {
		System.out.println("展示电脑");
	}
}
