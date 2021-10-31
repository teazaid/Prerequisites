package dev.zaidel.ui

import java.awt.event.{ActionEvent, ActionListener, KeyEvent}
import java.awt.{BorderLayout, GridLayout}
import javax.swing.{AbstractAction, JButton, JComponent, JFrame, JPanel, JTabbedPane, KeyStroke, SwingConstants, WindowConstants}


class PrerequisitesPanel extends JPanel {
  def showPanel(): Unit = {
    JFrame.setDefaultLookAndFeelDecorated(true);

    //Create and set up the window.
    val frame = new JFrame("Предпосылки");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setAlwaysOnTop(true)

    val resetButton = new JButton("Сбросить (N)")

    val r = "reset"
    resetButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), r
    )

    val tabbedPane = new JTabbedPane()
    val breakOutPanel = new BreakoutPanel()
    val falseBreakoutPanel = new FalseBreakoutPanel()

    val resetListener = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit =  {
        breakOutPanel.reset()
        falseBreakoutPanel.reset()
      }
    }
    resetButton.getActionMap().put(r, resetListener)

    tabbedPane.addTab("Пробой (Z)", breakOutPanel)

    tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_Z, 0), "breakout"
    )
    tabbedPane.getActionMap().put("breakout", new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit =  {
        tabbedPane.setSelectedIndex(0)
      }
    })
    tabbedPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_X, 0), "false-breakout"
    )
    tabbedPane.getActionMap().put("false-breakout", new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit =  {
        tabbedPane.setSelectedIndex(1)
      }
    })

    tabbedPane.addTab("ЛП/Отбой (X)", falseBreakoutPanel)
    resetButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        breakOutPanel.reset()
        falseBreakoutPanel.reset()
      }
    })

    val top = new JPanel(new GridLayout(2, 1))
    top.add(new TrendPanel("ГТ"))
    top.add(new TrendPanel("ЛТ"))

    val mainPanel = new JPanel(new BorderLayout())
    mainPanel.add(top, BorderLayout.NORTH)
    mainPanel.add(tabbedPane, BorderLayout.CENTER)
    mainPanel.add(resetButton, BorderLayout.SOUTH)

    frame.setContentPane(mainPanel)

    frame.setResizable(false)
    frame.pack()
    frame.setVisible(true)
  }
}
