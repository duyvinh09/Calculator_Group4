/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package calculator;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;


/**
 *
 * @author dinhduyvinh
 */
public class calculatorForm extends javax.swing.JFrame {
    CardLayout cardLayout;
    private boolean darkMode = false; // Thêm biến để theo dõi trạng thái dark mode
    private ImageIcon darkIcon;
    private ImageIcon lightIcon;
    
    public calculatorForm() {
        initComponents();
        cardLayout = (CardLayout) historyMemoryForm.getLayout();
        listMemory.setModel(listModel);
        setLocationRelativeTo(null); // Đưa app sau khi chạy vào giữa màn hình
        setResizable(false); // chặn đổi size app
        
        darkIcon = new ImageIcon(getClass().getResource("/calculator/moon.png")); // Icon mặt trăng cho dark mode
        lightIcon = new ImageIcon(getClass().getResource("/calculator/sun.png")); // Icon mặt trời cho light mode
        applyLightMode(); // Áp dụng light mode mặc định khi khởi động
    }
    
    private ArrayList<String> history = new ArrayList<>(); // Lưu danh sách phép tính
    private DefaultListModel<String> listModel = new DefaultListModel<>(); // Model cho JList
    private double num1 = 0, num2 = 0;// Tạo hai biến num1, num 2 để luu giá trị nhập vào
    private double result;// biến resuilt để lưu kết quả
    private String operator = "";//biến chỉ toán tử
    private boolean newInput = true; // Đánh dấu để nhập số mới
    private String saveHistory = "";// Để luu toàn bộ phép tính
    
    // Phương thức áp dụng Dark Mode
    private void applyDarkMode() {
        // Đặt màu nền
        mainPanel.setBackground(new Color(30, 30, 30));
        calculatorForm.setBackground(new Color(30, 30, 30));
        historyMemoryForm.setBackground(new Color(30, 30, 30));
        historyPanel.setBackground(new Color(30, 30, 30));
        memoryPanel.setBackground(new Color(30, 30, 30));
        
        // Đặt màu cho display
        txtDisplay.setBackground(new Color(50, 50, 50));
        txtDisplay.setForeground(Color.WHITE);
        txtDisplay.setBorder(javax.swing.BorderFactory.createTitledBorder(
            null, "CALCULATOR", 
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
            javax.swing.border.TitledBorder.DEFAULT_POSITION, 
            new java.awt.Font("Segoe UI", 1, 12), Color.WHITE));
        
        // Đặt màu cho các nút
        styleButtons(new Color(50, 50, 50), Color.WHITE);
        
        // Đặt màu cho danh sách lịch sử
        listMemory.setBackground(new Color(50, 50, 50));
        listMemory.setForeground(Color.WHITE);
        
        // Đặt màu cho nhãn
        // jLabel1.setForeground(Color.WHITE);
        
        // Cập nhật trạng thái và văn bản nút
        darkMode = true;
        btnToggleMode.setIcon(lightIcon); // Hiển thị icon mặt trời khi ở dark mode (để chuyển sang light mode)
        btnToggleMode.setToolTipText("Chuyển sang Light Mode");
        btnToggleMode.setText("");
    }
    
    // Phương thức áp dụng Light Mode
    private void applyLightMode() {
        // Đặt màu nền
        mainPanel.setBackground(new Color(238, 238, 238));
        calculatorForm.setBackground(new Color(238, 238, 238));
        historyMemoryForm.setBackground(new Color(238, 238, 238));
        historyPanel.setBackground(new Color(238, 238, 238));
        memoryPanel.setBackground(new Color(238, 238, 238));
        
        // Đặt màu cho display
        txtDisplay.setBackground(Color.WHITE);
        txtDisplay.setForeground(Color.BLACK);
        txtDisplay.setBorder(javax.swing.BorderFactory.createTitledBorder(
            null, "CALCULATOR", 
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
            javax.swing.border.TitledBorder.DEFAULT_POSITION, 
            new java.awt.Font("Segoe UI", 1, 12), Color.BLACK));
        
        // Đặt màu cho các nút
        styleButtons(new Color(240, 240, 240), Color.BLACK);
        
        // Đặt màu cho danh sách lịch sử
        listMemory.setBackground(Color.WHITE);
        listMemory.setForeground(Color.BLACK);
        
        // Đặt màu cho nhãn
        // jLabel1.setForeground(Color.BLACK);
        
        // Cập nhật trạng thái và văn bản nút
        darkMode = false;
        btnToggleMode.setIcon(darkIcon); // Hiển thị icon mặt trăng khi ở light mode (để chuyển sang dark mode)
        btnToggleMode.setToolTipText("Chuyển sang Dark Mode");
        btnToggleMode.setText("");
    }
    
