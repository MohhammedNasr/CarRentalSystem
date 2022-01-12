package CarRentalSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.net.Socket;
import javax.swing.*;

    public final class Server extends JFrame {

    ServerSocket server;
    Socket socket;
    BufferedReader br, br1;
    PrintWriter out;

    public JLabel heading = new JLabel("Admin");
    public JTextArea messageArea = new JTextArea();
    public JTextField messageInput = new JTextField();
    public Font font = new Font("Roboto", Font.PLAIN, 20);

    public Server() {
        try {
            server = new ServerSocket(9090);
            System.out.println("The server is ready to accept connection");
            System.out.println("waiting");
            socket = server.accept();

            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            createGUI();
            handleevents();
            startreading();
            startwritng();
        } catch (Exception e) {
        }

    }

    public void handleevents() {
        messageInput.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("Key relaeses" + e.getKeyCode());

                try {
                    if (e.getKeyCode() == 10) {

                        String contentSend = messageInput.getText();
                        messageArea.append("Me :" + contentSend + '\n');
                        out.println(contentSend);
                        out.flush();
                        messageInput.setText("");
                        messageInput.requestFocus();
                    }
                } catch (Exception exx) {

                }
            }
        });
    }

    public void createGUI() {
        this.setTitle("Admin");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        heading.setFont(font);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        messageArea.setFont(font);
        messageArea.setEditable(false);

        messageInput.setFont(font);
        messageInput.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(heading, BorderLayout.NORTH);
        JScrollPane jscrollPane = new JScrollPane(messageArea);
        this.add(jscrollPane, BorderLayout.CENTER);
        this.add(messageInput, BorderLayout.SOUTH);

        this.setVisible(true);

    }

    public void startreading() {
        Runnable r1 = () -> {
            System.out.println("reader started..");

            try {
                while (true) {

                    String msg = br.readLine();
                    if (msg.equals("exit")) {
                        System.out.println("Client Exited the chat");
                        JOptionPane.showMessageDialog(this, "Client Exited the chat");
                        messageInput.setEnabled(false);

                        socket.close();
                        break;
                    }
                    messageArea.append("Client : " + msg + "\n");

                }
            } catch (Exception ex) {
            }
        };
        new Thread(r1).start();

    }

    public void startwritng() {
        Runnable r2 = ()
                -> {
            System.out.println("writer started..");

            try {
                while (true) {
                    br1 = new BufferedReader(new InputStreamReader(System.in));
                    String content = br1.readLine();

                    if (content.equals("exit")) {
                        socket.close();
                        break;
                    }

                    out.println(content);
                    out.flush();
                }
            } catch (Exception ex) {
            }
        };

        new Thread(r2).start();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("The server is going to start");
        new Server();

    }

}

