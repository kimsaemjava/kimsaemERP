package query;

public class PurchaseQuery {
	public static String Purchase_BASIC = "select rownum, p.* "
			                            +"from (select  * from purchase "
			                            +"   	 where state ='0' "
			                            + "      order by purchase_day desc) p "
			                            +"where rownum=1";
}
