package Swing;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;

public class Bai9 extends javax.swing.JFrame{
	String filename = "resources/data/Employees2.txt";
	DefaultMutableTreeNode root = null;
	DefaultMutableTreeNode curDepNode = null;
	DefaultMutableTreeNode curEmpNode = null;
	boolean addNewDep = false;
	boolean addNewEmp = false;
	
	private JPanel contentPane;
	private JTextField txtDepCode;
	private JTextField txtDepName;
	private JTextField txtEmpCode;
	private JTextField txtEmpName;
	private JTextField txtEmpSalary;
    private JTree tree;
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Department Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(276, 29, 296, 110);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dept. code");
		lblNewLabel.setBounds(21, 26, 60, 13);
		panel.add(lblNewLabel);
		
		JLabel lblDeptName = new JLabel("Dept. name");
		lblDeptName.setBounds(21, 55, 60, 13);
		panel.add(lblDeptName);
		
		txtDepCode = new JTextField();
		txtDepCode.setBounds(111, 23, 96, 19);
		panel.add(txtDepCode);
		txtDepCode.setColumns(10);
		
		txtDepName = new JTextField();
		txtDepName.setColumns(10);
		txtDepName.setBounds(111, 52, 135, 19);
		panel.add(txtDepName);
		
		JButton btnDepNew = new JButton("New");
		btnDepNew.setBounds(10, 78, 85, 21);
		btnDepNew.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDepNewActionPerformed(evt);
		    }
		});
		panel.add(btnDepNew);
		
		JButton btnDepRemove = new JButton("Remove");
		btnDepRemove.setBounds(105, 78, 85, 21);
		btnDepRemove.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDepRemoveActionPerformed(evt);
		    }
		});
		panel.add(btnDepRemove);
		
		JButton btnDepSave = new JButton("Save");
		btnDepSave.setBounds(201, 78, 85, 21);
		btnDepSave.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnDepSaveActionPerformed(evt);
		    }
		});
		panel.add(btnDepSave);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Employee Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(276, 149, 296, 162);
		contentPane.add(panel_1);
		
		JLabel lblEmpCode = new JLabel("Emp. code");
		lblEmpCode.setBounds(21, 26, 60, 13);
		panel_1.add(lblEmpCode);
		
		JLabel lblEmpName = new JLabel("Emp. name");
		lblEmpName.setBounds(21, 55, 60, 13);
		panel_1.add(lblEmpName);
		
		txtEmpCode = new JTextField();
		txtEmpCode.setColumns(10);
		txtEmpCode.setBounds(111, 23, 96, 19);
		panel_1.add(txtEmpCode);
		
		txtEmpName = new JTextField();
		txtEmpName.setColumns(10);
		txtEmpName.setBounds(111, 52, 135, 19);
		panel_1.add(txtEmpName);
		
		JButton btnEmpNew = new JButton("New");
		btnEmpNew.setBounds(10, 117, 85, 21);
		btnEmpNew.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnEmpNewActionPerformed(evt);
		    }
		});
		panel_1.add(btnEmpNew);
		
		JButton btnEmpRemove = new JButton("Remove");
		btnEmpRemove.setBounds(105, 117, 85, 21);
		btnEmpRemove.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnEmpRemoveActionPerformed(evt);
		    }
		});
		panel_1.add(btnEmpRemove);
		
		JButton btnEmpSave = new JButton("Save");
		btnEmpSave.setBounds(200, 117, 85, 21);
		btnEmpSave.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnEmpSaveActionPerformed(evt);
		    }
		});
		panel_1.add(btnEmpSave);
		
		txtEmpSalary = new JTextField();
		txtEmpSalary.setColumns(10);
		txtEmpSalary.setBounds(111, 81, 96, 19);
		panel_1.add(txtEmpSalary);
		
		JLabel lblNewLabel_2 = new JLabel("Salary");
		lblNewLabel_2.setBounds(21, 84, 45, 13);
		panel_1.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 206, 244);
		contentPane.add(scrollPane);
		
		//JTree tree = new JTree();
		tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Departments") {
				{
					
				}
			}
		));
		scrollPane.setViewportView(tree);
		
		tree.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseReleased(java.awt.event.MouseEvent evt) {
	        	treeMouseClicked(evt);
	        }
	    });
		
		JButton btnSaveFile = new JButton("Save to file");
		btnSaveFile.setBounds(10, 283, 206, 21);
		btnSaveFile.addActionListener(new java.awt.event.ActionListener() {
		    public void actionPerformed(java.awt.event.ActionEvent evt) {
		    	btnSaveFileActionPerformed(evt);
		    }
		});
		contentPane.add(btnSaveFile);
	}
	
	public Bai9() {
		initComponents();
		this.setSize(700, 360);
		root = (DefaultMutableTreeNode)(this.tree.getModel().getRoot());
		loadData();
		TreePath path = new TreePath(root);
		tree.expandPath(path);
	}
	
	private void loadData() {
		String S = "";
		StringTokenizer stk;
		try {
			FileReader f = new FileReader(filename);
			BufferedReader br = new BufferedReader(f);
			while ((S = br.readLine()) != null) {
				S = S.trim();
				if (!S.isEmpty())
				{
					boolean isDept = (S.charAt(S.length() - 1) == ':');
					stk = new StringTokenizer(S, "-:,");
					String code = stk.nextToken().trim();
					String name = stk.nextToken().trim();
					if (isDept)
					{
						curDepNode = new DefaultMutableTreeNode(new Bai9_Department(code, name));
						root.add(curDepNode);
					}
					else
					{
						int salary = Integer.parseInt(stk.nextToken().trim());
						curEmpNode = new DefaultMutableTreeNode(new Bai9_Employee(code, name, salary));
						curDepNode.add(curEmpNode);
					}
				}			
			}
			br.close();
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void viewDepAndEmp() {
		Bai9_Department curDep = null;
		Bai9_Employee curEmp = null;
		if (curDepNode != null)
			curDep = (Bai9_Department)(curDepNode.getUserObject());
		if (curEmpNode != null)
			curEmp = (Bai9_Employee)(curEmpNode.getUserObject());
		
		this.txtDepCode.setText(curDep != null ? curDep.getDepCode() : "");
		this.txtDepName.setText(curDep != null ? curDep.getDepName() : "");
		this.txtEmpCode.setText(curEmp != null ? curEmp.getEmpCode() : "");
		this.txtEmpName.setText(curEmp != null ? curEmp.getEmpName() : "");
		this.txtEmpSalary.setText("" + (curEmp != null ? curEmp.getSalary() : ""));
		this.txtDepCode.setEditable(false);
		this.txtEmpCode.setEditable(false);
	}
	
	private void treeMouseClicked(java.awt.event.MouseEvent evt) {
		tree.cancelEditing();
		TreePath path = tree.getSelectionPath();
		if (path == null)
			return;
		DefaultMutableTreeNode selectedNode = null;
		selectedNode = (DefaultMutableTreeNode)(path.getLastPathComponent());
		Object selectedObject = selectedNode.getUserObject();
		if (selectedNode == root)
			this.curDepNode = this.curEmpNode = null;
		else
		{
			if (selectedObject instanceof Bai9_Department)
			{
				this.curDepNode = selectedNode;
				this.curEmpNode = null;
			}
			else if (selectedObject instanceof Bai9_Employee)
			{
				curEmpNode = selectedNode;
				curDepNode = (DefaultMutableTreeNode)(selectedNode.getParent());
			}
		}
		viewDepAndEmp();
	}
	
	private void btnDepNewActionPerformed(java.awt.event.ActionEvent evt) {
		this.addNewDep = true;
		this.txtDepCode.setText("");
		this.txtDepName.setText("");
		this.txtEmpCode.setText("");
		this.txtEmpName.setText("");
		this.txtEmpSalary.setText("");
		this.txtDepCode.setEditable(true);
		this.txtDepCode.requestFocus();
	}
	
	private void btnDepRemoveActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.curDepNode.getChildCount() > 0)
		{
			String mag = "Remove all employees before deleting a department.";
			JOptionPane.showMessageDialog(this, mag);
		}
	}
	
	private boolean validDepDetail() {
		//
		return true;
	}
	
	private void btnDepSaveActionPerformed(java.awt.event.ActionEvent evt) {
		String code = this.txtDepCode.getText().trim().toUpperCase();
		txtDepCode.setText(code);
		String name = this.txtDepName.getText().trim();
		txtDepName.setText(name);
		if (!validDepDetail())
			return;
		if (addNewDep == true)
		{
			Bai9_Department newDep = new Bai9_Department(code, name);
			root.add(new DefaultMutableTreeNode(newDep));
		}
		else
		{
			((Bai9_Department)curDepNode.getUserObject()).setDepName(name);
		}
		this.tree.updateUI();
		this.addNewDep = false;
	}
	
	private void btnEmpNewActionPerformed(java.awt.event.ActionEvent evt) {
		this.addNewEmp = true;
		this.txtEmpCode.setText("");
		this.txtEmpName.setText("");
		this.txtEmpSalary.setText("");
		this.txtEmpCode.setEditable(true);
		this.txtEmpCode.requestFocus();
	}
	
	private void btnEmpRemoveActionPerformed(java.awt.event.ActionEvent evt) {
		if (this.curEmpNode != null)
		{
			int response = JOptionPane.showConfirmDialog(this, "Delete this employee - OK ?");
			if (response == JOptionPane.OK_OPTION)
			{
				curDepNode.remove(this.curEmpNode);
				tree.updateUI();
			}
		}
	}
	
	private boolean validEmpDetail() {
		//
		return true;
	}
	
	private void btnEmpSaveActionPerformed(java.awt.event.ActionEvent evt) {
		String code = this.txtEmpCode.getText().trim().toUpperCase();
		txtEmpCode.setText(code);
		String name = this.txtEmpName.getText().trim();
		txtEmpName.setText(name);
		String salaryStr = this.txtEmpSalary.getText().trim();
		txtEmpSalary.setText(salaryStr);
		int sal = Integer.parseInt(salaryStr);
		if (!validEmpDetail())
			return;
		if (addNewEmp == true)
		{
			Bai9_Employee newEmp = new Bai9_Employee(code, name, sal);
			curDepNode.add(new DefaultMutableTreeNode(newEmp));
		}
		else
		{
			Bai9_Employee emp = (Bai9_Employee)(curEmpNode.getUserObject());
			emp.setEmpName(name);
			emp.setSalary(sal);
		}
		this.tree.updateUI();
		this.addNewEmp = false;
	}
	
	private void btnSaveFileActionPerformed(java.awt.event.ActionEvent evt) {
		if (root.getChildCount() == 0)
			return;
		String S;
		try {
			FileWriter f = new FileWriter(filename);
			PrintWriter pf = new PrintWriter(f);
			Enumeration depts = root.children();
			while (depts.hasMoreElements()) {
				DefaultMutableTreeNode depNode = (DefaultMutableTreeNode)depts.nextElement();
				Bai9_Department dept = (Bai9_Department)(depNode.getUserObject());
				S = dept.getDepCode() + "-" + dept.getDepName() + ":";
				pf.println(S);
				Enumeration emps = depNode.children();
				while (emps.hasMoreElements()) {
					DefaultMutableTreeNode empNode = (DefaultMutableTreeNode)emps.nextElement();
					Bai9_Employee emp = (Bai9_Employee)(empNode.getUserObject());
					S = emp.getEmpCode() + "," + emp.getEmpName() + "," + emp.getSalary();
					pf.println(S);
				}
			}
			pf.close();
			f.close();
			JOptionPane.showMessageDialog(this, "Data are save to the file " + filename);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
	
	public static void main(String[] args) {
		Bai9 gui = new Bai9();
		gui.setVisible(true);
	}
}
