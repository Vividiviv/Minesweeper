package minesweeper;
import javax.swing.JToggleButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class sweep extends javax.swing.JFrame {
    // -2 opened but no bomb
    // -1 has a bomb
    // 0 not open
    // 1-8 no of bombs around
    final int wid=10,hei=10,noOfBombs=9;
    JToggleButton blocks[][] = new JToggleButton[hei][wid];
    int blox[][]= new int[hei][wid];
    boolean start=false,canplay=true;//first or start
    ActionListener listen= new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
            @SuppressWarnings("UnusedAssignment")
          int i=0;int j=0;
          boolean found =false;
          for(i=0;i<wid;i++)
          { 
              for(j=0;j<hei;j++)
              {
                  if(e.getSource()==blocks[i][j])
                  {
                      found=true;
                      break;
                  }
              }
              if(found)
                  break;
          }
          if(canplay)
          {
          blocks[i][j].setSelected(true);
          if(!start){
              spawn(i,j);
              start=true;
          //blocks[i][j].setText("hello");
            }
            if(blox[i][j]!=-1)
            {
                open(i,j);
                reval();
            }
            else
                lose();
            win();
          }
          else
              reval();
      }
    };
    private void win()
    { 
        boolean won=true;
        for(int i=0;i<hei;i++)
        {
            for(int j=0;j<wid;j++)
            {
                if(blox[i][j]==0)
                {won=false;
                break;
                }
            }
            if(!won)
            break;
        }
        if(won)
        {javax.swing.JOptionPane.showMessageDialog(null,"CONGRATULATIONS YOU SOLVED THE GAME!!");
        canplay=false;
        }
        
   }
    private void lose()//shows position of all bombs
    {
        canplay=false;
        for(int i=0;i<hei;i++)
        {
            for(int j=0;j<wid;j++)
            {
                if(blox[i][j]==-1)
                {
                    blocks[i][j].setText("BOMB");
                    //blocks[i][j].setIcon(new ImageIcon())
                    blocks[i][j].setSelected(true);
                }
            }
        }
    }
    private void open(int y,int x)
    {
        if(y<0||x<0||x>wid-1||y>hei-1||blox[y][x]!=0)
            return ;
        int bombs=0;
        
        for(int i=y-1;i<=y+1;i++)
        {
            for(int j=x-1;j<=x+1;j++)
            {
                if(!(j<0||i<0||j>wid-1||i>hei-1)&& blox[i][j]==-1)
                {
                    bombs++;
                }
            }
        }
        if(bombs==0)
        {
            blox[y][x]=-2;
             for(int i=y-1;i<=y+1;i++)
            {
                for(int j=x-1;j<=x+1;j++)
                {
                    if(!(j<0||i<0||j>wid-1||i>hei-1))
                    {
                    if(!(i==y&&j==x))//not infinitely open the same blox
                        open(i,j);
                    }
                }
            }
        }
        else
            blox[y][x]=bombs;
    }
    private void reval()//to show the value of bombs on screen
    {
        for(int i=0;i<hei;i++) 
        {
            for(int j=0;j<wid;j++)
            {
                if(blox[i][j]==0)
                {
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(false);
                }
                if(blox[i][j]==-2)
                {
                    blocks[i][j].setText("");
                    blocks[i][j].setSelected(true);
                }
                if(blox[i][j]>0)
                {
                    blocks[i][j].setText(""+blox[i][j]);
                    blocks[i][j].setSelected(true);
                }
                if(!canplay&&blox[i][j]==-1)
                    blocks[i][j].setSelected(true);
                    
            }
        }
       jPanel1.repaint();
    }
    private void spawn(int y,int x)// placing bombs
    {
        for(int k=1;k<=noOfBombs;k++)
        {
            int i=0,j=0;
            do
            {
            i=(int)(Math.random()*wid-0.01);
            j=(int)(Math.random()*hei-0.01);    
            }while(blox[i][j]==-1||j==x&&i==y);
            blox[i][j]=-1;
            //blocks[i][j].setText("boom");
        }
    }
    public sweep() //constructor here called first
    {
        initComponents();
        for(int i=0;i<hei;i++)
        {
            for(int j=0;j<wid;j++)
            {
                blocks[i][j]= new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid,jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
                blocks[i][j].addActionListener(listen);
            }
        }
       start=false;
       canplay=true;
    }
    private void resiz()//resizing according to the window size
    {
        for(int i=0;i<hei;i++)
        {
            for(int j=0;j<wid;j++)
            {
                //blocks[i][j]= new JToggleButton();
                blocks[i][j].setSize(jPanel1.getWidth()/wid,jPanel1.getHeight()/hei);
                jPanel1.add(blocks[i][j]);
                blocks[i][j].setLocation(j*jPanel1.getWidth()/wid, i*jPanel1.getHeight()/hei);
            }
        }
    }
            
    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();

        jMenu3.setText("jMenu3");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        jMenu1.setText("Game");

        jCheckBoxMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("New Game");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        resiz();
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        blox= new int[hei][wid];
        reval();
        canplay= true;
        start=false;
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

  
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
            java.util.logging.Logger.getLogger(sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sweep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sweep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    // End of variables declaration//GEN-END:variables
}
