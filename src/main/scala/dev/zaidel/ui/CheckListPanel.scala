package dev.zaidel.ui

import java.awt.BorderLayout
import java.awt.event.{ActionEvent, ActionListener, KeyEvent}
import java.io.File
import javax.swing._

class CheckListPanel extends JPanel with ReadFromFileWithFallback {
  private val resetKey = "reset"

  private val defaultCheckList = List(
    "Зашли за уровень",
    "Отошли",
    "Уровень отработал",
    "Назад не пустили",
    "3 бара есть",
    "Загиб",
    "Стоп за дневным уровнем",
    "Прошли не более 30% ATR",
  )

  def showPanel(): Unit = {
    val checklistItems = readWithFallback(new File("чек-лист.txt"), defaultCheckList)
      .map(label => new JCheckBox(label))

    JFrame.setDefaultLookAndFeelDecorated(true);

    val frame = new JFrame("Чек-лист сделки");
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setAlwaysOnTop(true)

    val resetButton = new JButton("Сбросить (N)")

    resetButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), resetKey
    )

    val checkPanel = new CheckboxList(checklistItems)

    val resetListener = new AbstractAction() {
      override def actionPerformed(e: ActionEvent): Unit = {
        checkPanel.reset()
      }
    }
    resetButton.getActionMap().put(resetKey, resetListener)

    val mainPanel = new JPanel(new BorderLayout())
    mainPanel.add(checkPanel, BorderLayout.CENTER)
    mainPanel.add(resetButton, BorderLayout.SOUTH)
    resetButton.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        checkPanel.reset()
      }
    })

    frame.setContentPane(mainPanel)

    frame.setResizable(false)
    frame.pack()
    frame.setVisible(true)
  }
}
