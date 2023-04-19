import java.awt.*;
public class App {
    public static void main(String[] args){
        TestFrame tf = new TestFrame();
        tf.init();
        while(true){
            if(tf.black.isSelected()){
                tf.drawPlane.setDrawColor(Color.BLACK);
            }
            if(tf.red.isSelected()){
                tf.drawPlane.setDrawColor(Color.RED);
            }
            //System.out.println(tf.drawPlane.keyPress);
        }
    }
}
