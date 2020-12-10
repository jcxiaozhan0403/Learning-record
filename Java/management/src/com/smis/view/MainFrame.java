package com.smis.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame{
    private JDesktopPane desk;
    private JMenuBar menuBar;
    private JMenu sysMenu,clsMenu,stuMenu,couMenu,teaMenu,xkMenu,pkMenu;
    private JMenuItem rePwdItem,exitItem,clsAddItem,clsAdminItem;
    private String adminId;
    public MainFrame(String adminId) {
        this.adminId=adminId;
        desk=new JDesktopPane();
        menuBar=new JMenuBar();
        sysMenu=new JMenu("系统");
        clsMenu=new JMenu("班级管理");
        stuMenu=new JMenu("学生管理");
        couMenu=new JMenu("课程管理");
        teaMenu=new JMenu("教师管理");
        xkMenu=new JMenu("选课管理");
        pkMenu=new JMenu("排课管理");
        rePwdItem=new JMenuItem("修改密码");
        exitItem=new JMenuItem("退出系统");
        clsAddItem=new JMenuItem("添加班级");
        clsAdminItem=new JMenuItem("管理班级");
        //
        clsMenu.add(clsAddItem);
        clsMenu.add(clsAdminItem);
        sysMenu.add(rePwdItem);
        sysMenu.add(exitItem);
        menuBar.add(sysMenu);
        menuBar.add(clsMenu);
        menuBar.add(stuMenu);
        menuBar.add(couMenu);
        menuBar.add(teaMenu);
        menuBar.add(xkMenu);
        menuBar.add(pkMenu);
        //
        setContentPane(desk);
        setJMenuBar(menuBar);
        setTitle(adminId+",欢迎您！");
        setSize(500,400);
        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}