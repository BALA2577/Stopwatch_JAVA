import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch implements ActionListener {

    JFrame frame = new JFrame();
    JButton Start_btn = new JButton("Start");
    JButton reset_btn = new JButton("Reset");
    JLabel timelabel = new JLabel();
    int elapsedtime = 0;
    int seconds = 0;
    int minutes= 0;
        int hours = 0;
    boolean started = false;
    String seconds_str = String.format("%02d",seconds);
    String minutes_str = String.format("%02d",minutes);
    String hours_str = String.format("%02d",hours);

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedtime =  elapsedtime + 1000;
            hours = (elapsedtime/3600000);
            minutes = (elapsedtime/60000) % 60;
            seconds = (elapsedtime/1000)  % 60;
            String seconds_str = String.format("%02d",seconds);
            String minutes_str = String.format("%02d",minutes);
            String hours_str = String.format("%02d",hours);
            timelabel.setText(hours_str + ":"+minutes_str+":"+seconds_str);
        }
    });

    Stopwatch(){
        timelabel.setText(hours_str + ":"+minutes_str+":"+seconds_str);
        timelabel.setBounds(100,100,200,100);
        timelabel.setFont(new Font("Roboto",Font.PLAIN,40));
        timelabel.setBorder(BorderFactory.createBevelBorder(1));  // comeback //
        timelabel.setOpaque(true);
        timelabel.setHorizontalAlignment(JTextField.CENTER);

        Start_btn.setBounds(100,200,100,50);
        Start_btn.setFont(new Font("Roboto",Font.PLAIN,20));
        Start_btn.setFocusable(false);
        Start_btn.addActionListener(this);

        reset_btn.setBounds(200,200,100,50);
        reset_btn.setFont(new Font("Roboto",Font.PLAIN,20));
        reset_btn.setFocusable(false);
        reset_btn.addActionListener(this);

        frame.add(Start_btn);
        frame.add(reset_btn);
        frame.add(timelabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,400);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==Start_btn){

            start();
                if (started==false){
                    started=true;
                    Start_btn.setText("Stop");
                    start();
                }else {
                    started = false;
                    Start_btn.setText("Start");
                    stop();
                }
            }
        if(e.getSource()==reset_btn){
            started = false;
            Start_btn.setText("Start");
            reset();
        }
        }



        void start(){
            timer.start();
        }

        void stop(){
            timer.stop();
        }
        void reset(){
            timer.stop();
            elapsedtime = 0;
            seconds = 0;
            minutes = 0;
            hours = 0;
             seconds_str = String.format("%02d",seconds);
             minutes_str = String.format("%02d",minutes);
             hours_str = String.format("%02d",hours);
            timelabel.setText(hours_str + ":"+minutes_str+":"+seconds_str);

        }


    public static void main(String[] args) {
        Stopwatch stopwatch =  new Stopwatch();
    }
}
