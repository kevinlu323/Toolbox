import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class WindowArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowArea MainWindow=new WindowArea();
		MainWindow.show();
	}
	
	JFrame frame = new JFrame("ADB Toolbox");
	JButton button_connect = new JButton("Connect to device");
	JButton button_logcat = new JButton("check device logcat");
	JButton button_wait = new JButton("Wait for device");
	JButton button_pulllog = new JButton("Pull APlogs");
	JButton button_root = new JButton("adb root");
	JButton button_rebootbootloader = new JButton("Reboot to bootloader");
	JButton button_reboot = new JButton("Reboot Device");
	JButton button_at = new JButton("AT commands");
	JButton button_appcraw = new JButton ("App Craw");
	JButton button_currentlog = new JButton("Current Log");
	JLabel label = new JLabel("ADB toolbox Beta v1.0");
	JTextField jtf = new JTextField(30);
	JTextArea jta = new JTextArea (10,40);
	JScrollPane jscrollpane=new JScrollPane(jta);
	
	JPanel button_panel = new JPanel(new GridLayout(5,2));

	public WindowArea(){
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(new java.awt.FlowLayout());
        frame.getContentPane().setLayout(new BorderLayout());
        //add action listener to the button
        button_connect.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		jtf.setText("Trying to connect to device(s)");
        		String ADBValue="";
        		// CMD /c start --will open new CMD window then exe command
				try {
					ADBValue=RunADB.runCMD("CMD /c adb devices");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Something is Wrong!");
					e.printStackTrace();
				}
				System.out.println(ADBValue);
        		jtf.setText("The following device(s) are connected: ");
        		jta.setText(ADBValue);
        	}
        });
        
        button_logcat.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
					RunADB.runCMD("CMD /c start adb logcat");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        
        button_wait.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		jtf.setText("Wait for device ready");
        		try {
					RunADB.runCMD("CMD /c start adb wait-for-device");
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("Device is ready");
        	}
        });
        
        button_reboot.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
        			RunADB.runCMD("CMD /c start adb wait-for-device");
					RunADB.runCMD("CMD /c adb reboot");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("Rebooting Device");
        	}
        });
        
        button_rebootbootloader.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
        			RunADB.runCMD("CMD /c start adb wait-for-device");
					RunADB.runCMD("CMD /c adb reboot-bootloader");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("Rebooting Device into bootloader");
        	}
        });
        
        button_pulllog.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
        			RunADB.runCMD("CMD /c start %USERPROFILE%\\Desktop\\BatchFiles\\Pull_aplog.bat");
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("Log has been pulled out to /Desktop/log");
        	}
        });
        
        button_currentlog.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
        			RunADB.runCMD("CMD /c start %USERPROFILE%\\Desktop\\BatchFiles\\cat_current_aplog.bat");
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("Log has been pulled out and saved to \\Desktop\\");
        	}
        });
        
        button_at.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
        			RunADB.runCMD("CMD /c start %USERPROFILE%\\Desktop\\BatchFiles\\AT_CFUN.bat");
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("AT commands preparation complete.");
        	}
        });
        
        button_appcraw.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		try {
        			RunADB.runCMD("CMD /c start %USERPROFILE%\\Desktop\\BatchFiles\\appcraw.bat");
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		jtf.setText("APP craw test complete.");
        	}
        });
        
        button_root.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent ae){
        		jtf.setText("Trying to connect to device(s)");
        		String ADBValue="";
        		// CMD /c start --will open new CMD window then exe command
				try {
					RunADB.runCMD("CMD /c adb root");
					RunADB.runCMD("CMD /c adb wait-for-device");
					ADBValue=RunADB.runCMD("CMD /c adb root");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Something is Wrong!");
					e.printStackTrace();
				}
				System.out.println(ADBValue);
				if (ADBValue.indexOf("adbd is already running as root")!=-1){
					jtf.setText("Successfully get root access!");
					jta.setText(ADBValue);
				}
				else {
					jtf.setText("Something Wrong while getting root access");
	        		jta.setText(ADBValue);
				}
				
        	}
        });
        
    	button_panel.add(button_connect);
    	button_panel.add(button_wait);
    	button_panel.add(button_reboot);
    	button_panel.add(button_rebootbootloader);
    	button_panel.add(button_root);
    	button_panel.add(button_pulllog);
    	button_panel.add(button_logcat);
    	button_panel.add(button_currentlog);
    	button_panel.add(button_at);
    	button_panel.add(button_appcraw);
        //set JTextField cannot be edited.
        jtf.setEditable(false);
        
        frame.getContentPane().add(button_panel,BorderLayout.EAST);
        frame.getContentPane().add(label,BorderLayout.NORTH);
        frame.getContentPane().add(jtf,BorderLayout.CENTER);
        frame.getContentPane().add(jscrollpane,BorderLayout.SOUTH);
        
        frame.setResizable(false);
        
        frame.pack();
	}
	
	public void show(){
		frame.setVisible(true);
	}
}
