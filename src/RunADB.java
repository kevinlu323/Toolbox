import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;


public class RunADB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	//Run CMD commands and print out running results
	public static String runCMD(String CMD) throws InterruptedException {
		StringBuffer resStr = new StringBuffer();
		try{
				System.out.println("Running the following command: "+CMD);
				//Process WaitDevice=Runtime.getRuntime().exec("adb wait-for-device");
				//WaitDevice.waitFor();
				Process process = Runtime.getRuntime().exec(CMD);						
				InputStream in =process.getInputStream();
				Reader reader=new InputStreamReader(in);
				BufferedReader bReader=new BufferedReader(reader);
				for(String res="";(res=bReader.readLine())!=null;){
					resStr.append(res+"\n");				
				}
				bReader.close();
				reader.close();		
				//block running till the CMD executed.		
				process.waitFor();
			} catch(IOException e){
				e.printStackTrace();
			}
			return resStr.toString();

		}

}