    // Phương thức hỗ trợ để đặt kiểu cho tất cả các nút
    private void styleButtons(Color bgColor, Color fgColor) {
        javax.swing.JButton[] buttons = {
            btnNumber0, btnDoiDau, btnDot, btnBang, btnNumber2, btnNumber1, btnNumber3,
            btnCong, btnTru, btnNumber4, btnNumber5, btnNumber6, btnNumber7, btnNumber9,
            btnNumber8, btnNhan, btnnghichDao, btnPow, btnChia, btnSqrt, btnPhanTram,
            btnDelete, btnCE, btnC
        };
        
        for (javax.swing.JButton button : buttons) {
            button.setBackground(bgColor);
            button.setForeground(fgColor);
        }
        
        // Giữ màu đặc biệt cho nút bằng
        btnBang.setBackground(new Color(0, 153, 255));
        btnBang.setForeground(Color.WHITE);
    }
    
    // Phương thức áp dụng phông chữ cho các thành phần giao diện
    private void applyFontToComponents(Font font) {
        // Áp dụng phông chữ cho các nút
        javax.swing.JButton[] buttons = {
            btnNumber0, btnDoiDau, btnDot, btnBang, btnNumber2, btnNumber1, btnNumber3,
            btnCong, btnTru, btnNumber4, btnNumber5, btnNumber6, btnNumber7, btnNumber9,
            btnNumber8, btnNhan, btnnghichDao, btnPow, btnChia, btnSqrt, btnPhanTram,
            btnDelete, btnCE, btnC
        };
        for (javax.swing.JButton button : buttons) {
            button.setFont(font);
        }
        
        // Áp dụng phông chữ cho txtDisplay
        txtDisplay.setFont(font);
        
        // Áp dụng phông chữ cho listMemory
        listMemory.setFont(font);
        
        // Áp dụng phông chữ cho jLabel1
        jLabel1.setFont(font);
        
        // Áp dụng phông chữ cho nút toggle mode
        btnToggleMode.setFont(font);
    }

