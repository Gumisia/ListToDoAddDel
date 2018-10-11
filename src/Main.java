import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//DONE sortowanie elementow
//DONE wywietlenie zaznaczonego elementu na konsoli

public class Main extends JFrame {
    public Main(){
        initcomponents();
    }

    private void initcomponents(){

        this.setTitle("Capitals");
        this.setBounds(700, 300, 300, 210);

        jList.setVisibleRowCount(9);
        jList.setFixedCellWidth(280);

        jList.setSelectionBackground(Color.YELLOW);
        jList.setSelectionForeground(Color.RED);

        jPanel.setLayout(new BorderLayout());

        jPanel.add(jTextField, BorderLayout.PAGE_START);
        jPanel.add(jScrollPane);

        this.getContentPane().add(jPanel, BorderLayout.CENTER);

        this.setContentPane(jPanel);

        jTextField.addActionListener(e -> {
            myModel.addElementList(jTextField.getText());
            myModel.sortList();
            jTextField.setText("");
        });

        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList)e.getSource();
                if(e.getClickCount()==2){
                    int index = list.locationToIndex(e.getPoint());
                    myModel.deleteElem(index);
                }
                if(e.getClickCount()==1){
                    int index = list.locationToIndex(e.getPoint());
                    System.out.println(myModel.getElementAt(index));
                }
            }
        });

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private JPanel jPanel = new JPanel();
    private JTextField jTextField = new JTextField();
    private MyModel myModel = new MyModel();
    private JList<String> jList = new JList<>(myModel);
    private JScrollPane jScrollPane = new JScrollPane(jList);


    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
