import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Text;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import java.awt.Font;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;


public class Pos {

	private JFrame frame;
	private JTextField barcode;    
	private JTextField subtotal;
	private JTextField tax;
	private JTextField total;
	private JTextField cash;
	private JTextField change;
	private JTable table;
   
//	==================== functions==========================
	public void itemcost() {
		 double sum=0;
		 for(int i = 0; i < table.getRowCount(); i++)
	        {
	            sum =  sum + Double.parseDouble(table.getValueAt(i, 2).toString());            
	        }	 
		 
		 subtotal.setText(Double.toString(sum));
		         double ctotal=Double.parseDouble(subtotal.getText());
		         
		         double ctax = (ctotal*3.9)/100; 
		         String iTaxtotal =String.format("Rs %.2f", ctax);
		         tax.setText(iTaxtotal);
		         
		         String isubtotal =String.format("Rs %.2f", ctotal);
		         subtotal.setText(isubtotal);
		         
		         String itotal =String.format("Rs %.2f", ctotal+ctax);
		         total.setText(itotal);
		         
		         
		         String ibarcode =String.format("Total is %.2f", ctotal+ctax);
		         barcode.setText(ibarcode);
		         
		         
	}
	
	
	
//	==================== functions==========================
	public void change() {
		double sum =0;
		double tax = 3.9;
		double icash= Double.parseDouble(cash.getText());
		
		for(int i = 0; i < table.getRowCount();i++ )
		 {
			 sum = sum + Double.parseDouble(table.getValueAt(i, 2).toString());
			 
		 }
		  double ctax = (sum*3.9)/100; 
		  double cChange = (icash-(sum+ctax));
		  String givenchange = String.format("Rs %.2f", cChange);
		  change.setText(givenchange);
		
		
		
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pos window = new Pos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(245, 245, 220));
		frame.getContentPane().setBackground(new Color(238, 232, 170));
		frame.setResizable(false);
		frame.setBounds(100, 100, 976, 566);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		JButton burger = new JButton("burger");
		burger.setForeground(Color.WHITE);
		burger.setBackground(new Color(85, 107, 47));
		burger.setBounds(806, 133, 123, 47);
		burger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double priceofitem= 30.40;
			
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"burger","1",priceofitem} );
			
				itemcost();
			}
		});
		frame.getContentPane().setLayout(null);
		burger.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(burger);
		
		JButton btnTea = new JButton("tea");
		btnTea.setForeground(Color.WHITE);
		btnTea.setBackground(new Color(85, 107, 47));
		btnTea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 20;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"tea","1",priceofitem} );
			
				itemcost();
			}
		});
		btnTea.setBounds(806, 358, 123, 47);
		btnTea.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(btnTea);
		
		JButton btnBiryani = new JButton("biryani");
		btnBiryani.setForeground(Color.WHITE);
		btnBiryani.setBackground(new Color(85, 107, 47));
		btnBiryani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double priceofitem= 40.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"biryani","1",priceofitem} );
			
				itemcost();
				
			}
		});
		btnBiryani.setBounds(643, 17, 123, 47);
		btnBiryani.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(btnBiryani);
		
		JButton btnKaarahi = new JButton("kaarahi");
		btnKaarahi.setForeground(Color.WHITE);
		btnKaarahi.setBackground(new Color(85, 107, 47));
		btnKaarahi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 50.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"karahi","1",priceofitem} );
			
				itemcost();
			}
		});
		btnKaarahi.setBounds(806, 75, 123, 47);
		btnKaarahi.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(btnKaarahi);
		
		JButton btnkorma = new JButton("korma");
		btnkorma.setForeground(Color.WHITE);
		btnkorma.setBackground(new Color(85, 107, 47));
		btnkorma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"korma","1",priceofitem} );
			
				itemcost();
				
			}
		});
		btnkorma.setBounds(643, 75, 123, 47);
		btnkorma.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(btnkorma);
		
		JButton juice = new JButton("juice");
		juice.setForeground(Color.WHITE);
		juice.setBackground(new Color(85, 107, 47));
		juice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 10.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"juice","1",priceofitem} );
			
				itemcost();
			}
		});
		juice.setBounds(643, 358, 123, 47);
		juice.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(juice);
		
		
		
           
		
		JButton bbq = new JButton("bbq");
		bbq.setForeground(Color.WHITE);
		bbq.setBackground(new Color(85, 107, 47));
		bbq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 50.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"bbq","1",priceofitem} );
			
				itemcost();
			}
		});
		bbq.setBounds(643, 134, 123, 47);
		bbq.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(bbq);
		
		JButton fries = new JButton("fries");
		fries.setForeground(Color.WHITE);
		fries.setBackground(new Color(85, 107, 47));
		fries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"fries","1",priceofitem} );
			
				itemcost();
			}
		});
		fries.setBounds(806, 411, 123, 47);
		fries.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(fries);
		
		JButton fish = new JButton("fish");
		fish.setForeground(Color.WHITE);
		fish.setBackground(new Color(85, 107, 47));
		fish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 10.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"fish","1",priceofitem} );
			
				itemcost();
			}
		});
		fish.setBounds(806, 300, 123, 47);
		fish.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(fish);
		
		JButton dalrice = new JButton("daalrice");
		dalrice.setForeground(Color.WHITE);
		dalrice.setBackground(new Color(85, 107, 47));
		dalrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"daalrice","1",priceofitem} );
			
				itemcost();
			}
		});
		dalrice.setBounds(643, 300, 123, 47);
		dalrice.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(dalrice);
		
		JButton pulav = new JButton("pulav");
		pulav.setForeground(Color.WHITE);
		pulav.setBackground(new Color(85, 107, 47));
		pulav.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 300.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"pullav","1",priceofitem} );
			
				itemcost();
			}
		});
		pulav.setBounds(643, 184, 123, 47);
		pulav.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(pulav);
		
		JButton btnBiryani_1 = new JButton("biryani(b)");
		btnBiryani_1.setForeground(Color.WHITE);
		btnBiryani_1.setBackground(new Color(85, 107, 47));
		btnBiryani_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"biryani beef","1",priceofitem} );
			
				itemcost();
			}
		});
		btnBiryani_1.setBounds(806, 17, 123, 47);
		btnBiryani_1.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(btnBiryani_1);
		
		barcode = new JTextField();
		barcode.setHorizontalAlignment(SwingConstants.CENTER);
		barcode.setForeground(new Color(245, 245, 245));
		barcode.setBackground(new Color(85, 107, 47));
		barcode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		barcode.setBounds(336, 353, 297, 53);
		barcode.setFont(new Font("C39HrP24DhTt", Font.PLAIN, 35));
		frame.getContentPane().add(barcode);
		barcode.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(245, 245, 220));
		panel.setBackground(new Color(85, 107, 47));
		panel.setBounds(10, 11, 316, 164);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton j7 = new JButton("7");
		j7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j7.getText());
					
					
				}else {
					Enternumber = cash.getText()+j7.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
				
				
			}
		});
		j7.setForeground(Color.WHITE);
		j7.setFont(new Font("Roboto", Font.PLAIN, 17));
		j7.setBackground(new Color(85, 107, 47));
		j7.setBounds(0, 0, 71, 45);
		panel.add(j7);
		
		JButton j8 = new JButton("8");
		j8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j8.getText());
					
					
				}else {
					Enternumber = cash.getText()+j8.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j8.setForeground(Color.WHITE);
		j8.setFont(new Font("Roboto", Font.PLAIN, 17));
		j8.setBackground(new Color(85, 107, 47));
		j8.setBounds(79, 0, 71, 45);
		panel.add(j8);
		
		JButton j9 = new JButton("9");
		j9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j9.getText());
					
					
				}else {
					Enternumber = cash.getText()+j9.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j9.setForeground(Color.WHITE);
		j9.setFont(new Font("Roboto", Font.PLAIN, 17));
		j9.setBackground(new Color(85, 107, 47));
		j9.setBounds(160, 0, 71, 45);
		panel.add(j9);
		
		JButton jc = new JButton("C");
		jc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 cash.setText("");
				 change.setText("");
				
			}
	
		});
		jc.setForeground(Color.WHITE);
		jc.setFont(new Font("Roboto", Font.PLAIN, 17));
		jc.setBackground(new Color(85, 107, 47));
		jc.setBounds(241, 0, 71, 45);
		panel.add(jc);
		
		JButton j4 = new JButton("4");
		j4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j4.getText());
					
					
				}else {
					Enternumber = cash.getText()+j4.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j4.setForeground(Color.WHITE);
		j4.setFont(new Font("Roboto", Font.PLAIN, 17));
		j4.setBackground(new Color(85, 107, 47));
		j4.setBounds(0, 56, 71, 45);
		panel.add(j4);
		
		JButton j5 = new JButton("5");
		j5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j5.getText());
					
					
				}else {
					Enternumber = cash.getText()+j5.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j5.setForeground(Color.WHITE);
		j5.setFont(new Font("Roboto", Font.PLAIN, 17));
		j5.setBackground(new Color(85, 107, 47));
		j5.setBounds(79, 56, 71, 45);
		panel.add(j5);
		
		JButton j6 = new JButton("6");
		j6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j6.getText());
					
					
				}else {
					Enternumber = cash.getText()+j6.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j6.setForeground(Color.WHITE);
		j6.setFont(new Font("Roboto", Font.PLAIN, 17));
		j6.setBackground(new Color(85, 107, 47));
		j6.setBounds(160, 56, 71, 45);
		panel.add(j6);
		
		JButton j0 = new JButton("0");
		j0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j0.getText());
					
					
				}else {
					Enternumber = cash.getText()+j0.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
				
				
			}
		});
		j0.setForeground(Color.WHITE);
		j0.setFont(new Font("Roboto", Font.PLAIN, 17));
		j0.setBackground(new Color(85, 107, 47));
		j0.setBounds(241, 56, 71, 45);
		panel.add(j0);
		
		JButton jp = new JButton(".");
		jp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		if(! cash.getText().contains(".") ) {
			
			
			cash.setText(cash.getText() + jp.getText());
			
			
		}
			 	
			}
		});
		jp.setForeground(Color.WHITE);
		jp.setFont(new Font("Roboto", Font.PLAIN, 17));
		jp.setBackground(new Color(85, 107, 47));
		jp.setBounds(241, 112, 71, 45);
		panel.add(jp);
		
		JButton j3 = new JButton("3");
		j3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j3.getText());
					
					
				}else {
					Enternumber = cash.getText()+j3.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j3.setForeground(Color.WHITE);
		j3.setFont(new Font("Roboto", Font.PLAIN, 17));
		j3.setBackground(new Color(85, 107, 47));
		j3.setBounds(160, 112, 71, 45);
		panel.add(j3);
		
		JButton j2 = new JButton("2");
		j2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j2.getText());
					
					
				}else {
					Enternumber = cash.getText()+j2.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j2.setForeground(Color.WHITE);
		j2.setFont(new Font("Roboto", Font.PLAIN, 17));
		j2.setBackground(new Color(85, 107, 47));
		j2.setBounds(79, 112, 71, 45);
		panel.add(j2);
		
		JButton j1 = new JButton("1");
		j1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Enternumber = cash.getText();
				if(Enternumber.equals("")) {
					
					cash.setText(j1.getText());
					
					
				}else {
					Enternumber = cash.getText()+j1.getText() ;
					cash.setText(Enternumber);
					
				}
			 	
			}
		});
		j1.setForeground(Color.WHITE);
		j1.setFont(new Font("Roboto", Font.PLAIN, 17));
		j1.setBackground(new Color(85, 107, 47));
		j1.setBounds(0, 112, 71, 45);
		panel.add(j1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(245, 255, 250));
		panel_1.setBackground(new Color(85, 107, 47));
		panel_1.setBounds(10, 184, 316, 178);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		subtotal = new JTextField();
		subtotal.setBackground(new Color(85, 107, 47));
		subtotal.setForeground(new Color(245, 245, 245));
		subtotal.setBounds(158, 11, 148, 34);
		panel_1.add(subtotal);
		subtotal.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("SubTotal");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setBackground(new Color(240, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 138, 34);
		panel_1.add(lblNewLabel);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setForeground(new Color(245, 255, 250));
		lblTax.setBackground(new Color(240, 255, 255));
		lblTax.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblTax.setBounds(10, 56, 138, 34);
		panel_1.add(lblTax);
		
		tax = new JTextField();
		tax.setForeground(new Color(245, 245, 245));
		tax.setBackground(new Color(85, 107, 47));
		tax.setColumns(10);
		tax.setBounds(158, 56, 148, 34);
		panel_1.add(tax);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setForeground(new Color(245, 255, 250));
		lblTotal.setBackground(new Color(240, 255, 255));
		lblTotal.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblTotal.setBounds(10, 101, 138, 34);
		panel_1.add(lblTotal);
		
		total = new JTextField();
		total.setForeground(new Color(245, 245, 245));
		total.setBackground(new Color(85, 107, 47));
		total.setColumns(10);
		total.setBounds(158, 101, 148, 34);
		panel_1.add(total);
		
		JButton qeema = new JButton("qeema");
		qeema.setForeground(Color.WHITE);
		qeema.setBackground(new Color(85, 107, 47));
		qeema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                        double priceofitem= 100.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"qeema","1",priceofitem} );
			
				itemcost();
			}
		});
		qeema.setBounds(643, 242, 123, 47);
		qeema.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(qeema);
		
		JButton other = new JButton("other");
		other.setForeground(Color.WHITE);
		other.setBackground(new Color(85, 107, 47));
		other.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"other","1",priceofitem} );
			
				itemcost();
			
			
			}
		});
		other.setBounds(807, 470, 123, 47);
		other.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(other);
		
		JButton tikka = new JButton("tikka");
		tikka.setForeground(Color.WHITE);
		tikka.setBackground(new Color(85, 107, 47));
		tikka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                 double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"tikka","1",priceofitem} );
			
				itemcost();
			}
		});
		tikka.setBounds(806, 184, 123, 47);
		tikka.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(tikka);
		
		JButton malai = new JButton("malai boti");
		malai.setForeground(Color.WHITE);
		malai.setBackground(new Color(85, 107, 47));
		malai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    double priceofitem= 30.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"malai boti","1",priceofitem} );
			
				itemcost();
			}
		});
		malai.setBounds(806, 242, 123, 47);
		malai.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(malai);
		
		JButton paratha = new JButton("paratha");
		paratha.setForeground(Color.WHITE);
		paratha.setBackground(new Color(85, 107, 47));
		paratha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                double priceofitem= 30.20;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"paratha","1",priceofitem} );
			
				itemcost();
			}
		});
		paratha.setBounds(643, 470, 123, 47);
		paratha.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(paratha);
		
		JButton roll = new JButton("rollparatha");
		roll.setForeground(Color.WHITE);
		roll.setBackground(new Color(85, 107, 47));
		roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                double priceofitem= 60.40;
				
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {"rollparatha","1",priceofitem} );
			
				itemcost();
			}
		});
		roll.setBounds(643, 411, 123, 47);
		roll.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		frame.getContentPane().add(roll);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setForeground(new Color(245, 245, 220));
		panel_1_1.setBackground(new Color(85, 107, 47));
		panel_1_1.setBounds(10, 373, 316, 167);
		frame.getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(245, 245, 245));
		comboBox.setBackground(new Color(0, 128, 128));
		comboBox.setBounds(190, 11, 116, 28);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Visa Card", "Master Card"}));
		panel_1_1.add(comboBox);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method");
		lblPaymentMethod.setForeground(new Color(245, 255, 250));
		lblPaymentMethod.setBackground(new Color(240, 255, 255));
		lblPaymentMethod.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblPaymentMethod.setBounds(10, 5, 207, 34);
		panel_1_1.add(lblPaymentMethod);
		
		cash = new JTextField();
		cash.setForeground(new Color(245, 245, 245));
		cash.setBackground(new Color(85, 107, 47));
		cash.setColumns(10);
		cash.setBounds(158, 60, 148, 34);
		panel_1_1.add(cash);
		
		JLabel lblTotal_1 = new JLabel("Cash");
		lblTotal_1.setForeground(new Color(245, 255, 250));
		lblTotal_1.setBackground(new Color(240, 255, 255));
		lblTotal_1.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblTotal_1.setBounds(10, 60, 138, 34);
		panel_1_1.add(lblTotal_1);
		
		change = new JTextField();
		change.setForeground(new Color(245, 245, 245));
		change.setBackground(new Color(85, 107, 47));
		change.setColumns(10);
		change.setBounds(158, 105, 148, 34);
		panel_1_1.add(change);
		
		JLabel lblTotal_2 = new JLabel("Change");
		lblTotal_2.setForeground(new Color(245, 255, 250));
		lblTotal_2.setBackground(new Color(240, 255, 255));
		lblTotal_2.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		lblTotal_2.setBounds(10, 105, 138, 34);
		panel_1_1.add(lblTotal_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setForeground(new Color(245, 245, 220));
		panel_1_1_1.setBackground(new Color(85, 107, 47));
		panel_1_1_1.setBounds(336, 411, 297, 129);
		frame.getContentPane().add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		JButton btnNewButton_8 = new JButton("Exit");
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBackground(new Color(85, 107, 47));
		btnNewButton_8.addActionListener(new ActionListener() {
			private JFrame frame;
			public void actionPerformed(ActionEvent e) {
				
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Point of Sale",
						JOptionPane.YES_NO_OPTION) ==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnNewButton_8.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		btnNewButton_8.setBounds(41, 87, 218, 31);
		panel_1_1_1.add(btnNewButton_8);
		
		JButton btnNewButton_8_1 = new JButton("Pay");
		btnNewButton_8_1.setForeground(Color.WHITE);
		btnNewButton_8_1.setBackground(new Color(85, 107, 47));
		btnNewButton_8_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Cash")) {
					change();
					
					
				}
				else {
					cash.setText("");
					change.setText("");
				}
			}
		});
		btnNewButton_8_1.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		btnNewButton_8_1.setBounds(10, 0, 126, 31);
		panel_1_1_1.add(btnNewButton_8_1);
		
		JButton btnNewButton_8_2 = new JButton("Reset");
		btnNewButton_8_2.setForeground(Color.WHITE);
		btnNewButton_8_2.setBackground(new Color(85, 107, 47));
		btnNewButton_8_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cash.setText("");
				change.setText("");
				tax.setText("");
				total.setText("");
				subtotal.setText("");
				barcode.setText("");
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				model.setRowCount(0);
				
			}
		});
		btnNewButton_8_2.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		btnNewButton_8_2.setBounds(161, 0, 126, 31);
		panel_1_1_1.add(btnNewButton_8_2);
		
		JButton btnNewButton_8_1_1 = new JButton("Print");
		btnNewButton_8_1_1.setForeground(Color.WHITE);
		btnNewButton_8_1_1.setBackground(new Color(85, 107, 47));
		btnNewButton_8_1_1.addActionListener(new ActionListener() {
			public void actionPerformed
			(java.awt.event.ActionEvent evt) {                                          
		         MessageFormat header = new MessageFormat("Printing in progress");
		        MessageFormat footer = new MessageFormat("Page {0, number, integer}");
		        
		        try
		        {
		            table.print(JTable.PrintMode.NORMAL,header,footer);
		     
		        }
		        
		        catch(java.awt.print.PrinterException e)
		        {
		            System.err.format("No Printer found", e.getMessage());
		        }
		    }    
		});
		btnNewButton_8_1_1.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		btnNewButton_8_1_1.setBounds(10, 42, 126, 31);
		panel_1_1_1.add(btnNewButton_8_1_1);
		
		JButton btnNewButton_8_2_1 = new JButton("Remove");
		btnNewButton_8_2_1.setForeground(Color.WHITE);
		btnNewButton_8_2_1.setBackground(new Color(85, 107, 47));
		btnNewButton_8_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				DefaultTableModel model =  (DefaultTableModel) table.getModel();
				int removeItem= table.getSelectedRow();
                   if(removeItem >=0) {
                	   
                	   
                	   model.removeRow(removeItem);
                	   
                	   
                   }
                   itemcost();
                   if(comboBox.getSelectedItem().equals("Cash")) {
   					change();
   					
   					
   				}
   				else {
   					cash.setText("");
   					change.setText("");
   				}
                   
                   
				
			}
		});
		btnNewButton_8_2_1.setFont(new Font("Roboto Black", Font.PLAIN, 20));
		btnNewButton_8_2_1.setBounds(161, 42, 126, 31);
		panel_1_1_1.add(btnNewButton_8_2_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setToolTipText("");
		scrollPane.setBounds(336, 11, 297, 343);
		frame.getContentPane().add(scrollPane);
	    
		
		Object row[][]= {
   
        };
        String column[] ={"Item", "Qty", "Amount"};
		table = new JTable(row,column);
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		table.setFillsViewportHeight(true);
		table.setSurrendersFocusOnKeystroke(true);
		table.setFont(new Font("Roboto", Font.PLAIN, 15));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setToolTipText("");
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Qty", "Amount"
			}
		));
		
		table.setForeground(new Color(0, 0, 0));
		table.setBackground(new Color(60, 179, 113));
		scrollPane.setColumnHeaderView(table);
	}
}
