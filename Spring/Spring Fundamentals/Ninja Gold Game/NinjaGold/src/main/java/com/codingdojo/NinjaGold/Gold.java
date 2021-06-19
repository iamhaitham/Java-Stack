package com.codingdojo.NinjaGold;
import java.util.Date;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Gold {
	private int gold=0;
	private String activity=" ";
	
	public int getGold() {
		return this.gold;
	}
	public void increaseGold(int gold) {
		this.gold+=gold;
	}
	public void decreaseGold(int gold) {
		this.gold-=gold;
	}
	public String addActivity(String activity) {
		return this.activity+=activity;
	}
	
	@RequestMapping("/Gold")
	public String index() {
		return "Gold.jsp";
	}
	
	@RequestMapping(value="/Processing", method=RequestMethod.POST)
	public String processing(HttpSession session,Model model,@RequestParam(value="myForm") String myForm) {
		if(myForm.equals("farmForm")) {
			int farmRandom=(int) Math.floor(Math.random()*(20-10+1)+10);
			increaseGold(farmRandom);
			session.setAttribute("myGold",getGold() );
			activity+="You entered a farm and earned"+ farmRandom +" gold. "+ new Date();
			session.setAttribute("myText",activity);
			return "redirect:/Gold";
		}
		else if(myForm.equals("caveForm")) {
			int caveRandom=(int) Math.floor(Math.random()*(10-5+1)+5);
			increaseGold(caveRandom);
			session.setAttribute("myGold",getGold() );
			activity+="You entered a cave and earned"+ caveRandom +" gold. "+ new Date();
			session.setAttribute("myText",activity);
			return "redirect:/Gold";
		}
		else if(myForm.equals("houseForm")){
			int houseRandom=(int) Math.floor(Math.random()*(5-2+1)+2);
			increaseGold(houseRandom);
			session.setAttribute("myGold",getGold() );
			activity+="You entered a house and earned"+ houseRandom +" gold. "+ new Date();
			session.setAttribute("myText",activity);
			return "redirect:/Gold";
		}
		else if(myForm.equals("marketForm")){
			int marketRandom=(int) Math.floor(Math.random()*(50)+Math.random()*-50);
			increaseGold(marketRandom);
			session.setAttribute("myGold",getGold());
			activity+="You entered a market and earned"+ marketRandom +" gold. "+ new Date();
			session.setAttribute("myText",activity);
			return "redirect:/Gold";
		}
		return "Error!!!";
	}
}
