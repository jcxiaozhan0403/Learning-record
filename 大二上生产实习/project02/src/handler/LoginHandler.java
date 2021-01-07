package handler;

import dao.AdminDao;
import view.LoginView;
import view.MainView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginHandler extends KeyAdapter implements ActionListener {

    private LoginView loginView;
    public LoginHandler(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        String text = jButton.getText();
        if (text.equals("重置")){
            loginView.getUserTxt().setText("");
            loginView.getPwdField().setText("");
        }else if (text.equals("登录")){
            try {
                login();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void login() throws Exception {
        String user = loginView.getUserTxt().getText();
        char[] chars = loginView.getPwdField().getPassword();
        String pwd = new String(chars);

        boolean flag = AdminDao.login(user,pwd);

        if (flag) {
            //跳转+销毁
            new MainView();
            loginView.dispose();
        }else {
            JOptionPane.showMessageDialog(loginView,"用户名密码错误");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (KeyEvent.VK_ENTER == e.getKeyCode()){
            try {
                login();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
