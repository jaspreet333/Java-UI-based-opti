import java.net.CookieHandler;
import java.net.CookieManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class RunnableDemo implements Runnable{

	 private Thread t;
	   //private String threadName;
		Statement stm=null;
		gcon k=new gcon();
		Connection d;
		ResultSet rs=null;
		
	   
	   public void run() {
		   Date today=Calendar.getInstance().getTime();
		   SimpleDateFormat sdf=new SimpleDateFormat("dd.MMM.yyyy");
		   String todaydate=sdf.format(today);
		   //String to=sdf.format(today);
		   //System.out.println(to);
		   //today.setMonth(Calendar.MONTH-6);
		   Date current = new Date();  
		   //System.out.println(current);  
		   Calendar cal = Calendar.getInstance();  
		   cal.setTime(current);  
		   cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)-6));  
		   current = cal.getTime();  
		   String to=sdf.format(current);
		   //System.out.println(to);
		   
		   //System.out.println(current);
		    //to=sdf.format(today);
		   //System.out.println(to);
		   //today= today.setFormats(new SimpleDateFormat("dd.MMM.yyyy"));
		   d=k.getDBConnection();
		   HttpUrlConnectionExample http = new HttpUrlConnectionExample();
			CookieHandler.setDefault(new CookieManager());
			boolean internet=http.isInternetReachable();
			String urlbal="http://login.smsgatewayhub.com/smsapi/CheckBalance.aspx?user=9406682786&password=888496&gwid=0";
			String message="Your prescription is not updated from last 6 months.Its required to get your checkup at City Opticals for proper care of your eyes.Eyes are most valuable.";
			//message="Hello, this is a test message.";
			message=message.replaceAll(" ", "%20");
			String sql=null;
			int countpdet=0;
			if(internet)
			{
				String pagebal = http.GetPageContent(urlbal);
				int len=pagebal.length();
				pagebal=pagebal.substring(8,len );
				sql="select count(*) as count from  pdet where dou<='"+to+"'";
				try {
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					while(rs.next())
					{
						if(rs.getString("count")!=null)
						{
							countpdet=rs.getInt("count");
						}
					}
					String arb[]=new String[countpdet];
					sql="select addr from  pdet where dou<='"+to+"'";
					stm=d.createStatement();
					rs=stm.executeQuery(sql);
					int i=0;
					while(rs.next())
					{
						
							arb[i++]=rs.getString("addr");
						
					}
					int iteration=0;
					sql="select count(*) as count from  pendingsms ";
					
						stm=d.createStatement();
						rs=stm.executeQuery(sql);
						while(rs.next())
						{
							if(rs.getString("count")!=null)
							{
								iteration=rs.getInt("count");
							}
						}
						
						while(Integer.parseInt(pagebal)>0&&iteration>0)
						{
							sql="select * from pendingsms where pid=(select max(pid) from pendingsms)";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							String mob=null,inner=null;
							while(rs.next())
							{
							
									mob=rs.getString("mobno");
									inner=rs.getString("message");
								
							}
							String url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+mob+"&sid=WEBSMS&msg="+inner+"&fl=0";
							String page = http.GetPageContent(url);
							pagebal=Integer.toString(Integer.parseInt(pagebal)-1);
							iteration=iteration-1;
							sql="delete from pendingsms where pid=(select max(pid) from pendingsms)";
							stm=d.createStatement();
							rs=stm.executeQuery(sql);
							
						}
						iteration=countpdet;
						while(Integer.parseInt(pagebal)>0&&iteration>0)
						{
							iteration=iteration-1;
							String url="http://login.smsgatewayhub.com/smsapi/pushsms.aspx?user=9406682786&pwd=888496&to="+arb[iteration]+"&sid=WEBSMS&msg="+message+"&fl=0";
							String page = http.GetPageContent(url);
							pagebal=Integer.toString(Integer.parseInt(pagebal)-1);
							sql="update pdet set dou='"+todaydate+"' where addr='"+arb[iteration]+"'";
							stm=d.createStatement();
							stm.executeUpdate(sql);
						}
						
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
	   }
	   
	   public void start ()
	   {
	      //System.out.println("Starting " +  threadName );
	      if (t == null)
	      {
	         t = new Thread (this);
	
	         t.start ();
	      }
	   }

	}

