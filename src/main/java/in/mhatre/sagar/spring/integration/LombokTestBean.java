package in.mhatre.sagar.spring.integration;

import lombok.Data;

@Data
public class LombokTestBean {
	private int id;
	
	public static void main(String[] args) {
		LombokTestBean lombokTestBean = new LombokTestBean();
		lombokTestBean.setId(1);
		System.out.println(lombokTestBean.getId());
		System.out.println(lombokTestBean.toString());
	}
}
