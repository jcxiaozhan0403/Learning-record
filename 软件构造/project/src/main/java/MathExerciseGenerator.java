import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MathExerciseGenerator {
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("数学习题生成器");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // 创建控件
        JLabel label = new JLabel("请输入要生成的习题数量：");

        JTextField textField = new JTextField(10);
        JButton generateButton = new JButton("生成习题");
        JButton importButton = new JButton("导入习题");
        JButton exportButton = new JButton("导出习题");
        JTextArea textArea = new JTextArea();
        // 添加控件到窗口
        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(label);
        inputPanel.add(textField);
        inputPanel.add(generateButton);
        inputPanel.add(importButton);
        inputPanel.add(exportButton);
        frame.add(inputPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(600, 300));
        frame.add(scrollPane, BorderLayout.CENTER);

        // 为按钮添加事件处理器
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取用户输入的习题数量
                String input = textField.getText();
                int numQuestions = Integer.parseInt(input);

                // 生成指定数量的习题，并将它们展示在界面上
                String[] questions = generateQuestions(numQuestions);
                displayQuestions(questions, textArea);
            }
        });

        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 让用户选择要导入的文件
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    // 读取文件内容并展示在界面上
                    try {
                        String[] questions = readQuestionsFromCSV(file);
                        displayQuestions(questions, textArea);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "导入习题时出错：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 让用户选择要保存的文件
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    // 读取文件内容并展示在界面上
                    try {
                        String[] questions = readQuestionsFromTextArea(textArea);
                        writeQuestionsToCSV(questions, file);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(frame, "导出习题时出错：" + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }

    /**
     * 将一组习题显示在指定的文本区域中。
     *
     * @param questions 一组习题
     * @param textArea  用于显示习题的文本区域
     */
    public static void displayQuestions(String[] questions, JTextArea textArea) {
        // 清空文本区域
        textArea.setText("");

        // 每行最多打印5个字符串
        final int NUM_COLUMNS = 5;

        // 计算需要打印的行数
        int numRows = questions.length / NUM_COLUMNS;
        if (questions.length % NUM_COLUMNS != 0) {
            numRows++;
        }

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < NUM_COLUMNS; j++) {
                int index = i * NUM_COLUMNS + j;
                if (index < questions.length) {
                    textArea.append(questions[index] + "\t");
                }
            }
            textArea.append("\n");
        }

    }

    /**
     * 从 CSV 文件中读取习题。
     *
     * @param file CSV 文件
     * @return 存储着习题的字符串数组
     * @throws IOException 如果发生 I/O 错误，则抛出该异常
     */
    public static String[] readQuestionsFromCSV(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<String> questions = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            questions.add(line);
        }
        reader.close();
        return questions.toArray(new String[0]);
    }

    /**
     * 从文本区域中读取习题。
     *
     * @param textArea 存储着习题的文本区域
     * @return 存储着习题的字符串数组
     */
    public static String[] readQuestionsFromTextArea(JTextArea textArea) {
        String text = textArea.getText();
        return text.split("\n");
    }

    /**
     * 将一组习题写入 CSV 文件。
     *
     * @param questions 一组习题
     * @param file      CSV 文件
     * @throws IOException 如果发生 I/O 错误，则抛出该异常
     */
    public static void writeQuestionsToCSV(String[] questions, File file) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String question : questions) {
            writer.write(question);
            writer.newLine();
        }
        writer.close();
    }

    /**
     * 生成指定数量的加减法练习题。
     *
     * @param numQuestions 要生成的习题数量
     * @return 存储着生成的习题的字符串数组
     */
    public static String[] generateQuestions(int numQuestions) {
        String[] questions = new String[numQuestions];
        Random random = new Random();

        for (int i = 0; i < numQuestions; i++) {
            // 生成两个1~100之间的随机数
            int a = random.nextInt(100) + 1;
            int b = random.nextInt(100) + 1;

            // 随机选择加法或减法
            String operator;
            if (random.nextBoolean()) {
                operator = "+";
            } else {
                operator = "-";
            }

            // 生成习题
            String question = a + " " + operator + " " + b + " = ";
            questions[i] = question;
        }

        return questions;
    }
}
