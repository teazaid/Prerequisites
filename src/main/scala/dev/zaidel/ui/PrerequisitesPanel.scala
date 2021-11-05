package dev.zaidel.ui

import com.typesafe.config.ConfigFactory

import java.awt.event.{ActionEvent, ActionListener, KeyEvent}
import java.awt.{BorderLayout, GridLayout}
import java.io.File
import javax.swing._
import scala.jdk.CollectionConverters._

class PrerequisitesPanel extends JPanel with ReadFromFileWithFallback {
  private val resetKey = "reset"

  def showPanel(): Unit = {
    val config = ConfigFactory.load()
    val breakoutFallback = config.getStringList("breakout.list").asScala.toList

    val breakoutItems = readWithFallback(new File("пробой.txt"), breakoutFallback)
      .map(label => new JCheckBox(label))

    val falseBreakoutFallback = config.getStringList("false-breakout.list")
      .asScala
      .toList

    val falseBreakoutItems = readWithFallback(new File("отбой.txt"), falseBreakoutFallback)
      .map(label => new JCheckBox(label))

    JFrame.setDefaultLookAndFeelDecorated(true);

    val frame = new JFrame("Предпосылки");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setAlwaysOnTop(true)

    val resetButton = new JButton("Сбросить (N)")

    resetButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), resetKey
    )

    val tabbedPane = new JTabbedPane()
    val breakOutPanel = new CheckboxList(breakoutItems)
    val falseBreakoutPanel = new CheckboxList(falseBreakoutItems)

    val resetListener = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit =  {
        breakOutPanel.reset()
        falseBreakoutPanel.reset()
      }
    }
    resetButton.getActionMap().put(resetKey, resetListener)

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