    // Phương thức áp dụng màu nền tùy chỉnh
    private void applyCustomBackground(Color color) {
        mainPanel.setBackground(color);
        calculatorForm.setBackground(color);
        historyMemoryForm.setBackground(color);
        historyPanel.setBackground(color);
        memoryPanel.setBackground(color);
        
        // Điều chỉnh màu chữ và viền của txtDisplay dựa trên độ sáng của màu nền
        float[] hsb = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        boolean isDarkBackground = hsb[2] < 0.5; // Nếu độ sáng < 50%, coi là nền tối
        Color textColor = isDarkBackground ? Color.WHITE : Color.BLACK;
        
        txtDisplay.setBackground(color.brighter());
        txtDisplay.setForeground(textColor);
        txtDisplay.setBorder(javax.swing.BorderFactory.createTitledBorder(
            null, "CALCULATOR", 
            javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, 
            javax.swing.border.TitledBorder.DEFAULT_POSITION, 
            txtDisplay.getFont(), textColor));
        
        // Điều chỉnh màu chữ của listMemory và jLabel1
        listMemory.setBackground(color.brighter());
        listMemory.setForeground(textColor);
        jLabel1.setForeground(textColor);
        
        // Cập nhật màu nút dựa trên chế độ tối/sáng
        styleButtons(color.brighter(), textColor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        calculatorForm = new javax.swing.JPanel();
        btnNumber0 = new javax.swing.JButton();
        btnDoiDau = new javax.swing.JButton();
        btnDot = new javax.swing.JButton();
        btnBang = new javax.swing.JButton();
        btnNumber2 = new javax.swing.JButton();
        btnNumber1 = new javax.swing.JButton();
        btnNumber3 = new javax.swing.JButton();
        btnCong = new javax.swing.JButton();
        btnTru = new javax.swing.JButton();
        btnNumber4 = new javax.swing.JButton();
        btnNumber5 = new javax.swing.JButton();
        btnNumber6 = new javax.swing.JButton();
        btnNumber7 = new javax.swing.JButton();
        btnNumber9 = new javax.swing.JButton();
        btnNumber8 = new javax.swing.JButton();
        btnNhan = new javax.swing.JButton();
        btnnghichDao = new javax.swing.JButton();
        btnPow = new javax.swing.JButton();
        btnChia = new javax.swing.JButton();
        btnSqrt = new javax.swing.JButton();
        btnPhanTram = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCE = new javax.swing.JButton();
        btnC = new javax.swing.JButton();
        txtDisplay = new javax.swing.JTextField();
        btnToggleMode = new javax.swing.JToggleButton();
        historyMemoryForm = new javax.swing.JPanel();
        historyPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listMemory = new javax.swing.JList<>();
        memoryPanel = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        JMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNumber0.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNumber0.setText("0");
        btnNumber0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber0ActionPerformed(evt);
            }
        });

        btnDoiDau.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiDau.setText("+/-");
        btnDoiDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiDauActionPerformed(evt);
            }
        });

        btnDot.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnDot.setText(".");
        btnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDotActionPerformed(evt);
            }
        });

        btnBang.setBackground(new java.awt.Color(0, 153, 255));
        btnBang.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnBang.setText("=");
        btnBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBangActionPerformed(evt);
            }
        });

        btnNumber2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber2.setText("2");
        btnNumber2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber2ActionPerformed(evt);
            }
        });

        btnNumber1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber1.setText("1");
        btnNumber1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber1ActionPerformed(evt);
            }
        });

        btnNumber3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber3.setText("3");
        btnNumber3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber3ActionPerformed(evt);
            }
        });

        btnCong.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnCong.setText("+");
        btnCong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCongActionPerformed(evt);
            }
        });

        btnTru.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnTru.setText("-");
        btnTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTruActionPerformed(evt);
            }
        });

        btnNumber4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber4.setText("4");
        btnNumber4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber4ActionPerformed(evt);
            }
        });

        btnNumber5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber5.setText("5");
        btnNumber5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber5ActionPerformed(evt);
            }
        });

        btnNumber6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber6.setText("6");
        btnNumber6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber6ActionPerformed(evt);
            }
        });

        btnNumber7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber7.setText("7");
        btnNumber7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber7ActionPerformed(evt);
            }
        });

        btnNumber9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber9.setText("9");
        btnNumber9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber9ActionPerformed(evt);
            }
        });

        btnNumber8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnNumber8.setText("8");
        btnNumber8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNumber8ActionPerformed(evt);
            }
        });

        btnNhan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNhan.setText("x");
        btnNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanActionPerformed(evt);
            }
        });

        btnnghichDao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnnghichDao.setText("1/X");
        btnnghichDao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnghichDaoActionPerformed(evt);
            }
        });

        btnPow.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPow.setText("x²");
        btnPow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPowActionPerformed(evt);
            }
        });

        btnChia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnChia.setText("/");
        btnChia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiaActionPerformed(evt);
            }
        });

        btnSqrt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSqrt.setText("²√x");
        btnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSqrtActionPerformed(evt);
            }
        });

        btnPhanTram.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPhanTram.setText("%");
        btnPhanTram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPhanTramActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/calculator/delete.png"))); // NOI18N
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDelete.setSelected(true);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCE.setText("CE");
        btnCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEActionPerformed(evt);
            }
        });

        btnC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnC.setText("C");
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        txtDisplay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDisplay.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CALCULATOR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        txtDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDisplayActionPerformed(evt);
            }
        });

        btnToggleMode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnToggleMode.setText("Dark/Light");
        btnToggleMode.setActionCommand("btnToggleMode");
        btnToggleMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToggleModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout calculatorFormLayout = new javax.swing.GroupLayout(calculatorForm);
        calculatorForm.setLayout(calculatorFormLayout);
        calculatorFormLayout.setHorizontalGroup(
            calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorFormLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorFormLayout.createSequentialGroup()
                                .addComponent(btnPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCE, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorFormLayout.createSequentialGroup()
                                .addComponent(btnnghichDao, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPow, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnChia, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorFormLayout.createSequentialGroup()
                                .addComponent(btnNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorFormLayout.createSequentialGroup()
                                .addComponent(btnNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTru, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(calculatorFormLayout.createSequentialGroup()
                        .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(calculatorFormLayout.createSequentialGroup()
                                .addComponent(btnNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(calculatorFormLayout.createSequentialGroup()
                                .addComponent(btnDoiDau, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNumber0, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBang, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnToggleMode))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        calculatorFormLayout.setVerticalGroup(
            calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(calculatorFormLayout.createSequentialGroup()
                .addComponent(btnToggleMode)
                .addGap(39, 39, 39)
                .addComponent(txtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPhanTram, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCE, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnC, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDelete, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnnghichDao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnPow, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSqrt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnChia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNumber7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNumber4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDoiDau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNumber0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, calculatorFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBang, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(calculatorForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(calculatorForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        historyMemoryForm.setLayout(new java.awt.CardLayout());

        listMemory.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        listMemory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listMemory);

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );

        historyMemoryForm.add(historyPanel, "card2");

        jTextField3.setText("jTextField3");

        javax.swing.GroupLayout memoryPanelLayout = new javax.swing.GroupLayout(memoryPanel);
        memoryPanel.setLayout(memoryPanelLayout);
        memoryPanelLayout.setHorizontalGroup(
            memoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
        );
        memoryPanelLayout.setVerticalGroup(
            memoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        historyMemoryForm.add(memoryPanel, "card2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MEMORY");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JMenu.setText("Tùy chỉnh");

        jMenuItem1.setText("Chọn phông chữ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        JMenu.add(jMenuItem1);

        jMenuItem2.setText("Chọn màu giao diện");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        JMenu.add(jMenuItem2);

        jMenuItem3.setText("Reset về mặc định");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        JMenu.add(jMenuItem3);

        jMenuBar1.add(JMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(historyMemoryForm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(historyMemoryForm, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Hàm định dạng số nguyên
    private String formatNumber(double num){
        return (num == Math.floor(num)) ? String.valueOf((int) num) : String.valueOf(num);
    }
    // Hàm tính toán
    private double  calculate(double a, String op, double b){
        switch(op){
            case "+": return a + b;
            case "-": return a - b;
            case "x": return a * b; 
            case "/":
                if (b == 0) throw new ArithmeticException("Lỗi!");
                return a / b;
            default: return b;
        }
    }
    
    // Hàm xử lí toán tử
    private void operatorActionPerformed(String newOperator) {
        try {
            double temp = Double.parseDouble(txtDisplay.getText());

            if (!operator.isEmpty()) { 
                // Nếu đã có phép toán trước đó, thực hiện tính toán
                num2 = temp;
                num1 = calculate(num1, operator, num2);
                //Hiển thị kết quả dưới dạng số nguyên
                txtDisplay.setText(formatNumber(num1));
                // Cập nhật lịch sử phép tính
                saveHistory += " " + operator + " " + formatNumber(num2);
                txtDisplay.setText(formatNumber(num1));
            } else {
                num1 = temp; // Nếu chưa có phép toán trước đó, lưu num1
                saveHistory = formatNumber(num1);
            }

            operator = newOperator; // Cập nhật toán tử mới
            newInput = true; // Chuẩn bị nhập số tiếp theo
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi");
        } catch (ArithmeticException e) {
            txtDisplay.setText(e.getMessage());
        }
    }
    
    
    private void txtDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDisplayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDisplayActionPerformed

    private void btnPhanTramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPhanTramActionPerformed
        try {
            double num = Double.parseDouble(txtDisplay.getText()); // Lấy số hiện tại
            result = num / 100; // Chia cho 100
            txtDisplay.setText(String.valueOf(result)); // Hiển thị kết quả
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi"); // Nếu nhập không hợp lệ
        }
    }//GEN-LAST:event_btnPhanTramActionPerformed

    private void btnnghichDaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnghichDaoActionPerformed
        try {
            double num = Double.parseDouble(txtDisplay.getText()); // Lấy số hiện tại
            if (num == 0) {
                txtDisplay.setText("Lỗi"); // Tránh chia cho 0
            } else {
                result = 1 / num; // Tính nghịch đảo
                txtDisplay.setText(String.valueOf(result)); // Hiển thị kết quả
            }
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi"); // Nếu nhập không hợp lệ
        }
    }//GEN-LAST:event_btnnghichDaoActionPerformed

    private void btnNumber7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber7ActionPerformed
        if (newInput) {
            txtDisplay.setText("7");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "7");
        }
    }//GEN-LAST:event_btnNumber7ActionPerformed

    private void btnNumber4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber4ActionPerformed
        if (newInput) {
            txtDisplay.setText("4");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "4");
        }
    }//GEN-LAST:event_btnNumber4ActionPerformed

    private void btnNumber1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber1ActionPerformed
        if (newInput) {
            txtDisplay.setText("1");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "1");
        }
    }//GEN-LAST:event_btnNumber1ActionPerformed

    private void btnDoiDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiDauActionPerformed
        try {
            double num = Double.parseDouble(txtDisplay.getText()); // Lấy số hiện tại
            num = -num; // Đổi dấu
            if (num == Math.floor(num)) {
                // Nếu kết quả là số nguyên thì ép kiểu int cho result rồi in
                txtDisplay.setText(String.valueOf((int) num));
            } else {
                txtDisplay.setText(String.valueOf(num)); // Hiển thị bình thường
            }
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi"); // Nếu nhập không hợp lệ
        }
    }//GEN-LAST:event_btnDoiDauActionPerformed

    private void btnNumber2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber2ActionPerformed
        if (newInput) {
            txtDisplay.setText("2");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "2");
        }
    }//GEN-LAST:event_btnNumber2ActionPerformed

    private void btnNumber3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber3ActionPerformed
        if (newInput) {
            txtDisplay.setText("3");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "3");
        }
    }//GEN-LAST:event_btnNumber3ActionPerformed

    private void btnNumber5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber5ActionPerformed
        if (newInput) {
            txtDisplay.setText("5");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "5");
        }
    }//GEN-LAST:event_btnNumber5ActionPerformed

    private void btnNumber6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber6ActionPerformed
        if (newInput) {
            txtDisplay.setText("6");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "6");
        }
    }//GEN-LAST:event_btnNumber6ActionPerformed

    private void btnNumber8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber8ActionPerformed
        if (newInput) {
            txtDisplay.setText("8");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "8");
        }
    }//GEN-LAST:event_btnNumber8ActionPerformed

    private void btnNumber9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber9ActionPerformed
        if (newInput) {
            txtDisplay.setText("9");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "9");
        }
    }//GEN-LAST:event_btnNumber9ActionPerformed

    private void btnCongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCongActionPerformed
        operatorActionPerformed("+");
    }//GEN-LAST:event_btnCongActionPerformed

    private void btnTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTruActionPerformed
        operatorActionPerformed("-");
    }//GEN-LAST:event_btnTruActionPerformed

    private void btnNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanActionPerformed
        operatorActionPerformed("x");
    }//GEN-LAST:event_btnNhanActionPerformed

    private void btnChiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiaActionPerformed
        operatorActionPerformed("/");
    }//GEN-LAST:event_btnChiaActionPerformed

    private void btnBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBangActionPerformed
        try {
            double temp = Double.parseDouble(txtDisplay.getText());

            if (!operator.isEmpty()) {
                // Nếu đã có phép tính trước đó, thực hiện tính toán
                num2 = temp;
                num1 = calculate(num1, operator, num2);

                // Bắt đầu lưu vào lịch sử
                // Hoàn thành chuỗi phép tính
                saveHistory += " " + operator + " " + formatNumber(num2) + " = " + formatNumber(num1);
                txtDisplay.setText(formatNumber(num1));

                // Thêm vào lịch sử
                listModel.addElement(saveHistory);
            }
            operator = "";
            newInput = true; // Đánh dấu để nhập số mới
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi");
        } catch (ArithmeticException e) {
            txtDisplay.setText(e.getMessage());
        }
    }//GEN-LAST:event_btnBangActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
        txtDisplay.setText("");
        saveHistory = "";
        num1 = 0;
        num2 = 0;
        operator = "";
        newInput = true;
    }//GEN-LAST:event_btnCActionPerformed

    private void btnCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEActionPerformed
        txtDisplay.setText("");
        newInput = true;
    }//GEN-LAST:event_btnCEActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String text = txtDisplay.getText();
        if (!text.isEmpty()) {
            txtDisplay.setText(text.substring(0, text.length() - 1));
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnPowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPowActionPerformed
        try {
            double num = Double.parseDouble(txtDisplay.getText()); // Lấy số hiện tại
            result = num * num; // Bình phương số
            txtDisplay.setText(String.valueOf(result)); // Hiển thị kết quả
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi"); // Nếu nhập không hợp lệ
        }
    }//GEN-LAST:event_btnPowActionPerformed

    private void btnSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSqrtActionPerformed
        try {
            double num = Double.parseDouble(txtDisplay.getText()); // Lấy số hiện tại
            if (num < 0) {
                txtDisplay.setText("Lỗi"); // Không tính căn số âm
            } else {
                result = Math.sqrt(num); // Tính căn bậc hai
                txtDisplay.setText(String.valueOf(result)); // Hiển thị kết quả
            }
        } catch (NumberFormatException e) {
            txtDisplay.setText("Lỗi"); // Nếu nhập không hợp lệ
        }
    }//GEN-LAST:event_btnSqrtActionPerformed

    private void btnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDotActionPerformed
        String text = txtDisplay.getText();

        // Kiểm tra nếu chưa có dấu chấm trong số hiện tại
        if (!text.contains(".")) {
            txtDisplay.setText(text + ".");
        }
    }//GEN-LAST:event_btnDotActionPerformed

    private void btnNumber0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNumber0ActionPerformed
        // TODO add your handling code here:
        if (newInput) {
            txtDisplay.setText("0");
            newInput = false;
        } else {
            txtDisplay.setText(txtDisplay.getText() + "0");
        }
    }//GEN-LAST:event_btnNumber0ActionPerformed

    private void btnToggleModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToggleModeActionPerformed
        // TODO add your handling code here:
        if (darkMode) {
            applyLightMode();
        } else {
            applyDarkMode();
        }
    }//GEN-LAST:event_btnToggleModeActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        // Tạo danh sách phông chữ khả dụng
        String[] fonts = {"Arial", "Times New Roman", "Courier New", "Verdana", "Tahoma"};
        JList<String> fontList = new JList<>(fonts);
        JScrollPane scrollPane = new JScrollPane(fontList);
        
        // Tạo dialog để chọn phông chữ
        JDialog fontDialog = new JDialog(this, "Chọn phông chữ", true);
        fontDialog.setLayout(new java.awt.FlowLayout());
        fontDialog.add(scrollPane);
        fontDialog.setSize(200, 200);
        fontDialog.setLocationRelativeTo(this);
        
        fontList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedFont = fontList.getSelectedValue();
                if (selectedFont != null) {
                    // Áp dụng phông chữ mới với kích thước mặc định là 18
                    applyFontToComponents(new Font(selectedFont, Font.PLAIN, 18));
                    fontDialog.dispose();
                }
            }
        });
        
        fontDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        // Mở JColorChooser để chọn màu nền
        Color selectedColor = JColorChooser.showDialog(this, "Chọn màu nền", mainPanel.getBackground());
        if (selectedColor != null) {
            applyCustomBackground(selectedColor);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        applyLightMode();
        applyFontToComponents(new Font("Segoe UI", Font.PLAIN, 18));
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calculatorForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calculatorForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu JMenu;
    private javax.swing.JButton btnBang;
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnChia;
    private javax.swing.JButton btnCong;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDoiDau;
    private javax.swing.JButton btnDot;
    private javax.swing.JButton btnNhan;
    private javax.swing.JButton btnNumber0;
    private javax.swing.JButton btnNumber1;
    private javax.swing.JButton btnNumber2;
    private javax.swing.JButton btnNumber3;
    private javax.swing.JButton btnNumber4;
    private javax.swing.JButton btnNumber5;
    private javax.swing.JButton btnNumber6;
    private javax.swing.JButton btnNumber7;
    private javax.swing.JButton btnNumber8;
    private javax.swing.JButton btnNumber9;
    private javax.swing.JButton btnPhanTram;
    private javax.swing.JButton btnPow;
    private javax.swing.JButton btnSqrt;
    private javax.swing.JToggleButton btnToggleMode;
    private javax.swing.JButton btnTru;
    private javax.swing.JButton btnnghichDao;
    private javax.swing.JPanel calculatorForm;
    private javax.swing.JPanel historyMemoryForm;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JList<String> listMemory;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel memoryPanel;
    private javax.swing.JTextField txtDisplay;
    // End of variables declaration//GEN-END:variables
}
