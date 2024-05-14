package Swing;

import java.util.Vector;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileReader;
import java.awt.Color;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class Bai8 extends javax.swing.JFrame {
	String filename = "resources/data/Employees1.txt";
	Vector<String> header = new Vector<String>();
	Vector data = new Vector();
	boolean addNew = false;
	boolean changed = false;
	
	private JPanel contentPane;
	private JTextField txtCode;
	private JTextField txtName;
	private JTextField txtSalary;
	private JTable tblEmp;
	
	private void initComponents() {
		this.setTitle("Employee Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 188, 157);
		contentPane.add(scrollPane);
		
		tblEmp = new JTable();
		scrollPane.setViewportView(tblEmp);
		
		tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseReleased(java.awt.event.MouseEvent evt) {
	            tblEmpMouseReleased(evt);
	        }
	    });
		
		tblEmp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
		        tblEmpMouseClicked(evt);
		    }
	    });
		
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(10, 225, 100, 28);
		btnNew.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		        btnNewActionPerformed(evt);
		    }
		});
		contentPane.add(btnNew);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(120, 225, 100, 28);
		btnRemove.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnRemoveActionPerformed(evt);
		    }
		});
		contentPane.add(btnRemove);
		
		JButton btnSaveToFile = new JButton("Save to file");
		btnSaveToFile.setBounds(230, 225, 100, 28);
		btnSaveToFile.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSaveToFileActionPerformed(evt);
		    }
		});
		contentPane.add(btnSaveToFile);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(340, 225, 100, 28);
		btnSave.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSaveActionPerformed(evt);
		    }
		});
		contentPane.add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(450, 225, 100, 28);
		btnExit.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnExitActionPerformed(evt);
		    }
		});
		contentPane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Detail", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(261, 52, 289, 143);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCode = new JTextField();
		txtCode.setBounds(85, 26, 96, 19);
		panel.add(txtCode);
		txtCode.setColumns(10);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(85, 55, 166, 19);
		panel.add(txtName);
		
		txtSalary = new JTextField();
		txtSalary.setColumns(10);
		txtSalary.setBounds(85, 84, 96, 19);
		panel.add(txtSalary);
		
		JLabel lblNewLabel = new JLabel("Code");
		lblNewLabel.setBounds(10, 29, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 58, 45, 13);
		panel.add(lblName);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(10, 87, 45, 13);
		panel.add(lblSalary);
		
	}
	
	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
		if (changed == true)
			if (JOptionPane.showConfirmDialog(this, "Data changed. Save Y/N ?") == JOptionPane.OK_OPTION)
				btnSaveToFileActionPerformed(null);	
		System.exit(0);
	}
	
	public Bai8() {
		initComponents();
		this.setSize(600, 300);	
		header.add("Code");
		header.add("Name");
		header.add("Salary");
		loadData();
		DefaultTableModel tblModel;
		tblModel = (DefaultTableModel)this.tblEmp.getModel();
		tblModel.setDataVector(data, header);
	}
	
	private void loadData() {
		try {
			File f = new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String aDetails;
			while ((aDetails = br.readLine()) != null) {
				StringTokenizer stk = new StringTokenizer(aDetails, ",");
				String code = stk.nextToken();
				String name = stk.nextToken();
				String salaryStr = stk.nextToken();
				Vector<String> v = new Vector<String>();
				v.add(code);
				v.add(name);
				v.add(salaryStr);
				data.add(v);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "The file " + filename + " not found.");
		}
	}
	
	private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
		this.addNew = true;
		this.txtCode.setText("");
		this.txtCode.setEditable(true);
		this.txtName.setText("");
		this.txtSalary.setText("");
		this.txtCode.requestFocus();
	}
	
	private void btnSaveToFileActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			File f = new File(filename);
			PrintWriter pf = new PrintWriter(f);
			int n = this.tblEmp.getRowCount();
			for (int i = 0; i < n; i++) {
				Vector<String> v = (Vector<String>)(data.get(i));
				String S = v.get(0) + "," + v.get(1) + "," + v.get(2);
				pf.println(S);				
			}
			pf.close();
			changed = false;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {
		int pos = this.tblEmp.getSelectedRow();
		if (pos >= 0)
		{
			String code = (String)(tblEmp.getValueAt(pos, 0));
			if (JOptionPane.showConfirmDialog(this, "Delete the " + code + " employee ?") == JOptionPane.OK_OPTION)
			{
				data.remove(pos);
				tblEmp.updateUI();
				changed = true;
			}
		}
	}
	
	private void tblEmpMouseReleased(java.awt.event.MouseEvent evt) {
		if (this.tblEmp.isEditing())
		{
			int row = tblEmp.getSelectedRow();
			int column = tblEmp.getSelectedColumn();
			tblEmp.getCellEditor(row, column).cancelCellEditing();
		}
	}
	
	private void tblEmpMouseClicked(java.awt.event.MouseEvent evt) {
		int row = this.tblEmp.getSelectedRow();
		this.txtCode.setText((String)(tblEmp.getValueAt(row, 0)));
		this.txtCode.setEditable(false);
		this.txtName.setText((String)(tblEmp.getValueAt(row, 1)));
		this.txtSalary.setText((String)(tblEmp.getValueAt(row, 2)));
		addNew = false;
	}
	
	private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
		if (isValid()) return;
		String code = txtCode.getText();
		String name = txtName.getText();
		String salaryStr = txtSalary.getText();
		if (addNew)
		{
			Vector v = new Vector();
			v.add(code);
			v.add(name);
			v.add(salaryStr);
			data.add(v);
			addNew = false;
		}
		else
		{
			int pos = tblEmp.getSelectedRow();
			Vector v = (Vector)data.get(pos);
			v.set(1, name);
			v.set(2, salaryStr);
		}
		tblEmp.updateUI();
		changed = true;
	}
	
	public static void main(String[] args) {
		Bai8 gui = new Bai8();
		gui.setVisible(true);
	}
}
