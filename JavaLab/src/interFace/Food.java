package interFace;
//java.sql.Date:JDBC//class名稱不同，但package名稱相同，所以不要選錯
import java.util.Date;

import javax.xml.crypto.Data;

public class Food extends Product implements Expirable{


	@Override
	public Date 最後期限() {
		// TODO Auto-generated method stub
		return null;
	}
	
    private Date expireDate;

    public Food(String name, int price, Date expireDate) {
        super(name, price);
        this.expireDate = expireDate;
    }

    @Override
    public String desc() {
        String description = super.desc();
        description = description +",到期日："+expireDate;
        return description;
    }

}
